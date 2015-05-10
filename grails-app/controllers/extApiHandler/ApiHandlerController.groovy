package extApiHandler

import extApiMock.ApiRequest
import grails.plugin.springsecurity.annotation.Secured

@Secured(['permitAll'])
class ApiHandlerController {

    def index() { }
	
	static def request(def api){
		def cafee = ApiRequest.findByApiInit(api)
		return cafee
	}
	
	def response(){
	}
	
	def processor(){
	}
}
