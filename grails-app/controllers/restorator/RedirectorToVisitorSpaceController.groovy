package restorator

import grails.plugin.springsecurity.annotation.Secured

@Secured(['ROLE_VISITOR'])
class RedirectorToVisitorSpaceController {
	def afterInterceptor={
		redirector()
	}
	
	@Secured(['ROLE_VISITOR'])
	def redirector(){
		redirect(controller: "VisitorSpace", action: "makeReserve", params: params)
		
	}
	
	@Secured(['permitAll'])
    def index(params) {		
	}
}
