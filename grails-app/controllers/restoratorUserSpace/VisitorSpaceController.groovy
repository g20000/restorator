package restoratorUserSpace

import org.joda.time.LocalTime
import org.joda.time.format.DateTimeFormat
import org.joda.time.format.DateTimeFormatter

import restorator.Cafee
import restorator.HallsZones
import restorator.PaymentSystemsHandler
import restorator.ReservedTable
import restorator.TablePlacesInfo
import restorator.auth.Authority
import restorator.auth.Person
import billingMock.PaymentSystems
import billingMock.PaymentSystemsAvailable
import extApiHandler.ApiHandlerController
import extApiMock.ApiRequest
import grails.plugin.springsecurity.SpringSecurityService
import grails.plugin.springsecurity.annotation.Secured


class VisitorSpaceController {
	def springSecurityService = new SpringSecurityService()
	private def cafeeInfo
	private def MIN_QUERY_NAME_SIZE = 3
	private def CHECK_BILL = "check_bill"
	private def DO_PAYMENT = "do_payment"
	private def MINUTE_ZERO = 0
	
	@Secured(['ROLE_ADMIN', 'ROLE_VISITOR', 'ROLE_ROOT_ADMIN'])
    def index() {				
		try {
			def user = springSecurityService.currentUser
					Authority rootAdminAuthority = Authority.findByAuthority('ROLE_ROOT_ADMIN')
					if(user.getAuthorities().contains(rootAdminAuthority)){
						redirect(controller: "RootAdminSpace")
						return
					}
			if(user.isAdminCafee){			
				showAdminSpace()
			}else{
				if(params.containsKey('cafeeName')){
					def month
					switch(Integer.parseInt(params['reservationDate_month']) - 1){
					case 0: month = Calendar.JANUARY
							break
					case 1: month = Calendar.FEBRUARY
					break
					case 2: month = Calendar.MARCH
					break
					case 3: month = Calendar.APRIL
					break
					case 4: month = Calendar.MAY
					break
					case 5: month = Calendar.JUNE
					break
					case 6: month = Calendar.JULY
					break
					case 7: month = Calendar.AUGUST
					break
					case 8: month = Calendar.SEPTEMBER
					break
					case 9: month = Calendar.OCTOBER
					break
					case 10: month = Calendar.NOVEMBER
					break
					case 11: month = Calendar.DECEMBER
					break
					default: break
					}
					def tempDate = new Date()
					tempDate.set(year: Integer.parseInt(params['reservationDate_year']), month: month, dayOfMonth: Integer.parseInt(params['reservationDate_day']))
					params.put('reservationDate', tempDate)
					goToPaymentPage(params)
				}else{
					showVisitorSpace()
				}
			}
		} catch (Exception e) {
			render (view:'error.gsp')
			e.printStackTrace()
		}
	}
	
	@Secured(['ROLE_VISITOR'])
	def showVisitorSpace(){
		try {
			ArrayList<Cafee>allCafees = Cafee.findAllByIsReservationAvailable(true)
			ArrayList<Cafee>availableCafee = new ArrayList<Cafee>()		
			ApiRequest apiRequest
			for(Cafee cafee : allCafees){
				if(cafee.apiInit != ""){
					apiRequest = ApiHandlerController.request(cafee.apiInit)
							availableCafee.add(new Cafee(cafeeName: apiRequest.cafeeName, placeCost: apiRequest.placeCost, currencyType: apiRequest.currencyType, apiInit: apiRequest.apiInit,
								region: apiRequest.getRegion(), city: apiRequest.getCity()))
				}else{
					availableCafee.add(cafee)
				}
			}
			
			render (view:'index.gsp', model: [availableCafee: availableCafee])
		} catch (Exception e) {
			render (view:'error.gsp')
			e.printStackTrace()
		}
	}
	
	@Secured(['ROLE_ADMIN'])
	def showAdminSpace(){
		try {
			def user = Person.findByUsername(springSecurityService.currentUser.username)
			def placeinfo = user.cafee
			render (view:'adminCafeeSpace/indexAdmin.gsp', model: [placeinfo: placeinfo])
		} catch (Exception e) {
			render (view:'error.gsp')
			e.printStackTrace()
		}
	}
	
	@Secured(['ROLE_ADMIN', 'ROLE_VISITOR'])
	def editPrivateData(){
		try {
			def user = springSecurityService.currentUser
			if(user.isAdminCafee){
				render (view:'adminCafeeSpace/editPrivateData.gsp', model: [user: user])
			}else{
				render (view:'editPrivateData.gsp', model: [user: user])
			}
		} catch (Exception e) {
			render (view:'error.gsp')
			e.printStackTrace()
		}
	}
	
