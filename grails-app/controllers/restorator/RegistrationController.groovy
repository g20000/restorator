package restorator

import grails.plugin.springsecurity.annotation.Secured
import restorator.auth.Authority
import restorator.auth.Person
import restorator.auth.PersonAuthority

class RegistrationController {
	@Secured(['permitAll'])
    def index() { 
	}
	
	@Secured(['permitAll'])
	def saveUser(params){
		def visitorRole = 'ROLE_VISITOR'
		def adminRole = 'ROLE_ADMIN'
		
		def userRole = ''
		def isAdmin = false
		def newUser = null
		def newCafee = null
		
		if((!(Person.find{username == params['login']}).equals(null)) || (!(Person.find{email == params['email']}).equals(null))){
			render "User with the same email or login has been registered already!"
		}
		if(!params['password'].equals(params['controlPassword'])){
			render "Enter your password correctly!"
		}
		if(params['isAdminCafee']){
			 isAdmin = true;
			 userRole = adminRole
		}else{
			userRole = visitorRole
		}
		
		def newUserRole = Authority.findOrSaveWhere(authority: userRole)
		
		if(isAdmin){
			newUser = new Person(username: params['login'], password: params['password'], firstName: params['firstName'], lastName: params['lastName'], email: params['email'], isAdminCafee: isAdmin,
			cafee: params['cafeeName'], inn: params['inn'])
			newCafee = new Cafee(cafeeName: params['cafeeName'], owner: params['login'])
			newCafee.save()
		}else{
			newUser = new Person(username: params['login'], password: params['password'], firstName: params['firstName'], lastName: params['lastName'], email: params['email'], isAdminCafee: isAdmin)
		}
		newUser.save(flush: true)
		newUser.validate()
		println newUser.errors
		PersonAuthority.create(newUser, newUserRole, true)
		
		render "Registration has been finished successful!" 
	}
	
}
