package restoratorUserSpace

import grails.plugin.springsecurity.SpringSecurityService
import grails.plugin.springsecurity.annotation.Secured
import restorator.Cafee
import restorator.ReservedTable

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
	
	@Secured(['ROLE_ADMIN'])
	def showAdminSpace(){
		def placeinfo = Cafee.where{
			owner == springSecurityService.currentUser.username
		}
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
	
	@Secured(['ROLE_VISITOR'])
	def makeReserve(params){
		def user = springSecurityService.currentUser.username
		Cafee cafee = Cafee.findByCafeeName(params['cafeeName'])
		def ownerName = cafee.getOwner()
		def cafeeName = cafee.getCafeeName()
		ReservedTable myPlace = new ReservedTable(visitor: user, owner: ownerName, cafeeName: cafeeName)
		if(!myPlace.save(flush: true)){
			myPlace.errors.each {
				println it
			}
		}
		
		showReservedTableForVisitor()
	}
	
	@Secured(['ROLE_VISITOR'])
	def showReservedTableForVisitor(){
		def user = springSecurityService.currentUser.username
		ReservedTable myTable = ReservedTable.findByVisitor(user)
		
		render (view:'reserved.gsp', model: [tableInfo: myTable])
	}
	
	@Secured(['ROLE_VISITOR'])
	def deleteReservedTable(){
		def user = springSecurityService.currentUser.username
		ReservedTable myPlace = ReservedTable.findByVisitor(user)
		myPlace.delete(flush: true)
		showReservedTableForVisitor()
	}
		
	def updateUserData(){
		
	}
}