	@Secured(['ROLE_VISITOR'])
	def goToCafeePage(params){
		ApiRequest apiRequest
		def goalCafee
		try {
			if(params['cafeeApiInit'] != ""){
				apiRequest = ApiHandlerController.request(params['cafeeApiInit'])
				goalCafee = new Cafee(cafeeName: apiRequest.cafeeName, placeCost: apiRequest.placeCost, currencyType: apiRequest.currencyType, apiInit: apiRequest.apiInit, 
						endTimeLimit : apiRequest.endTimeLimit)
				
				ArrayList<Integer>tablePlaces = new ArrayList<Integer>()
				for(int places : apiRequest.places){
					tablePlaces.add(new TablePlacesInfo(placesInTableAmount : places))
				}
				
				ArrayList<String>hallNames = new ArrayList<String>()
				for(String hall : apiRequest.halls){
					hallNames.add(hall)
				}
				
				render (view:'cafeeInfo.gsp', model: [cafeeName: goalCafee, tableInfo: tablePlaces, halls: hallNames])
			}else{
				goalCafee = Cafee.findByCafeeName(params['cafeeName'])
					def halls = HallsZones.findAllWhere(cafee : goalCafee)
					def tablePlacesQuery = TablePlacesInfo.createCriteria()			
					def tablePlaces = tablePlacesQuery.list {
					'in'("hall", halls)
				}
				
				ArrayList<String>hallNames = new ArrayList<String>()
				for(def hall : halls){
					hallNames.add(hall.getHallName())
				}
				
				render (view:'cafeeInfo.gsp', model: [cafeeName: goalCafee, tableInfo: tablePlaces, halls: hallNames])
			}
		} catch (Exception e) {
			render (view:'error.gsp')
			e.printStackTrace()
		}
	}
	
	@Secured(['ROLE_VISITOR'])
	def makeReserve(params, paymentSystem, bill, costForPay){
		def apiRequest
		def endTimeReservation
		try {
			Person user  = Person.findByUsername(springSecurityService.currentUser.username)
			if(params['cafeeApiInit'] != ""){
				apiRequest = ApiHandlerController.request(params['cafeeApiInit'], "TO_RESERVE", params)
				if(apiRequest instanceof Integer){
					render (view:'error.gsp', model: [error: apiRequest])
					return
				}else if(apiRequest instanceof String){
					def errorCode = 17
					render (view:'error.gsp', model: [error: errorCode, message: apiRequest])
					return
				}
				def extCafee = Cafee.findWhere(apiInit: params['cafeeApiInit'])
						def startTimeReservation = new LocalTime(Integer.parseInt(params['startTimeReservation_hour']), MINUTE_ZERO)
				if((params.containsKey('endTimeReservation_hour'))/*&&(params.containsKey('endTimeReservation_minute'))*/){
					endTimeReservation = new LocalTime (Integer.parseInt(params['endTimeReservation_hour']), MINUTE_ZERO)
				}
				ReservedTable myPlace = new ReservedTable(visitor: user, cafeeName: extCafee, startTimeLimit: startTimeReservation, endTimeLimit: endTimeReservation,
						reservationDate: params['reservationDate'], places: apiRequest.placesInSelectedTable, cost: apiRequest.totalCost, hall: apiRequest.selectedHall)
				if(!myPlace.save(flush: true)){
					myPlace.errors.each {
						println it
					}
				}
				PaymentSystemsHandler.paymentRequest(paymentSystem, DO_PAYMENT, bill, costForPay)
			}else{
				Cafee cafee = Cafee.findByCafeeName(params['cafeeName'])
				def startTimeReservation = new LocalTime(Integer.parseInt(params['startTimeReservation_hour']), MINUTE_ZERO)
				endTimeReservation = new LocalTime(Integer.parseInt(params['endTimeReservation_hour']), MINUTE_ZERO)
				
				if(startTimeReservation >= endTimeReservation){
					def errorCode = 4
					render (view:'error.gsp', model: [error: errorCode])//render "Start time reservation can not be more than end time reservation!"
					return
				}
				
				if(!cafee.isReservationAvailable){
					def errorCode = 1
					render (view:'error.gsp', model: [error: errorCode])
					return
				}
				
				if(cafee.reservationDateLimit && (!((cafee.startDateLimit <= params['reservationDate']) && (cafee.endDateLimit >= params['reservationDate'])))){
					def errorCode = 5
					def stDateLimit = cafee.startDateLimit
					def endDateLimit = cafee.endDateLimit
					render (view:'error.gsp', model: [error: errorCode, stDate: stDateLimit, endDate: endDateLimit])//render "You can reserve a place in this cafee between " + cafee.startDateLimit + " and " + cafee.endDateLimit
					return
				}
				
				if(cafee.reservationTimeLimit && (!((cafee.startTimeLimit <= startTimeReservation) && (cafee.endTimeLimit >= startTimeReservation)
						&& (cafee.startTimeLimit <= endTimeReservation) && (cafee.endTimeLimit >= endTimeReservation)))){
					def errorCode = 6
							def stTimeLimit = cafee.startTimeLimit
							def endTimeLimit = cafee.endTimeLimit
							render (view:'error.gsp', model: [error: errorCode, stTime: stTimeLimit, endTime: endTimeLimit])//render "You can reserve a place in this cafee between " + cafee.startTimeLimit + " and " + cafee.endTimeLimit				
							return
				}	
				
				if(cafee.totalReservationPlaces < 1){
					def errorCode = 2				
							render (view:'error.gsp', model: [error: errorCode])//render "Sorry, no more free places in this cafee for reservation"
							return
				}
				
				Person owner = Person.findByCafee(cafee)
						
						def table = TablePlacesInfo.where {
					placesInTableAmount == Integer.parseInt(params['tablePlacesAvailable'])
							hall {
						hallName == params['hallsAvailable']
								cafee {
							cafeeName == cafee.getCafeeName()
						}
					}
				}.get()
				
				if(table.tableForReservationAmount < 1){
					def errorCode = 3
							render (view:'error.gsp', model: [error: errorCode])//render "Sorry, no more such tables for reservation"
							return
				}
				
				cafee.totalReservationPlaces -= 1
						table.tableForReservationAmount -= 1
						if(!table.save()){
							table.errors.each {
								println it
							}
						}
				
				if(!cafee.save()){
					cafee.errors.each {
						println it
					}
				}
				double cost = table.getPlaceCost()
				ReservedTable myPlace = new ReservedTable(visitor: user, owner: owner, cafeeName: cafee, startTimeLimit: startTimeReservation, endTimeLimit: endTimeReservation,
						reservationDate: params['reservationDate'], places: Integer.parseInt(params['tablePlacesAvailable']), cost: cost, hall: params['hallsAvailable'])
				if(!myPlace.save(flush: true)){
					myPlace.errors.each {
						println it
					}
				}
				PaymentSystemsHandler.paymentRequest(paymentSystem, DO_PAYMENT, bill, costForPay)
			}
			showReservedTableForVisitor()
		} catch (Exception e) {
			render (view:'error.gsp')
			e.printStackTrace()
		}
	}
	
