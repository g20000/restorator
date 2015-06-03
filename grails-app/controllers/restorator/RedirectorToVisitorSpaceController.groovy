package restorator

import grails.plugin.springsecurity.annotation.Secured

@Secured(['ROLE_VISITOR'])
class RedirectorToVisitorSpaceController {
	def afterInterceptor={
		redirector()
	}
	
	@Secured(['permitAll'])
	def redirector(params){
		println "redirector"
		redirect(controller: "VisitorSpace", action: "goToPaymentPage", params: params)
	}
	
	@Secured(['permitAll'])
    def index(params) {		
	}
}
