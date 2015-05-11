package extApiHandler

import restorator.ExtHandlerMockController
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
	
	static def request(def api){//сделать проверку на верный результат
		def cafee = ApiRequest.findByApiInit(api)
		return cafee
	}
	
	static def request(def api, def opt){//сделать проверку на верный результат
		def cafee = ExtHandlerMockController.deleteReservedTable(api)
		return cafee
	}
	
	static def request(def api, def opt, def param){//сделать проверку на верный результат
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
	
	static def request(def api, def opt, def param1, def param2){//сделать проверку на верный результат
		def cafee = ApiRequest.findByApiInitAndCityAndRegion(api, param1, param2)
		return cafee
	}
		
	def response(){
	}
	
	def processor(){
	}
}