	@Secured(['ROLE_VISITOR'])
	def showReservedTableForVisitor(){
		try {
			DateTimeFormatter timeFormat = DateTimeFormat.forPattern("HH:mm")
			def user = Person.findByUsername(springSecurityService.currentUser.username)
			def myTables = ReservedTable.findAllByVisitor(user)
			List<ReservedTable>reservedTables = new ArrayList<Cafee>()
			ApiRequest apiRequest
			Cafee extCafee
			for(ReservedTable table : myTables){
				if(table.cafeeName.apiInit != ""){
					apiRequest = ApiHandlerController.request(table.cafeeName.apiInit)
							extCafee = new Cafee(cafeeName: apiRequest.cafeeName)
					table.cafeeName.cafeeName = extCafee.cafeeName
					reservedTables.add(table)
				}else{
					reservedTables.add(table)
				}
			}
	
			render (view:'reserved.gsp', model: [tableInfo: reservedTables, timeForm: timeFormat])
		} catch (Exception e) {
			render (view:'error.gsp')
			e.printStackTrace()
		}
	}
	
	@Secured(['ROLE_VISITOR'])//переделать с учетом api
	def deleteReservedTable(params){
		try {
			def user = Person.findByUsername(springSecurityService.currentUser.username)
			ApiRequest apiRequest
			if(params['cafeeAPI'] != ""){
				apiRequest = ApiHandlerController.request(params['cafeeAPI'], "TO_DELETE", params)
						def myPlace = ReservedTable.findByVisitorAndCafeeName(user, Cafee.findByApiInit(params['cafeeAPI']))
						myPlace.delete(flush: true)
			}else{
				def myPlace = ReservedTable.findByVisitorAndCafeeNameAndPlaces(user, Cafee.findByCafeeName(params['cafeeName']), Integer.parseInt(params['placesAmount']))
						def cafee = Cafee.findByCafeeName(params['cafeeName'])			
						def table = TablePlacesInfo.where {
					placesInTableAmount == Integer.parseInt(params['placesAmount'])
							hall {
						hallName == params['hall']
								cafee {
							cafeeName == cafee.getCafeeName()
						}
					}
				}.get()
				
				
				myPlace.delete(flush: true)
				if(table != null){
					table.tableForReservationAmount += 1
					cafee.totalReservationPlaces += 1
					if(!table.save(flush: true)){
						table.errors.each{
							println it
						}
					}
				}
				if(!cafee.save(flush: true)){
					cafee.errors.each{
						println it
					}
				}
			}
			showReservedTableForVisitor()
		} catch (Exception e) {
			render (view:'error.gsp')
			e.printStackTrace()
		}
	}
	
