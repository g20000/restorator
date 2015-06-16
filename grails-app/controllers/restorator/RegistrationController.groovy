package restorator

import grails.plugin.springsecurity.annotation.Secured
import restorator.auth.Authority
import restorator.auth.Person
import restorator.auth.PersonAuthority

class RegistrationController {
	@Secured(['permitAll'])
    def index() {
		render (view:'index.gsp', model: [region: Region.list(), city: City.list()]) 
	}
	
	@Secured(['permitAll'])
	def saveUser(params){
		try {
				def visitorRole = 'ROLE_VISITOR'
				def adminRole = 'ROLE_ADMIN'
				
				def userRole = ''
				def isAdmin = false
				def newUser = null
				def newCafee = null
				
				if((!(Person.find{username == params['login']}).equals(null)) || (!(Person.find{email == params['email']}).equals(null))){
					def errorCode = 18
					render (view:'error.gsp', model: [error: errorCode])//"User with the same email or login has been registered already!"
					return
				}
				if(!params['password'].equals(params['controlPassword'])){
					def errorCode = 19
					render (view:'error.gsp', model: [error: errorCode])//пароли не совпадают
					return
				}
				println params
				if(params['isAdminCafee'] == "on"){
					 isAdmin = true;
					 userRole = adminRole
				}else{
					userRole = visitorRole
				}
				
				def newUserRole = Authority.findOrSaveWhere(authority: userRole)
				
				if(isAdmin){
					newCafee = new Cafee(cafeeName: params['cafeeName'], region: params['region'], city: params['city']).addToAdmin(new Person(username: params['login'], password: params['password'], firstName: params['firstName'], lastName: params['lastName'], email: params['email'], isAdminCafee: isAdmin,
						 inn: params['inn'])).save()
					newUser = Person.findByUsername(params['login'])
				}else{
					newUser = new Person(username: params['login'], password: params['password'], firstName: params['firstName'], lastName: params['lastName'], email: params['email'], isAdminCafee: isAdmin)
					newUser.save(flush: true)
					newUser.validate()
					println newUser.errors
				}
				PersonAuthority.create(newUser, newUserRole, true)
				
				def errorCode = 20
				render (view:'error.gsp', model: [error: errorCode])//пароли не совпадают
				return 
		} catch (Exception e) {
			render (view:'error.gsp')
			e.printStackTrace()
		} 
	}
	
}
