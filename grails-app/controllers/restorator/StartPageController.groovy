package restorator

import grails.plugin.springsecurity.annotation.Secured
import restoratorUserSpace.VisitorSpaceController

@Secured(['permitAll'])
class StartPageController {
		
    def index() { 
		println "Hello"
	}
	
	def searchCafee(params){
		def goalCafee = Cafee.findAllByCity(params['city'])
		render (view:'publicCafeeView.gsp', model: [goalCafee: goalCafee])
	}
	
	def goToCafeePage(params){
		def goalCafee = Cafee.findByCafeeName(params['cafeeName'])
		render (view:'publicCafeeInfo.gsp', model: [cafeeName: goalCafee])
	}
	
	@Secured(['ROLE_VISITOR'])
	def redirectToReserve(params){
		VisitorSpaceController visitorSpace = new VisitorSpaceController()
		visitorSpace.makeReserve(params)
		//redirect(controller: "VisitorSpace", action: "makeReserve", params:params)
	}
}
