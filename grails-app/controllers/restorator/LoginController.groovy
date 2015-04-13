package restorator

import grails.plugin.springsecurity.annotation.Secured

@Secured(['permitAll'])
class LoginController {
    def auth() { 
		render (view:'auth.gsp')
	}
}
