package restorator

import restoratorUserSpace.VisitorSpaceController
import extApiHandler.ApiHandlerController
import extApiMock.ApiRequest
import grails.plugin.springsecurity.annotation.Secured



@Secured(['permitAll'])
class StartPageController {
		
    def index() { 
	}
	
	def searchCafee(params){
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
			render "Заполните поля!"
		}else if(((cityCafee != "") && (regionCafee == ""))){
			goalCafee = Cafee.findAllByCity(cityCafee)
			for(Cafee cafee : goalCafee){
				if(cafee.apiInit != ""){
					apiRequest = ApiHandlerController.request(cafee.apiInit, "CITY", cityCafee)
					availableCafees.add(new Cafee(cafeeName: apiRequest.cafeeName, placeCost: apiRequest.placeCost, currencyType: apiRequest.currencyType, apiInit: apiRequest.apiInit))
				}else{
					availableCafees.add(cafee)
				}
			}
		}else if(((cityCafee == "") && (regionCafee != ""))){
			goalCafee = Cafee.findAllByRegion(regionCafee)
			for(Cafee cafee : goalCafee){
				if(cafee.apiInit != ""){
					apiRequest = ApiHandlerController.request(cafee.apiInit, "REG", regionCafee)
					availableCafees.add(new Cafee(cafeeName: apiRequest.cafeeName, placeCost: apiRequest.placeCost, currencyType: apiRequest.currencyType, apiInit: apiRequest.apiInit))
				}else{
					availableCafees.add(cafee)
				}
			}
		}else{
			goalCafee = Cafee.findAllByCityAndRegion(cityCafee, regionCafee)
			for(Cafee cafee : goalCafee){
				if(cafee.apiInit != ""){
					apiRequest = ApiHandlerController.request(cafee.apiInit, "CITY_REG", cityCafee, regionCafee)
					availableCafees.add(new Cafee(cafeeName: apiRequest.cafeeName, placeCost: apiRequest.placeCost, currencyType: apiRequest.currencyType, apiInit: apiRequest.apiInit))
				}else{
					availableCafees.add(cafee)
				}
			}
		}
		render (view:'publicCafeeView.gsp', model: [goalCafee: availableCafees])
	}
	
	def goToCafeePage(params){
		ApiRequest apiRequest
		def goalCafee
		if(params['cafeeApiInit'] != ""){
			apiRequest = ApiHandlerController.request(params['cafeeApiInit'])
			goalCafee = new Cafee(cafeeName: apiRequest.cafeeName, placeCost: apiRequest.placeCost, currencyType: apiRequest.currencyType, apiInit: apiRequest.apiInit)
			ArrayList<TablePlacesInfo>tablePlaces = new ArrayList<TablePlacesInfo>()
			for(int places : apiRequest.places){
				tablePlaces.add(new TablePlacesInfo(placesInTableAmount : places))
			}
			render (view:'publicCafeeInfo.gsp', model: [cafeeName: goalCafee, tableInfo: tablePlaces])
		}else{
			goalCafee = Cafee.findByCafeeName(params['cafeeName'])
			def tablePlaces = TablePlacesInfo.findAllWhere(cafee: goalCafee)
			render (view:'publicCafeeInfo.gsp', model: [cafeeName: goalCafee, tableInfo: tablePlaces])
		}
	}
	
	@Secured(['ROLE_VISITOR'])
	def redirectToReserve(params){
		VisitorSpaceController visitorSpace = new VisitorSpaceController()
		visitorSpace.makeReserve(params)
		//redirect(controller: "VisitorSpace", action: "makeReserve", params:params)
	}
}
