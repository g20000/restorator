package restorator

import grails.plugin.springsecurity.SpringSecurityUtils
import grails.plugin.springsecurity.annotation.Secured

import javax.servlet.http.HttpServletResponse
@Secured('permitAll')
class LogoutController {
    def index() { 
		if (!request.post && SpringSecurityUtils.getSecurityConfig().logout.postOnly) {
			response.sendError HttpServletResponse.SC_METHOD_NOT_ALLOWED
			return
			}
			 
			// TODO put any pre-logout code here
			
			redirect uri: SpringSecurityUtils.securityConfig.logout.filterProcessesUrl
	}
}
