package restorator

import grails.plugin.springsecurity.annotation.Secured

class StartPageController {
	@Secured(['permitAll'])
    def index() { }
}
