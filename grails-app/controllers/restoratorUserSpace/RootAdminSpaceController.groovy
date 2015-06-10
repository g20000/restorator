package restoratorUserSpace

import restorator.Cafee
import restorator.HallsZones
import restorator.TablePlacesInfo
import extApiHandler.ApiHandlerController
import extApiMock.ApiRequest
import grails.plugin.springsecurity.annotation.Secured

@Secured(['ROLE_ROOT_ADMIN'])
class RootAdminSpaceController {

    def index() { 
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
						def owner = goalCafee.admin
						println owner
						def halls = HallsZones.findAllWhere(cafee : goalCafee)
						def tablePlacesQuery = TablePlacesInfo.createCriteria()			
						def tablePlaces = tablePlacesQuery.list {
					'in'("hall", halls)
				}
				
				ArrayList<String>hallNames = new ArrayList<String>()
						for(def hall : halls){
							hallNames.add(hall.getHallName())
						}
				
				render (view:'cafeeInfo.gsp', model: [cafeeName: goalCafee])
			}
		} catch (Exception e) {
			render (view:'error.gsp')
			e.printStackTrace()
		}
	}
}