	@Secured(['ROLE_ADMIN'])
	def showReservedTableForAdmin(){		
		try {
			DateTimeFormatter timeFormat = DateTimeFormat.forPattern("HH:mm")
			def user = Person.findByUsername(springSecurityService.currentUser.username)
			def myTable = ReservedTable.findAllByOwner(user)
			render (view:'adminCafeeSpace/reservedTableAdmin.gsp', model: [tableInfo: myTable, timeForm: timeFormat])
		} catch (Exception e) {
			render (view:'error.gsp')
			e.printStackTrace()
		}
	}
	
	@Secured(['ROLE_ADMIN', 'ROLE_VISITOR'])
	def updateUserData(params){
		try {
			def successUpdatedCode = 8		
				Authority userAdminAuthority = Authority.findByAuthority('ROLE_ADMIN')
				Person oldUserRecord = Person.findByUsername(springSecurityService.currentUser.username)
				oldUserRecord.username = new String(params['login']).trim()
				oldUserRecord.firstName = new String(params['firstName']).trim()
				oldUserRecord.lastName = new String(params['lastName']).trim()
				oldUserRecord.email = new String(params['email']).trim()
				if(new String(params['password']) != ""){
					oldUserRecord.password = new String(params['password']).trim()
				}
			
			if(oldUserRecord.getAuthorities().contains(userAdminAuthority)){
				oldUserRecord.inn = new String(params['inn']).trim()
			}
			
			if((!(new String(params['password']).trim().equals(new String(params['controlPassword']).trim())))&&(new String(params['password']) != "")){
				def errorCode = 7
				render (view:'error.gsp', model: [error: errorCode])
				return
								//render "Enter your password correctly!"
			}else{
				oldUserRecord.save(flush:true)
			}		
			//render "Updated!"
			render (view:'error.gsp', model: [error: successUpdatedCode])
			return
		} catch (Exception e) {
			render (view:'error.gsp')
			e.printStackTrace()
		}
	}
	
	@Secured(['ROLE_ADMIN'])
	def setReservation(){	
		try {
			def user = Person.findByUsername(springSecurityService.currentUser.username)
			def cafee = user.cafee
			println cafee.availablePaymentSystems
			def tablesAvailable = TablePlacesInfo.where{
				hall{
					cafee{
						cafeeName == cafee.getCafeeName()
					}
				}
			}.list()
						
			render (view:'adminCafeeSpace/setupReservation.gsp', model: [cafeeInfo: cafee, tableAvailable: tablesAvailable])
		} catch (Exception e) {
			render (view:'error.gsp')
			e.printStackTrace()
		}
	}
	
