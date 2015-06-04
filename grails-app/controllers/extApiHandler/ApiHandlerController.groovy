package extApiHandler

import restorator.NovikovService
import restorator.PiterService
import restorator.TrizetService
import extApiMock.ApiRequest
import extApiMock.ExtHallinfo
import extApiMock.ExtTablePlacesInfo
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
	static def NOVIKOV = "novikov_api"
	static def PITER_API = "piter_api"
	static def TRIZET_API = "trizet_api"
	static def MIN_QUERY_NAME_SIZE = 3
	
    def index() { }
		
	def static request(...api){//сделать проверку на верный результат
		switch(api[0]){
			case CARLSON_API : requestCarlsonAPI(api)
							   break
			case IN_THE_DARKNESS : requestInTheDarkness(api)
							   break
		    case NOVIKOV : requestNovikovApi(api)
		    			   break
			case PITER_API : requestPiterApi(api)
							 break
			case TRIZET_API : requestTrizetApi(api)
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
			    case REG : if(api[2].size() >= MIN_QUERY_NAME_SIZE){
							   def cafee = ApiRequest.findByApiInitAndCafeeNameIlike(api[0], api[2][0..2] + "%")
							   return cafee
			    		   }else{
							   def cafee = ApiRequest.findByApiInitAndCafeeNameIlike(api[0], api[2])
							   return cafee
			    		   }			
			    case CITY : if(api[2].size() >= MIN_QUERY_NAME_SIZE){
								def cafee = ApiRequest.findByApiInitAndCityIlike(api[0], api[2][0..2] + "%")
								return cafee
			    			}else{
								def cafee = ApiRequest.findByApiInitAndCityIlike(api[0], api[2][0..2])
								return cafee
			    			}
				case TO_DELETE : def cafee = ExtHandlerMockController.deleteReservedTable(api[0])
								 return cafee
				default : break
			}
			case 4 : if((api[2].size() >= MIN_QUERY_NAME_SIZE) || (api[3].size() >= MIN_QUERY_NAME_SIZE)){
						 def cafee = ApiRequest.findByApiInitAndCityIlikeAndCafeeNameIlike(api[0], api[2][0..2] + "%", api[3][0..2] + "%")
						 return cafee
					 }else{
						 def cafee = ApiRequest.findByApiInitAndCityIlikeAndCafeeNameIlike(api[0], api[2], api[3])
						 return cafee
					 }
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
					 return cafee
			case 2 : def cafee = ExtHandlerMock2Controller.deleteReservedTable(api[0])
					 return cafee
			case 3 : switch(api[1]){
				case TO_RESERVE : def cafee = ExtHandlerMock2Controller.makeReserve(api[0], api[2])
								  double totalCost = Double.parseDouble(api[2]['tablePlacesAvailable']) * cafee.placeCost
								  ApiRequest request = new ApiRequest()
								  request = cafee
								  request.placesInSelectedTable = Integer.parseInt(api[2]['tablePlacesAvailable'])
								  request.totalCost = totalCost
								  return request
			    case REG : if(api[2].size() >= MIN_QUERY_NAME_SIZE){
							   def cafee = ApiRequest.findByApiInitAndCafeeNameIlike(api[0], api[2][0..2] + "%")
							   return cafee
			    		   }else{
							   def cafee = ApiRequest.findByApiInitAndCafeeNameIlike(api[0], api[2])
							   return cafee
			    		   }
			    case CITY : if(api[2].size() >= MIN_QUERY_NAME_SIZE){
								def cafee = ApiRequest.findByApiInitAndCityIlike(api[0], api[2][0..2] + "%")
								return cafee
			    		    }else{
								def cafee = ApiRequest.findByApiInitAndCityIlike(api[0], api[2][0..2])
								return cafee
			    		    }
				case TO_DELETE : def cafee = ExtHandlerMock2Controller.deleteReservedTable(api[0], api[2])
								 return cafee 
				default : break
			}
			case 4 : if((api[2].size() >= MIN_QUERY_NAME_SIZE) || (api[3].size() >= MIN_QUERY_NAME_SIZE)){
						 def cafee = ApiRequest.findByApiInitAndCityIlikeAndCafeeNameIlike(api[0], api[2][0..2] + "%", api[3][0..2] + "%")
						 return cafee
					}else{
						def cafee = ApiRequest.findByApiInitAndCityIlikeAndCafeeNameIlike(api[0], api[2], api[3])
						return cafee
					}
			default : break
		}
	}
	
	def static requestNovikovApi(...api){
		switch(api.size()){
			case 1 : def cafee = ApiRequest.findByApiInit(api[0])
					 def availableTablesByPlaces = ExtTablePlacesInfo.findAllWhere(request : cafee)
					 def availableHalls = ExtHallinfo.findAllWhere(request : cafee)
					 def availablePaymentSystems = cafee.availablePaymentSystems
					 ArrayList<Integer>placesInTable = new ArrayList<Integer>()
					 ArrayList<String>hallNames = new ArrayList<String>()
					 //ArrayList<String>paymentSystems = new ArrayList<String>()
					 ApiRequest request = new ApiRequest()
					 request = cafee
					 for(ExtTablePlacesInfo availableTableByPlaces : availableTablesByPlaces){
						 placesInTable.add(availableTableByPlaces.placesInTableAmount)
					 }
					 for(ExtHallinfo availableHall : availableHalls){
						 hallNames.add(availableHall.hallName)
					 }
					 /*for(PaymentSystems paymentSystem : availablePaymentSystems){
						 paymentSystems.add(paymentSystem.getPaymentSystemName())
					 }*/
					 request.places = placesInTable
					 request.halls = hallNames
					 //request.paymentSystems = paymentSystems
					 println cafee.availablePaymentSystems
					 return request
			case 2 : def cafee = NovikovService.deleteReservedTable(api[0])
					 return cafee
			case 3 : switch(api[1]){
				case TO_RESERVE : def cafee = NovikovService.makeReserve(api[0], api[2])
								  double totalCost = Double.parseDouble(api[2]['tablePlacesAvailable']) * cafee.placeCost
								  ApiRequest request = new ApiRequest()
								  request = cafee
								  request.placesInSelectedTable = Integer.parseInt(api[2]['tablePlacesAvailable'])
								  request.totalCost = totalCost
								  request.selectedHall = api[2]['hallsAvailable']
								  return request
				case REG : if(api[2].size() >= MIN_QUERY_NAME_SIZE){
							   def cafee = ApiRequest.findByApiInitAndCafeeNameIlike(api[0], api[2][0..2] + "%")
							   return cafee
							}else{
								def cafee = ApiRequest.findByApiInitAndCafeeNameIlike(api[0], api[2])
								return cafee
							}
				case CITY : if(api[2].size() >= MIN_QUERY_NAME_SIZE){
								def cafee = ApiRequest.findByApiInitAndCityIlike(api[0], api[2][0..2] + "%")
								return cafee
							}else{
								def cafee = ApiRequest.findByApiInitAndCityIlike(api[0], api[2])
								return cafee
							}
				case TO_DELETE : def cafee = NovikovService.deleteReservedTable(api[0], api[2])
								 return cafee
				default : break
			}
			case 4 : if((api[2].size() >= MIN_QUERY_NAME_SIZE)||(api[3].size() >= MIN_QUERY_NAME_SIZE)){
						 def cafee = ApiRequest.findByApiInitAndCityIlikeAndCafeeNameIlike(api[0], api[2][0..2] + "%", api[3][0..2] + "%")
						 return cafee
					 }else{
						 def cafee = ApiRequest.findByApiInitAndCityIlikeAndCafeeNameIlike(api[0], api[2], api[3])
						 return cafee
					 }
			default : break
		}
	}
	
	def static requestPiterApi(...api){
		switch(api.size()){
			case 1 : def cafee = ApiRequest.findByApiInit(api[0])
					 def availableHalls = ExtHallinfo.findAllWhere(request : cafee)
					 ArrayList<String>hallNames = new ArrayList<String>()
					 ApiRequest request = new ApiRequest()
					 request = cafee
					 for(ExtHallinfo availableHall : availableHalls){
						 hallNames.add(availableHall.hallName)
					 }
					 request.halls = hallNames
					 return request
			 case 3 : switch(api[1]){
				 case TO_RESERVE : def cafee = PiterService.makeReserve(api[0], api[2])
								   ApiRequest request = new ApiRequest()
								   request = cafee
								   request.totalCost = cafee.placeCost
								   request.selectedHall = api[2]['hallsAvailable']
								   return request
				 case REG : if(api[2].size() >= MIN_QUERY_NAME_SIZE){
					 			def cafee = ApiRequest.findByApiInitAndCafeeNameIlike(api[0], api[2][0..2] + "%")
								return cafee
				 			}else{
								def cafee = ApiRequest.findByApiInitAndCafeeNameIlike(api[0], api[2])
								return cafee
				 			}
				 case CITY : if(api[2].size() >= MIN_QUERY_NAME_SIZE){
					 			 def cafee = ApiRequest.findByApiInitAndCityIlike(api[0], api[2][0..2] + "%")
								 return cafee
				 			 }else{
								 def cafee = ApiRequest.findByApiInitAndCityIlike(api[0], api[2])
								 return cafee
				 			 }
				 case TO_DELETE : def cafee = PiterService.deleteReservedTable(api[0], api[2])
								  return cafee
				 default : break
			 }
			default : break
		}
	}
	
	def static requestTrizetApi(...api){
		switch(api.size()){
			case 1 : def cafee = ApiRequest.findByApiInit(api[0])
					 def availableHalls = ExtHallinfo.findAllWhere(request : cafee)
					 ArrayList<String>hallNames = new ArrayList<String>()
					 ApiRequest request = new ApiRequest()
					 request = cafee
					 request.endTimeLimit = null
					 for(ExtHallinfo availableHall : availableHalls){
						 hallNames.add(availableHall.hallName)
					 }
					 request.halls = hallNames
					 return request
			 case 3 : switch(api[1]){
				 case TO_RESERVE : def cafee = TrizetService.makeReserve(api[0], api[2])
								   ApiRequest request = new ApiRequest()
								   request = cafee
								   request.totalCost = cafee.placeCost
								   request.selectedHall = api[2]['hallsAvailable']
								   return request
				 case REG : if(api[2].size() >= MIN_QUERY_NAME_SIZE){
					 			def cafee = ApiRequest.findByApiInitAndCafeeNameIlike(api[0], api[2][0..2] + "%")
								return cafee
				 			}else{
								def cafee = ApiRequest.findByApiInitAndCafeeNameIlike(api[0], api[2])
								return cafee
				 			}
				 case CITY : if(api[2].size() >= MIN_QUERY_NAME_SIZE){
					 			 def cafee = ApiRequest.findByApiInitAndCityIlike(api[0], api[2][0..2] + "%")
								 return cafee
				 			 }else{
								 def cafee = ApiRequest.findByApiInitAndCityIlike(api[0], api[2])
								 return cafee
				 			 }
				 case TO_DELETE : def cafee = TrizetService.deleteReservedTable(api[0], api[2])
								  return cafee
				 default : break
			 }
			default : break
		}
	}
}
