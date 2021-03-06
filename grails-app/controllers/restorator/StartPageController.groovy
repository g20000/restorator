package restorator

import org.joda.time.DateTimeZone
import org.joda.time.LocalTime

import extApiHandler.ApiHandlerController
import extApiMock.ApiRequest
import grails.plugin.springsecurity.annotation.Secured



@Secured(['permitAll'])
class StartPageController {
	private int MIN_QUERY_NAME_SIZE = 3
	private def TIME_ZONE_CORRECT = 3
		
    def index() { 
	}
	
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
				goalCafee = Cafee.findAllByIsReservationAvailable(true)
				for(Cafee cafee : goalCafee){
					if(cafee.apiInit != ""){
						apiRequest = ApiHandlerController.request(cafee.apiInit)
						availableCafees.add(new Cafee(cafeeName: apiRequest.cafeeName, placeCost: apiRequest.placeCost, currencyType: apiRequest.currencyType, apiInit: apiRequest.apiInit,
								endTimeLimit : apiRequest.endTimeLimit, region: apiRequest.getRegion(), city: apiRequest.getCity()))
					}else{
						availableCafees.add(cafee)
					}
				}
			}else if(((cityCafee != "") && (regionCafee == ""))){
				if(cityCafee.size() >= MIN_QUERY_NAME_SIZE)
				{
					goalCafee = Cafee.findAllByCityIlike("%" + cityCafee[0..2] + "%")
				}else{
					goalCafee = Cafee.findAllByCityIlike(cityCafee)
				}
				for(Cafee cafee : goalCafee){
					if(cafee.apiInit != ""){
						apiRequest = ApiHandlerController.request(cafee.apiInit, "CITY", cityCafee)
						availableCafees.add(new Cafee(cafeeName: apiRequest.cafeeName, placeCost: apiRequest.placeCost, currencyType: apiRequest.currencyType, apiInit: apiRequest.apiInit,
								endTimeLimit : apiRequest.endTimeLimit))
					}else{
						availableCafees.add(cafee)
					}
				}
			}else if(((cityCafee == "") && (regionCafee != ""))){
				if(regionCafee.size() >= MIN_QUERY_NAME_SIZE)
				{
					goalCafee = Cafee.findAllByCafeeNameIlike("%" + regionCafee[0..2] + "%")
				}else{
					goalCafee = Cafee.findAllByCafeeNameIlike(regionCafee)
				}
				for(Cafee cafee : goalCafee){
					if(cafee.apiInit != ""){
						apiRequest = ApiHandlerController.request(cafee.apiInit, "REG", regionCafee)
						availableCafees.add(new Cafee(cafeeName: apiRequest.cafeeName, placeCost: apiRequest.placeCost, currencyType: apiRequest.currencyType, apiInit: apiRequest.apiInit,
								endTimeLimit : apiRequest.endTimeLimit))
					}else{
						availableCafees.add(cafee)
					}
				}
			}else{
				if((cityCafee.size() >= MIN_QUERY_NAME_SIZE) || (regionCafee.size() >= MIN_QUERY_NAME_SIZE)){
					goalCafee = Cafee.findAllByCityIlikeAndCafeeNameIlike("%" + cityCafee[0..2] + "%", "%" + regionCafee[0..2] + "%")
				}else{
					goalCafee = Cafee.findAllByCityIlikeAndCafeeNameIlike(cityCafee, regionCafee)
				}
				for(Cafee cafee : goalCafee){
					if(cafee.apiInit != ""){
						apiRequest = ApiHandlerController.request(cafee.apiInit, "CITY_REG", cityCafee, regionCafee)
						availableCafees.add(new Cafee(cafeeName: apiRequest.cafeeName, placeCost: apiRequest.placeCost, currencyType: apiRequest.currencyType, apiInit: apiRequest.apiInit,
								endTimeLimit : apiRequest.endTimeLimit))
					}else{
						availableCafees.add(cafee)
					}
				}
			}
			render (view:'publicCafeeView.gsp', model: [goalCafee: availableCafees])
		} catch (Exception e) {
			render (view:'error.gsp')
			e.printStackTrace()
		}
	}
	
	def goToCafeePage(params){
		ApiRequest apiRequest
		def goalCafee
		try {
			if(params['cafeeApiInit'] != ""){
				apiRequest = ApiHandlerController.request(params['cafeeApiInit'])
				goalCafee = new Cafee(cafeeName: apiRequest.cafeeName, placeCost: apiRequest.placeCost, currencyType: apiRequest.currencyType, apiInit: apiRequest.apiInit,
						hall: apiRequest.hall, endTimeLimit : apiRequest.endTimeLimit)
				ArrayList<TablePlacesInfo>tablePlaces = new ArrayList<TablePlacesInfo>()
				for(int places : apiRequest.places){
					tablePlaces.add(new TablePlacesInfo(placesInTableAmount : places))
				}
				
				ArrayList<String>hallNames = new ArrayList<String>()
				for(String hall : apiRequest.halls){
					hallNames.add(hall)
				}
				render (view:'publicCafeeInfo.gsp', model: [cafeeName: goalCafee, tableInfo: tablePlaces, halls: hallNames])
			}else{
				goalCafee = Cafee.findByCafeeName(params['cafeeName'])
				def tablePlaces
				def halls = HallsZones.findAllWhere(cafee : goalCafee)
				def tablePlacesQuery = TablePlacesInfo.createCriteria()
				ArrayList<TablePlacesInfo>places = new ArrayList<TablePlacesInfo>()
				if(!halls.isEmpty()){			
					tablePlaces = tablePlacesQuery.list {
						'in'("hall", halls)
					}
					for(TablePlacesInfo place: tablePlaces){
						places.add(place)
					}
				}else{
					places = []
				}
				
				ArrayList<String>hallNames = new ArrayList<String>()
				for(def hall : halls){
					hallNames.add(hall.getHallName())
				}
				render (view:'publicCafeeInfo.gsp', model: [cafeeName: goalCafee, tableInfo: places, halls: hallNames])
			}
		} catch (Exception e) {
			render (view:'error.gsp')
			e.printStackTrace()
		}
	}
	
	def hallChanged(String regionId, long cafeeId) {
//		println "test"
//		println regionId
//		println cafeeId
		/*Region region = Region.get(regionId)
		def subCategories = []
		if ( region != null ) {
			subCategories = City.findAllWhere(region : region, [order:'cityName'])
		}
		render g.select(id:'subCategory', name:'subCategory.id',
			from:subCategories, optionKey:'id', noSelection:[null:'�������� �����'], optionValue: 'cityName'
		)*/
	}
}