	@Secured(['ROLE_ADMIN'])
	def editReservation(params){
		try {
				def MINUTE_ZERO = 0
				def presentDate = new Date()
				def user = Person.findByUsername(springSecurityService.currentUser.username)
				Cafee oldCafeeInfo = user.cafee
								
				def startTimePoint = new LocalTime(Integer.parseInt(params['startTimeReservation_hour']), MINUTE_ZERO)
				def endTimePoint = new LocalTime(Integer.parseInt(params['endTimeReservation_hour']), MINUTE_ZERO)
				
				oldCafeeInfo.cafeeName = params['cafee']
				oldCafeeInfo.currencyType = params['currencyType']							
				if(params['reservationAvailable'] == 'on'){
					oldCafeeInfo.isReservationAvailable = true
				}else{
					oldCafeeInfo.isReservationAvailable = false
				}
				
				if(params['timeLimitReservation'] == 'on'){
					oldCafeeInfo.reservationTimeLimit = true
				}else{
					oldCafeeInfo.reservationTimeLimit = false
				}
				
				if(params['dateLimitReservation'] == 'on'){
					oldCafeeInfo.reservationDateLimit = true
				}else{
					oldCafeeInfo.reservationDateLimit = false
				}
				
				oldCafeeInfo.startTimeLimit = startTimePoint
				oldCafeeInfo.endTimeLimit = endTimePoint
				oldCafeeInfo.startDateLimit = params['startDateReservation']
				oldCafeeInfo.endDateLimit = params['endDateReservation']
										
	//			if(Integer.parseInt(params['totalPlaces']) < Integer.parseInt(params['reservationPlaces'])){
	//				def errorCode = 9
	//				render (view:'error.gsp', model: [error: errorCode])
	//				//render "Amount places for reservation can't be more than total places amount!"
	//				return
	//			}
										
				if((params['dateLimitReservation'] == 'on') && (params['startDateReservation'] >= params['endDateReservation'])){
					def errorCode = 10
					render (view:'error.gsp', model: [error: errorCode])
					//render "Start date point can not be more than end date point!"
					return
				}
				
				if((params['timeLimitReservation'] == 'on') && (startTimePoint >= endTimePoint)){
					def errorCode = 11
					render (view:'error.gsp', model: [error: errorCode])
					//render "Start time point can not be more than end time point!"
					return
				}
				
				if(!oldCafeeInfo.save(flush: true)){
					oldCafeeInfo.errors.each{
						println it
					}
				}
				def errorCode = 12
				render (view:'error.gsp', model: [error: errorCode])
		} catch (Exception e) {
			render (view:'error.gsp')
			e.printStackTrace()
		}
		//render "Cafee data has been successfully updated!"
	}
	
	@Secured(['ROLE_ADMIN'])
	def tableAcounting(){
		try {
				def user = Person.findByUsername(springSecurityService.currentUser.username)
				def cafee = user.cafee
				def tables
				if (!HallsZones.findAllByCafee(cafee).isEmpty()) {
					tables = TablePlacesInfo.where {
						hall {
								cafee{
								cafeeName == cafee.getCafeeName()
							}
						}
					}.list()
				}else{
					tables = []
				}
				def halls = cafee.halls
				render (view:'adminCafeeSpace/tableAcounting.gsp', model: [tableInfo: tables, halls : halls]) 
		} catch (Exception e) {
			render (view:'error.gsp')
			e.printStackTrace()
		} 
	}
	
	@Secured(['ROLE_ADMIN'])
	def addTable(params){
		try {
				def user = Person.findByUsername(springSecurityService.currentUser.username)
				def cafee = user.cafee
				cafee.totalReservationPlaces += Integer.parseInt(params['availableForReservation'])
				cafee.totalPlaces += Integer.parseInt(params['defTableAmount'])
				def hall = HallsZones.findWhere(cafee : cafee, hallName : params['hallsAvailable'])
				hall.addToTable(new TablePlacesInfo(placesInTableAmount: params['placesInTable'], tableAmount: params['defTableAmount'], tableForReservationAmount: params['availableForReservation'],
					placeCost: params['placePrice'], currencyType: params['currencyType'])).save(flush: true)	
				tableAcounting()
		} catch (Exception e) {
			def errorCode = 15
			render (view:'error.gsp', model: [error: errorCode])//"невалидное заполнение полей!"
			return
			e.printStackTrace()
		}
	}
	
	@Secured(['ROLE_ADMIN'])//исправить ошибку удаления в связи с уникальностью
	def deleteTableAdmin(params){
		try {
			def user = Person.findByUsername(springSecurityService.currentUser.username)
			def cafee = user.cafee
			cafee.totalReservationPlaces -= Integer.parseInt(params['tablesForReservation'])
			cafee.totalPlaces -= Integer.parseInt(params['totalTables'])		
			def hall = HallsZones.findWhere(hallName: params['hall'], cafee: cafee)		
			def table = TablePlacesInfo.findById(Integer.parseInt(params['id']))
			hall.removeFromTable(table).save(flush: true)
			
			tableAcounting()
		} catch (Exception e) {
			render (view:'error.gsp')
			e.printStackTrace()
		}
	}
	
