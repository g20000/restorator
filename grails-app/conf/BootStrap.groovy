import org.joda.time.LocalTime

import restorator.Cafee
import restorator.ExtHallinfo
import restorator.ExtTablePlacesInfo
import restorator.auth.Authority
import restorator.auth.Person
import restorator.auth.PersonAuthority
import extApiMock.ApiRequest

class BootStrap {
	def springSecurityService
    def init = { servletContext ->
		 def adminRole = Authority.findOrSaveWhere(authority: 'ROLE_ADMIN')
		 def visitorRole = Authority.findOrSaveWhere(authority: 'ROLE_VISITOR')
		 def password = springSecurityService.encodePassword('password')
		 		 
		 def newCafe = new Cafee(cafeeName: "Tarelka", region: "Mari El", city: "Yoshkar Ola").addToAdmin(new Person(username: 'testerAndrewRes', password:'password',
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
		 
		 newCafe = new Cafee(cafeeName: "U Petrovicha", region: "Mari El", city: "Kozmodemyansk").addToAdmin(new Person(username: 'testerAdmin', password:'password',
			 accountExpired: false, accountLocked: false, passwordExpired: false,
			 firstName:'Sidr', lastName:'Sidorov', email:'sidr@gmail.com', isAdminCafee: true,
			 inn: '9876543210')).save()
		 user = Person.findByCafee(newCafe)
		 println user
		 if(!user.authorities.contains(adminRole))
		 {
			 PersonAuthority.create(user, adminRole, true)
		 }
		 	 		 	 		 	 
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
		 
		 double cost1 = 4.0
		 def extApiRequest = ApiRequest.findOrSaveWhere(apiInit: "carlson_api", cafeeName: "Carlson", totalReservationPlaces: 10, placeCost: cost1, currencyType: "RUB",
			 isReservationAvailable: true, reservationTimeLimit: false, reservationDateLimit: false, totalPlaces: 20, startTimeLimit: new LocalTime(), endTimeLimit: new LocalTime(),
			 startDateLimit: new Date(), endDateLimit: new Date(), region: "Moscow region", city: "Moscow")
		 def extCafee = Cafee.findOrSaveWhere(apiInit: "carlson_api", region: "Moscow region", city: "Moscow")
		 
		 double cost2 = 8.0
		 def extApiRequest2 = ApiRequest.findOrSaveWhere(apiInit: "in_the_darkness", cafeeName: "In the darkness", totalReservationPlaces: 15, placeCost: cost2, currencyType: "USD",
			 isReservationAvailable: true, reservationTimeLimit: false, reservationDateLimit: false, totalPlaces: 25, startTimeLimit: new LocalTime(), endTimeLimit: new LocalTime(),
			 startDateLimit: new Date(), endDateLimit: new Date(), region: "Moscow region", city: "Moscow")
		 def extCafee2 = Cafee.findOrSaveWhere(apiInit: "in_the_darkness", region: "Moscow region", city: "Moscow")
		 def extTableInfoForCafee2 = ExtTablePlacesInfo.findOrSaveWhere(placesInTableAmount: 4, tableAmount: 8, tableForReservationAmount: 6)
		 extApiRequest2.addToPlacesInTable(extTableInfoForCafee2).save()
		 
		 double cost3 = 6.0
		 def extApiRequest3 = ApiRequest.findOrSaveWhere(apiInit: "novikov_api", cafeeName: "Novikov", totalReservationPlaces: 14, placeCost: cost2, currencyType: "USD",
			 isReservationAvailable: true, reservationTimeLimit: false, reservationDateLimit: false, totalPlaces: 25, startTimeLimit: new LocalTime(), endTimeLimit: new LocalTime(),
			 startDateLimit: new Date(), endDateLimit: new Date(), region: "Moscow region", city: "Moscow")
		 def extCafee3 = Cafee.findOrSaveWhere(apiInit: "novikov_api", region: "Moscow region", city: "Moscow")
		 def extTableInfoForCafee3 = ExtTablePlacesInfo.findOrSaveWhere(placesInTableAmount: 4, tableAmount: 8, tableForReservationAmount: 6)
		 def extTableInfoForCafee3_2 = ExtTablePlacesInfo.findOrSaveWhere(placesInTableAmount: 2, tableAmount: 6, tableForReservationAmount: 8)
		 def firstHall = ExtHallinfo.findOrSaveWhere(hallName: "First hall")
		 def secondHall = ExtHallinfo.findOrSaveWhere(hallName: "Second hall")		 
		 firstHall.addToTables(extTableInfoForCafee3).save(flush: true)
		 secondHall.addToTables(extTableInfoForCafee3_2).save(flush: true)
		 extApiRequest3.addToPlacesInTable(extTableInfoForCafee3).save(flush: true)
		 extApiRequest3.addToPlacesInTable(extTableInfoForCafee3_2).save(flush: true)
		 extApiRequest3.addToHall(firstHall).save(flush: true)
		 extApiRequest3.addToHall(secondHall).save(flush: true)
    }
    def destroy = {
    }
}
