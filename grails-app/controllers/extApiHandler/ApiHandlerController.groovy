package extApiHandler

import extApiMock.ApiRequest
import grails.plugin.springsecurity.annotation.Secured

@Secured(['permitAll'])
class ApiHandlerController {
	static def TO_RESERVE = "TO_RESERVE"
	static def TO_DELETE = "TO_DELETE"
	static def REG = "REG"
	static def CITY = "CITY"
	static def CITY_REG = "CITY_REG"
	
    def index() { }
	
	/*def static request(api){//сделать проверку на верный результат
		def cafee = ApiRequest.findByApiInit(api)
		return cafee
	}
	
	def static request(def api, def opt){//сделать проверку на верный результат
		def cafee = ExtHandlerMockController.deleteReservedTable(api)
		return cafee
	}
	
	def static request(def api, def opt, def param){//сделать проверку на верный результат
		if(opt == TO_RESERVE){
			def cafee = ExtHandlerMockController.makeReserve(api, param)
			return cafee
		}else if(opt == REG){
			def cafee = ApiRequest.findByApiInitAndRegion(api, param)
			return cafee
		}else if(opt == CITY){
			def cafee = ApiRequest.findByApiInitAndCity(api, param)
			return cafee
		}
	}
	
	def static request(def api, def opt, def param1, def param2){//сделать проверку на верный результат
		def cafee = ApiRequest.findByApiInitAndCityAndRegion(api, param1, param2)
		return cafee
	}*/
	
	def static request(...api){//сделать проверку на верный результат
		if(api.size() == 1){
			def cafee = ApiRequest.findByApiInit(api[0])
			return cafee
		}else if(api.size() == 2){
			def cafee = ExtHandlerMockController.deleteReservedTable(api[0])
			return cafee
		}else if(api.size() == 3){
			if(api[1] == TO_RESERVE){
				def cafee = ExtHandlerMockController.makeReserve(api[0], api[2])
				return cafee
			}else if(api[1] == REG){
				def cafee = ApiRequest.findByApiInitAndRegion(api[0], api[2])
				return cafee
			}else if(api[1] == CITY){
				def cafee = ApiRequest.findByApiInitAndCity(api[0], api[2])
				return cafee
			}
		}else if(api.size() == 4){
			def cafee = ApiRequest.findByApiInitAndCityAndRegion(api[0], api[2], api[3])
			return cafee
		}
	}
			
	def response(){
	}
	
	def processor(){
	}
}