	@Secured(['ROLE_VISITOR'])//исправить названия "регион" на "название кафе" в связи с изменением критериев поиска и соответствующие им ссылки
	def searchCafee(params){
		try {
				def goalCafee
				List<Cafee> availableCafees = new ArrayList<Cafee>()
				ApiRequest apiRequest
				String regionCafee
				String cityCafee = new String(params['city']).trim()
				if(params.containsKey('region')){
					regionCafee = new String(params['region']).trim()
				}else{
					regionCafee = ""
				}
				if((cityCafee == "") && (regionCafee == "")){			
					goalCafee = Cafee.list()
					for(Cafee cafee : goalCafee){
						if(cafee.apiInit != ""){
							apiRequest = ApiHandlerController.request(cafee.apiInit)
									availableCafees.add(new Cafee(cafeeName: apiRequest.cafeeName, placeCost: apiRequest.placeCost, currencyType: apiRequest.currencyType, apiInit: apiRequest.apiInit, 
										region: apiRequest.getRegion(), city: apiRequest.getCity()))
						}else{
							availableCafees.add(cafee)
						}
					}
				}else if(((cityCafee != "") && (regionCafee == ""))){
					if(cityCafee.size() >= MIN_QUERY_NAME_SIZE){
						goalCafee = Cafee.findAllByCityIlike("%" + cityCafee[0..2] + "%")
					}else{
						goalCafee = Cafee.findAllByCityIlike(cityCafee)
					}
					for(Cafee cafee : goalCafee){
						if(cafee.apiInit != ""){
							apiRequest = ApiHandlerController.request(cafee.apiInit, "CITY", cityCafee)
									availableCafees.add(new Cafee(cafeeName: apiRequest.cafeeName, placeCost: apiRequest.placeCost, currencyType: apiRequest.currencyType, apiInit: apiRequest.apiInit))
						}else{
							availableCafees.add(cafee)
						}
					}
				}else if(((cityCafee == "") && (regionCafee != ""))){
					if(regionCafee.size() >= MIN_QUERY_NAME_SIZE){
						goalCafee = Cafee.findAllByCafeeNameIlike("%" + regionCafee[0..2] + "%")
					}else{
						goalCafee = Cafee.findAllByCafeeNameIlike(regionCafee)
					}
					for(Cafee cafee : goalCafee){
						if(cafee.apiInit != ""){
							apiRequest = ApiHandlerController.request(cafee.apiInit, "REG", regionCafee)
									availableCafees.add(new Cafee(cafeeName: apiRequest.cafeeName, placeCost: apiRequest.placeCost, currencyType: apiRequest.currencyType, apiInit: apiRequest.apiInit))
						}else{
							availableCafees.add(cafee)
						}
					}
				}else{
					if((cityCafee.size() >= MIN_QUERY_NAME_SIZE)||(regionCafee.size() >= MIN_QUERY_NAME_SIZE)){
						goalCafee = Cafee.findAllByCityIlikeAndCafeeNameIlike("%" + cityCafee[0..2] + "%", regionCafee[0..2] + "%")
					}else{
						goalCafee = Cafee.findAllByCityIlikeAndCafeeNameIlike(cityCafee, regionCafee)
					}
					for(Cafee cafee : goalCafee){
						if(cafee.apiInit != ""){
							apiRequest = ApiHandlerController.request(cafee.apiInit, "CITY_REG", cityCafee, regionCafee)
									availableCafees.add(new Cafee(cafeeName: apiRequest.cafeeName, placeCost: apiRequest.placeCost, currencyType: apiRequest.currencyType, apiInit: apiRequest.apiInit))
						}else{
							availableCafees.add(cafee)
						}
					}
				}
				render (view:'index.gsp', model: [availableCafee: availableCafees])
		} catch (Exception e) {
			render (view:'error.gsp')
			e.printStackTrace()
		}
	}
	
	@Secured(['ROLE_ADMIN'])
	def setupBillingSystem(){
		try {
				def user = Person.findByUsername(springSecurityService.currentUser.username)
				def cafee = user.cafee
				Map<String, Boolean>paymentSystemsStatus = new HashMap<String, Boolean>()
				def paymentSystems = PaymentSystems.list()
				for(def paymentSystem : paymentSystems){
					if(cafee.availablePaymentSystems.contains(paymentSystem)){
						paymentSystemsStatus.put(paymentSystem.getPaymentSystemName(), true)
					}else{
						paymentSystemsStatus.put(paymentSystem.getPaymentSystemName(), false)
					}
				}
				/*ArrayList<PaymentSystems>paymentSystemsStatus = new ArrayList<PaymentSystems>()
				def checkablePaymentSystem
				for(def paymentSystem : paymentSystems){
					println cafee.availablePaymentSystems
					checkablePaymentSystem = cafee.availablePaymentSystems.find{key, value -> key == paymentSystem.getPaymentSystemName}
					if(cafee.availablePaymentSystems.contains(paymentSystem)){
						paymentSystemsStatus.add(new PaymentSystems(paymentSystemName : paymentSystem.getPaymentSystemName(), bill: paymentSystem.getBill(), enabled : true))
					}else{
						paymentSystemsStatus.add(new PaymentSystems(paymentSystemName : paymentSystem.getPaymentSystemName(), bill: paymentSystem.getBill(), enabled : false))
					}
				}*/
				render (view:'adminCafeeSpace/billingSystemControl.gsp', model: [paymentSystems: paymentSystemsStatus])
		} catch (Exception e) {
			render (view:'error.gsp')
			e.printStackTrace()
		}
	}
	
