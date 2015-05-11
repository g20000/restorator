package restoratorUserSpace

import org.joda.time.LocalTime

import restorator.Cafee
import restorator.ReservedTable
import restorator.auth.Authority
import restorator.auth.Person
import extApiHandler.ApiHandlerController
import extApiMock.ApiRequest
import grails.plugin.springsecurity.SpringSecurityService
import grails.plugin.springsecurity.annotation.Secured

class VisitorSpaceController {
	def springSecurityService = new SpringSecurityService()
	
	@Secured(['ROLE_ADMIN', 'ROLE_VISITOR'])
    def index() {				
		def user = springSecurityService.currentUser
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
				makeReserve(params)
			}else{
				showVisitorSpace()
			}
		}
	}
	
	@Secured(['ROLE_VISITOR'])
	def showVisitorSpace(){
		ArrayList<Cafee>allCafees = Cafee.list()
		ArrayList<Cafee>availableCafee = new ArrayList<Cafee>()		
		ApiRequest apiRequest
		for(Cafee cafee : allCafees){
			if(cafee.apiInit != ""){
				apiRequest = ApiHandlerController.request(cafee.apiInit)
				availableCafee.add(new Cafee(cafeeName: apiRequest.cafeeName, placeCost: apiRequest.placeCost, currencyType: apiRequest.currencyType, apiInit: apiRequest.apiInit))
			}else{
				availableCafee.add(cafee)
			}
		}
		
		render (view:'index.gsp', model: [availableCafee: availableCafee])
	}
	
	@Secured(['ROLE_ADMIN'])
	def showAdminSpace(){
		println springSecurityService.currentUser.username
		def user = Person.findByUsername(springSecurityService.currentUser.username)
		def placeinfo = user.cafee
		render (view:'adminCafeeSpace/indexAdmin.gsp', model: [placeinfo: placeinfo])
	}
	
	@Secured(['ROLE_ADMIN', 'ROLE_VISITOR'])
	def editPrivateData(){
		def user = springSecurityService.currentUser
		if(user.isAdminCafee){
			render (view:'adminCafeeSpace/editPrivateData.gsp', model: [user: user])
		}else{
			render (view:'editPrivateData.gsp', model: [user: user])
		}
	}
	
	@Secured(['ROLE_VISITOR'])
	def goToCafeePage(params){
		ApiRequest apiRequest
		def goalCafee
		if(params['cafeeApiInit'] != ""){
			apiRequest = ApiHandlerController.request(params['cafeeApiInit'])
			goalCafee = new Cafee(cafeeName: apiRequest.cafeeName, placeCost: apiRequest.placeCost, currencyType: apiRequest.currencyType, apiInit: apiRequest.apiInit)
		}else{
			goalCafee = Cafee.findByCafeeName(params['cafeeName'])
		}
		render (view:'cafeeInfo.gsp', model: [cafeeName: goalCafee])
	}
	
	@Secured(['ROLE_VISITOR'])//переделать с учетом api
	def makeReserve(params){
		ApiRequest apiRequest
		Person user  = Person.findByUsername(springSecurityService.currentUser.username)
		println params['cafeeApiInit']
		if(params['cafeeApiInit'] != ""){
			apiRequest = ApiHandlerController.request(params['cafeeApiInit'], "TO_RESERVE", params)
			def extCafee = Cafee.findWhere(apiInit: params['cafeeApiInit'])
			def startTimeReservation = new LocalTime(Integer.parseInt(params['startTimeReservation_hour']), Integer.parseInt(params['startTimeReservation_minute']))
			def endTimeReservation = new LocalTime(Integer.parseInt(params['endTimeReservation_hour']), Integer.parseInt(params['endTimeReservation_minute']))
			ReservedTable myPlace = new ReservedTable(visitor: user, cafeeName: extCafee, startTimeLimit: startTimeReservation, endTimeLimit: endTimeReservation,
				reservationDate: params['reservationDate'])
			if(!myPlace.save(flush: true)){
				myPlace.errors.each {
					println it
				}
			}
		}else{
			Cafee cafee = Cafee.findByCafeeName(params['cafeeName'])
			println params
			def startTimeReservation = new LocalTime(Integer.parseInt(params['startTimeReservation_hour']), Integer.parseInt(params['startTimeReservation_minute']))
			def endTimeReservation = new LocalTime(Integer.parseInt(params['endTimeReservation_hour']), Integer.parseInt(params['endTimeReservation_minute']))
			
			if(startTimeReservation >= endTimeReservation){
				render "Start time reservation can not be more than end time reservation!"
				return
			}
					
			println "hello from makeReserve"		
			if(!cafee.isReservationAvailable){
				render "Sorry, this cafee closed for reservation at the moment!"
				return
			}
			
			if(cafee.reservationDateLimit && (cafee.startDateLimit <= params['reservationDate']) && (cafee.endDateLimit >= params['reservationDate'])){
				render "You can reserve a place in this cafee between " + cafee.startDateLimit + " and " + cafee.endDateLimit
				return
			}
			
			if(cafee.reservationTimeLimit && (cafee.startTimeLimit <= startTimeReservation) && (cafee.endTimeLimit >= startTimeReservation)
				&& (cafee.startTimeLimit <= endTimeReservation) && (cafee.endTimeLimit >= endTimeReservation)){
				render "You can reserve a place in this cafee between " + cafee.startTimeLimit + " and " + cafee.endTimeLimit
				return
			}
						
			if(cafee.totalReservationPlaces < 1){
				render "Sorry, no more free places in this cafee for reservation"
				return
			}
				
			println cafee
			Person owner = Person.findByCafee(cafee)
			println params['reservationDate']
			cafee.totalReservationPlaces -= 1
			if(!cafee.save()){
				cafee.errors.each {
					println it
				}
			}
			ReservedTable myPlace = new ReservedTable(visitor: user, owner: owner, cafeeName: cafee, startTimeLimit: startTimeReservation, endTimeLimit: endTimeReservation,
				reservationDate: params['reservationDate'])
			if(!myPlace.save(flush: true)){
				myPlace.errors.each {
					println it
				}
			}
		}
		showReservedTableForVisitor()
	}
	
	@Secured(['ROLE_VISITOR'])//переделать с учетом api
	def showReservedTableForVisitor(){
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
		
		render (view:'reserved.gsp', model: [tableInfo: myTables])
	}
	
	@Secured(['ROLE_VISITOR'])//переделать с учетом api
	def deleteReservedTable(params){
		def user = Person.findByUsername(springSecurityService.currentUser.username)
		ApiRequest apiRequest
		if(params['cafeeAPI'] != ""){
			apiRequest = ApiHandlerController.request(params['cafeeAPI'], "TO_DELETE")
			def myPlace = ReservedTable.findByVisitorAndCafeeName(user, Cafee.findByApiInit(params['cafeeAPI']))
			myPlace.delete(flush: true)
		}else{
			def myPlace = ReservedTable.findByVisitorAndCafeeName(user, Cafee.findByCafeeName(params['cafeeName']))
			def cafee = Cafee.findByCafeeName(params['cafeeName'])
			cafee.totalReservationPlaces += 1
			myPlace.delete(flush: true)
		}
		showReservedTableForVisitor()
	}
	
	@Secured(['ROLE_ADMIN'])
	def showReservedTableForAdmin(){		
		def user = Person.findByUsername(springSecurityService.currentUser.username)
		def myTable = ReservedTable.findAllByOwner(user)
		
		render (view:'adminCafeeSpace/reservedTableAdmin.gsp', model: [tableInfo: myTable])
	}
	
	@Secured(['ROLE_ADMIN', 'ROLE_VISITOR'])
	def updateUserData(params){		
		Authority userAdminAuthority = Authority.findByAuthority('ROLE_ADMIN')
		Person oldUserRecord = Person.findByUsername(springSecurityService.currentUser.username)
		oldUserRecord.username = params['login']
		oldUserRecord.firstName = params['firstName']
		oldUserRecord.lastName = params['lastName']
		oldUserRecord.email = params['email']
		oldUserRecord.password = params['password']
				
		if(oldUserRecord.getAuthorities().contains(userAuthority)){
			oldUserRecord.inn = params['inn']
		}
		
		if(!params['password'].equals(params['controlPassword'])){
			render "Enter your password correctly!"
		}else{
			oldUserRecord.save()
		}
								
		render "Updated!"
		
	}
	
	@Secured(['ROLE_ADMIN'])
	def setReservation(){	
		def user = Person.findByUsername(springSecurityService.currentUser.username)
		def cafee = user.cafee
				
		render (view:'adminCafeeSpace/setupReservation.gsp', model: [cafeeInfo: cafee])
	}
	
	@Secured(['ROLE_ADMIN'])
	def editReservation(params){
		def MINUTE_ZERO = 0
		def initApiInfo = new String(params['apiInit']).trim()
		def presentDate = new Date()
		def user = Person.findByUsername(springSecurityService.currentUser.username)
		Cafee oldCafeeInfo = user.cafee
		
		if(initApiInfo == ""){
			def startTimePoint = new LocalTime(Integer.parseInt(params['startTimeReservation_hour']), MINUTE_ZERO)
			def endTimePoint = new LocalTime(Integer.parseInt(params['endTimeReservation_hour']), MINUTE_ZERO)
			
			oldCafeeInfo.cafeeName = params['cafee']
			oldCafeeInfo.placeCost = Double.parseDouble(params['placePrice'])
			oldCafeeInfo.currencyType = params['currencyType']
			oldCafeeInfo.totalPlaces = Integer.parseInt(params['totalPlaces'])
			oldCafeeInfo.totalReservationPlaces = Integer.parseInt(params['reservationPlaces'])
			
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
					
			if(Integer.parseInt(params['totalPlaces']) < Integer.parseInt(params['reservationPlaces'])){
				render "Amount places for reservation can't be more than total places amount!"
				return
			}
			
			if((params['dateLimitReservation'] == 'on') && (params['startDateReservation'] >= params['endDateReservation'])){
				render "Start date point can not be more than end date point!"
				return
			}
			
			if((params['timeLimitReservation'] == 'on') && (startTimePoint >= endTimePoint)){
				render "Start time point can not be more than end time point!"
			}
		}else{
			oldCafeeInfo.apiInit = initApiInfo
		}
		
		if(!oldCafeeInfo.save(flush: true)){
			oldCafeeInfo.errors.each{
				println it
			}
		}
		
		render "Cafee data has been successfully updated!"
	}
}
