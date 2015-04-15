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
		 
		 def user = Person.findOrSaveWhere(username: 'testerAndrewRes', password:'password', firstName:'Andrew', lastName:'Bobkov', email:'pragmus2@gmail.com', isAdminCafee: true,
			 cafee: 'Тарелка', inn: '1234567890')
		 if(!user.authorities.contains(adminRole))
		 {
			 PersonAuthority.create(user, adminRole, true)
		 }
		 def newCafe = new Cafee(cafeeName: 'Tarelka', owner: 'testerAndrewRes')
		 newCafe.save()
		 
		 def admin = Person.findOrSaveWhere(username: 'testerAdmin', password:'password', firstName:'Сидр', lastName:'Сидоров', email:'sidr@gmail.com', isAdminCafee: true,
			 cafee: 'U Petrovicha', inn: '9876543210')
		 if(!admin.authorities.contains(adminRole))
		 {
			 PersonAuthority.create(admin, adminRole, true)
		 }
		 newCafe = new Cafee(cafeeName: 'U Petrovicha', owner: 'testerAdmin')
		 newCafe.save()
		 
		 
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
