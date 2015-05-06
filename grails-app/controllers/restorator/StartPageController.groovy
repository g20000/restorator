package restorator

import grails.plugin.springsecurity.annotation.Secured
import restoratorUserSpace.VisitorSpaceController



@Secured(['permitAll'])
class StartPageController {
		
    def index() { 
	}
	
	def searchCafee(params){
		def goalCafee
		String regionCafee
		String cityCafee = new String(params['city']).trim()
		if(params.containsKey('region')){
			regionCafee = new String(params['region']).trim()
		}else{
			regionCafee = ""
		}
		if((cityCafee == "") && (regionCafee == "")){
			render "Заполните поля!"
		}else if(((cityCafee != "") && (regionCafee == ""))){
			goalCafee = Cafee.findAllByCity(cityCafee)
		}else if(((cityCafee == "") && (regionCafee != ""))){
			goalCafee = Cafee.findAllByRegion(regionCafee)
		}else{
			goalCafee = Cafee.findAllByCityAndRegion(cityCafee, regionCafee)
		}
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
