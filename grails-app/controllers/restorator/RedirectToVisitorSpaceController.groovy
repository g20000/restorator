package restorator

import grails.plugin.springsecurity.annotation.Secured

class RedirectToVisitorSpaceController {
	def afterInterceptor = {
		redirector()
	}
	
	@Secured(['permitAll'])
    def index(params) { }
	
	@Secured(['permit_all'])
	def redirector(params){
		redirect(controller: "VisitorSpace", action: "goToPaymentPage", params: params)
	}
}