	@Secured(['ROLE_ADMIN'])
	def saveSetupBillingSystems(params){
		try {
			println params
			def user = Person.findByUsername(springSecurityService.currentUser.username)
			def cafee = user.cafee
			def paymentSystems = PaymentSystems.list() //.unique()
//			def billNumber
//			def index = 0
			for(def paymentSystem : paymentSystems){
//				billNumber = Long.parseLong(new String(params['bill'][index]).trim())
//				paymentSystem.setBill(billNumber)
				if((params.containsKey(paymentSystem.getPaymentSystemName()))&&((!cafee.availablePaymentSystems.contains(paymentSystem)))){
					cafee.addToAvailablePaymentSystems(paymentSystem)
				}else if((!params.containsKey(paymentSystem.getPaymentSystemName()))&&((cafee.availablePaymentSystems.contains(paymentSystem)))){
					cafee.removeFromAvailablePaymentSystems(paymentSystem)
				}
				//++index
			}
			if(!cafee.save(flush:true)){
				cafee.errors.each{
					println it
				}
			}
			setupBillingSystem()
		} catch (Exception e) {
			render (view:'error.gsp')
			e.printStackTrace()
		}
	}
	
	@Secured(['ROLE_VISITOR'])
	def goToPaymentPage(params){
		cafeeInfo = params
		def user = Person.findByUsername(springSecurityService.currentUser.username)
		def cafee = Cafee.findByCafeeName(params['cafeeName'])
		ApiRequest apiRequest
		if(params['cafeeApiInit'] != ""){
			try {
				apiRequest = ApiHandlerController.request(params['cafeeApiInit'])
				cafee = new Cafee(availablePaymentSystems : apiRequest.availablePaymentSystems, currencyType: apiRequest.getCurrencyType())
				def totalCost = apiRequest.getTotalCost()
				render(view:'paymentPage.gsp', model: [availablePaymentSystems: cafee.availablePaymentSystems, totalCost: totalCost, currencyType: cafee.getCurrencyType()])
			} catch (Exception e) {
				render (view:'error.gsp')
				e.printStackTrace()
			}
		}else{
			try {					
					def table = TablePlacesInfo.where {
						placesInTableAmount == Integer.parseInt(params['tablePlacesAvailable'])
						hall {
								hallName == params['hallsAvailable']
								cafee {
									  	cafeeName == cafee.getCafeeName()
									  }
							}
					}.get()
					if(table == null){
						def errorCode = 21
						render (view:'error.gsp', model: [error: errorCode])
						return
					}
					def totalCost = table.placeCost
					render(view:'paymentPage.gsp', model: [availablePaymentSystems: cafee.availablePaymentSystems, totalCost: totalCost, currencyType: cafee.getCurrencyType()])
			} catch (Exception e) {
				def errorCode = 16
				render (view:'error.gsp', model: [error: errorCode])
				e.printStackTrace()
			}
		}
	}
	
	@Secured(['ROLE_VISITOR'])
	def makePayment(params){
		try {
				double totalCost
				if (cafeeInfo.containsKey('tablePlacesAvailable') && (Integer.parseInt(cafeeInfo['tablePlacesAvailable']) != 0)) {
					//totalCost = Integer.parseInt(cafeeInfo['tablePlacesAvailable']) * Double.parseDouble(cafeeInfo['cafeePlaceCost'])
					totalCost = Double.parseDouble(params['totalCost'])
				}else{
					//totalCost = Double.parseDouble(cafeeInfo['cafeePlaceCost'])
					totalCost = Double.parseDouble(params['totalCost'])
				}
				switch(PaymentSystemsHandler.paymentRequest(params['paymentSystemName'], CHECK_BILL, params['billNumber'], totalCost)){
					case 0: makeReserve(cafeeInfo, params['paymentSystemName'], params['billNumber'], totalCost)
					break
					case -1: def errorCode = 13
					render (view:'error.gsp', model: [error: errorCode])
					break
					
					case 1:  def errorCode = 14
					render (view:'error.gsp', model: [error: errorCode])
					break
					default: break
				}
		} catch (Exception e) {
			render (view:'error.gsp')
			e.printStackTrace()
		}
	}
	
