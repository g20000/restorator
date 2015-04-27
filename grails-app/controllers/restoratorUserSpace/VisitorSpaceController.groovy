package restoratorUserSpace

import grails.plugin.springsecurity.SpringSecurityService
import grails.plugin.springsecurity.annotation.Secured
import restorator.Cafee
import restorator.ReservedTable
import restorator.auth.Authority
import restorator.auth.Person

class VisitorSpaceController {
	def springSecurityService = new SpringSecurityService()
	
	@Secured(['ROLE_ADMIN', 'ROLE_VISITOR'])
    def index() {	
		def user = springSecurityService.currentUser
		if(user.isAdminCafee){
			showAdminSpace()
		}else{
			showVisitorSpace()
		}
	}
	
	@Secured(['ROLE_VISITOR'])
	def showVisitorSpace(){
		def availableCafee = Cafee.list()
		
		render (view:'index.gsp', model: [availableCafee: availableCafee])
	}
	
	@Secured(['ROLE_ADMIN'])//fixed
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
		render (view:'cafeeInfo.gsp', model: [cafeeName: params['cafeeName']])
	}
	
	@Secured(['ROLE_VISITOR'])//fixed
	def makeReserve(params){
		Person user = Person.findByUsername(springSecurityService.currentUser.username)
		Cafee cafee = Cafee.findByCafeeName(params['cafeeName'])
		println cafee
		Person owner = Person.findByCafee(cafee)
		println owner
		ReservedTable myPlace = new ReservedTable(visitor: user, owner: owner, cafeeName: cafee)
		if(!myPlace.save(flush: true)){
			myPlace.errors.each {
				println it
			}
		}
		
		showReservedTableForVisitor()
	}
	
	@Secured(['ROLE_VISITOR'])//fixed
	def showReservedTableForVisitor(){
		def user = Person.findByUsername(springSecurityService.currentUser.username)
		def myTable = ReservedTable.findAllByVisitor(user)
		
		render (view:'reserved.gsp', model: [tableInfo: myTable])
	}
	
	@Secured(['ROLE_VISITOR'])//fixed
	def deleteReservedTable(params){
		def user = Person.findByUsername(springSecurityService.currentUser.username)
		def myPlace = ReservedTable.findByVisitorAndCafeeName(user, Cafee.findByCafeeName(params['cafeeName']))
		myPlace.delete(flush: true)
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
		def user = Person.findByUsername(springSecurityService.currentUser.username)
		def oldCafeeInfo = user.cafee
		
		oldCafeeInfo.cafeeName = params['cafee']
		oldCafeeInfo.placeCost = Double.parseDouble(params['placePrice'])
		oldCafeeInfo.currencyType = params['currencyType']
		oldCafeeInfo.totalPlaces = Integer.parseInt(params['totalPlaces'])
		oldCafeeInfo.totalReservationPlaces = Integer.parseInt(params['reservationPlaces'])
		oldCafeeInfo.isReservationAvailable = Boolean.parseBoolean(params['reservationAvailable'])
		oldCafeeInfo.reservationTimeLimit = Boolean.parseBoolean(params['timeLimitReservation'])
		oldCafeeInfo.reservationDateLimit = Boolean.parseBoolean(params['dateLimitReservation'])
		println params['startTimeReservation']
		oldCafeeInfo.startTimeLimit = params['startTimeReservation']
		oldCafeeInfo.endTimeLimit = params['endTimeReservation']
		oldCafeeInfo.startDateLimit = params['startDateReservation']
		oldCafeeInfo.endDateLimit = params['endDateReservation']
		
		if(!oldCafeeInfo.save()){
			oldCafeeInfo.errors.each{
				println it
			}
		}
		
		render "Cafee data has been successfully updated!"
	}
}
