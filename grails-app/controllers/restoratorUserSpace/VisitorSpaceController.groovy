package restoratorUserSpace

import grails.plugin.springsecurity.SpringSecurityService
import grails.plugin.springsecurity.annotation.Secured

import java.util.concurrent.TimeUnit

import org.joda.time.LocalTime

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
		def goalCafee = Cafee.findByCafeeName(params['cafeeName'])
		render (view:'cafeeInfo.gsp', model: [cafeeName: goalCafee])
	}
	
	@Secured(['ROLE_VISITOR'])//fixed
	def makeReserve(params){
		Person user = Person.findByUsername(springSecurityService.currentUser.username)
		Cafee cafee = Cafee.findByCafeeName(params['cafeeName'])
		println params
		def startTimeReservation = new LocalTime(Integer.parseInt(params['startTimeReservation_hour']), Integer.parseInt(params['startTimeReservation_minute']))
		def endTimeReservation = new LocalTime(Integer.parseInt(params['endTimeReservation_hour']), Integer.parseInt(params['endTimeReservation_minute']))
		
		if(startTimeReservation >= endTimeReservation){
			render "Start time reservation can not be more than end time reservation!"
			return
		}
				
		println cafee		
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
		def cafee = Cafee.findByCafeeName(params['cafeeName'])
		cafee.totalReservationPlaces += 1
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
		def MINUTE_ZERO = 0
		def presentDate = new Date()
		def user = Person.findByUsername(springSecurityService.currentUser.username)
		Cafee oldCafeeInfo = user.cafee
		
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
		
		/*if(Integer.parseInt(params['endTimeReservation_hour']) - Integer.parseInt(params['startTimeReservation_hour']) < 1){
			render "Difference between end reservation time point and start reservation time point must be a hour minimum!"
			return
		}
		
		if((presentDate - params['startDateReservation'] < TimeUnit.DAYS.toDays(1)) || (presentDate - params['endDateReservation'] > TimeUnit.DAYS.toDays(1))){
			render "Start date point reservation and end date point reservation must be more than the present date"
			return
		}*/
		
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
		
		if(!oldCafeeInfo.save(flush: true)){
			oldCafeeInfo.errors.each{
				println it
			}
		}
		
		render "Cafee data has been successfully updated!"
	}
}