	@Secured(['ROLE_VISITOR'])
	def goToPaymentSystemPage(params){
		try {
			render (view: 'paymentSystemPage.gsp', model: [paymentSystemName: params['paymentSystemName'], totalCost: params['totalCost']])
		} catch (Exception e) {
			render (view:'error.gsp')
			e.printStackTrace()
		}
	}
	
	@Secured(['ROLE_ADMIN'])
	def goToHallsAndZones(){
		def user = Person.findByUsername(springSecurityService.currentUser.username)
		def allHallsAndZones = user.cafee.halls
		render (view: 'adminCafeeSpace/hallsAndZones.gsp', model: [halls: allHallsAndZones])
	}
	
	@Secured(['ROLE_ADMIN'])
	def addHall(params){
		try {
			def user = Person.findByUsername(springSecurityService.currentUser.username)
			def cafee = user.cafee
			def hallName = new String(params['hall']).trim()
			if(hallName != ""){
				def newHall = new HallsZones(hallName: hallName)
				if(!cafee.addToHalls(newHall).save(flush: true)){
					
				}		
			}
			goToHallsAndZones()
		} catch (Exception e) {
			render (view:'error.gsp')
			e.printStackTrace()
		}
	}
	
	@Secured(['ROLE_ADMIN'])
	def deleteHall(params){
		try {
			def user = Person.findByUsername(springSecurityService.currentUser.username)
			def cafee = user.cafee
			def hallForDeleting = HallsZones.findWhere(cafee: cafee, hallName: params['hallName'])
			if(!cafee.removeFromHalls(hallForDeleting).save(flush: true)){
				
			}
			goToHallsAndZones()
		} catch (Exception e) {
			render (view:'error.gsp')
			e.printStackTrace()
		}
	}
	
	@Secured(['ROLE_ADMIN'])
	def editTableData(params){
		try {
			def user = Person.findByUsername(springSecurityService.currentUser.username)
			def cafee = user.cafee
			def tableForDeleting = TablePlacesInfo.findById(Integer.parseInt(params['id']))
			def halls = cafee.halls
			render (view: 'adminCafeeSpace/editTableData.gsp', model: [tableInfo: tableForDeleting, halls: halls])
		} catch (Exception e) {
			render (view:'error.gsp')
			e.printStackTrace()
		}
	}
	
	@Secured(['ROLE_ADMIN'])
	def updateTableData(params){
		try {
				def user = Person.findByUsername(springSecurityService.currentUser.username)
				def cafee = user.cafee
				def oldTable = TablePlacesInfo.findById(Integer.parseInt(params['id']))
				
				cafee.totalReservationPlaces -= oldTable.getTableForReservationAmount()
				cafee.totalPlaces -= oldTable.getTableAmount()
							
				cafee.totalReservationPlaces += Integer.parseInt(params['availableForReservation'])
				cafee.totalPlaces += Integer.parseInt(params['defTableAmount'])
							
				oldTable.placesInTableAmount = Integer.parseInt(params['placesInTable'])
				oldTable.tableAmount = Integer.parseInt(params['defTableAmount'])
				oldTable.tableForReservationAmount = Integer.parseInt(params['availableForReservation'])
				oldTable.placeCost = Integer.parseInt(params['placePrice'])
				oldTable.currencyType = params['currencyType']
				if(!oldTable.save(flush : true)){
					
				}
				def hall = HallsZones.findWhere(cafee : cafee, hallName : params['hallsAvailable'])				
				def checkTableInHall = TablePlacesInfo.findWhere(id : Long.parseLong(params['id']), hall : hall)
				println checkTableInHall
				if(checkTableInHall == null){
					println "hall is null"
					hall.addToTable(oldTable).save(flush: true)
				}
				tableAcounting()
		} catch (Exception e) {
			def errorCode = 15
			render (view:'error.gsp', model: [error: errorCode])//"невалидное заполнение полей!"
			return
			e.printStackTrace()
		}
	}
	
	@Secured(['ROLE_ADMIN'])
	def editHall(params){
		try {
			def hall = HallsZones.findById(params['id'])
			render (view: 'adminCafeeSpace/editHallsAndZones.gsp', model: [hall : hall])
		} catch (Exception e) {
			render (view:'error.gsp')
			e.printStackTrace()
		}
	}
	
	@Secured(['ROLE_ADMIN'])
	def updateHall(params){
		try {
			def oldHall = HallsZones.findById(params['id'])
			oldHall.hallName = new String(params['hall']).trim()
			oldHall.save(flush: true)
			goToHallsAndZones()
		} catch (Exception e) {
			render (view:'error.gsp')
			e.printStackTrace()
		}
	}
}
