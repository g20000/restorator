import restorator.Cafee
import restorator.auth.Authority
import restorator.auth.Person
import restorator.auth.PersonAuthority

class BootStrap {
	def springSecurityService
    def init = { servletContext ->
		 def adminRole = Authority.findOrSaveWhere(authority: 'ROLE_ADMIN')
		 def visitorRole = Authority.findOrSaveWhere(authority: 'ROLE_VISITOR')
		 def password = springSecurityService.encodePassword('password')
		 		 
		 def newCafe = new Cafee(cafeeName: "Tarelka").addToAdmin(new Person(username: 'testerAndrewRes', password:'password',
			 accountExpired: false, accountLocked: false, passwordExpired: false, 
			 firstName:'Andrew', lastName:'Bobkov', email:'pragmus2@gmail.com', isAdminCafee: true,
			 inn: '1234567890')).save()
		 println newCafe
		 def user = Person.findByCafee(newCafe)
		 println user
		 if(!user.authorities.contains(adminRole))
		 {
			 PersonAuthority.create(user, adminRole, true)
		 }
		 
		 newCafe = new Cafee(cafeeName: "U Petrovicha").addToAdmin(new Person(username: 'testerAdmin', password:'password',
			 accountExpired: false, accountLocked: false, passwordExpired: false,
			 firstName:'Sidr', lastName:'Sidorov', email:'sidr@gmail.com', isAdminCafee: true,
			 inn: '9876543210')).save()
		 user = Person.findByCafee(newCafe)
		 println user
		 if(!user.authorities.contains(adminRole))
		 {
			 PersonAuthority.create(user, adminRole, true)
		 }
		 		 		 
		 /*def admin = Person.findOrSaveWhere(username: 'testerAdmin', password:'password', firstName:'Сидр', lastName:'Сидоров', email:'sidr@gmail.com', isAdminCafee: true, 
			inn: '9876543210')
		 if(!admin.authorities.contains(adminRole))
		 {
			 PersonAuthority.create(admin, adminRole, true)
		 }
		 newCafe = new Cafee(cafeeName: 'U Petrovicha')
		 newCafe.addToAdmin(admin).save()*/
		 		 	 
		 
		 def visitor = Person.findOrSaveWhere(username: 'testerUser', password:'password', firstName:'Иван', lastName:'Иванов', email:'ivanov@gmail.com', isAdminCafee: false)
		 if(!visitor.authorities.contains(visitorRole))
		 {
			 PersonAuthority.create(visitor, visitorRole, true)
		 }
		 
		 visitor = Person.findOrSaveWhere(username: 'testerUser2', password:'password', firstName:'Кишлак', lastName:'Базыров', email:'shaitan@gmail.com', isAdminCafee: false)
		 if(!visitor.authorities.contains(visitorRole))
		 {
			 PersonAuthority.create(visitor, visitorRole, true)
		 }
    }
    def destroy = {
    }
}
