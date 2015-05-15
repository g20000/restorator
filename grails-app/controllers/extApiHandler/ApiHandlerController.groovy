package extApiHandler

import restorator.ExtTablePlacesInfo
import extApiMock.ApiRequest
import grails.plugin.springsecurity.annotation.Secured

@Secured(['permitAll'])
class ApiHandlerController {
	static def TO_RESERVE = "TO_RESERVE"
	static def TO_DELETE = "TO_DELETE"
	static def REG = "REG"
	static def CITY = "CITY"
	static def CITY_REG = "CITY_REG"
	static def CARLSON_API = "carlson_api"
	static def IN_THE_DARKNESS = "in_the_darkness"
	
    def index() { }
		
	def static request(...api){//сделать проверку на верный результат
		switch(api[0]){
			case CARLSON_API : requestCarlsonAPI(api)
							   break
			case IN_THE_DARKNESS : requestInTheDarkness(api)
							   break
		    default : break
		}
	}
		
	def static requestCarlsonAPI(...api){
		switch(api.size()){
			case 1 : def cafee = ApiRequest.findByApiInit(api[0])
					 return cafee
			case 2 : def cafee = ExtHandlerMockController.deleteReservedTable(api[0])
					 return cafee
			case 3 : switch(api[1]){
				case TO_RESERVE : def cafee = ExtHandlerMockController.makeReserve(api[0], api[2])
								  return cafee
			    case REG : def cafee = ApiRequest.findByApiInitAndRegion(api[0], api[2])
						   return cafee
			    case CITY : def cafee = ApiRequest.findByApiInitAndCity(api[0], api[2])
							return cafee
				default : break
			}
			case 4 : def cafee = ApiRequest.findByApiInitAndCityAndRegion(api[0], api[2], api[3])
					 return cafee
			default : break 
		}
	}
	
	def static requestInTheDarkness(...api){
		switch(api.size()){
			case 1 : def cafee = ApiRequest.findByApiInit(api[0])
					 def availableTablesByPlaces = ExtTablePlacesInfo.findAllWhere(request : cafee)
					 ArrayList<Integer>placesInTable = new ArrayList<Integer>()
					 ApiRequest request = new ApiRequest()
					 request = cafee
					 for(ExtTablePlacesInfo availableTableByPlaces : availableTablesByPlaces){
						 placesInTable.add(availableTableByPlaces.placesInTableAmount)
					 }
					 request.places = placesInTable
					 println availableTablesByPlaces
					 return cafee
			case 2 : def cafee = ExtHandlerMock2Controller.deleteReservedTable(api[0])
					 return cafee
			case 3 : switch(api[1]){
				case TO_RESERVE : def cafee = ExtHandlerMock2Controller.makeReserve(api[0], api[2])
								  return cafee
			    case REG : def cafee = ApiRequest.findByApiInitAndRegion(api[0], api[2])
						   return cafee
			    case CITY : def cafee = ApiRequest.findByApiInitAndCity(api[0], api[2])
							return cafee
				default : break
			}
			case 4 : def cafee = ApiRequest.findByApiInitAndCityAndRegion(api[0], api[2], api[3])
					 return cafee
			default : break
		}
	}
}
