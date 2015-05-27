import org.joda.time.LocalTime

import billingMock.VisaMock;
import restorator.Cafee
import restorator.auth.Authority
import restorator.auth.Person
import restorator.auth.PersonAuthority
import extApiMock.ApiRequest
import extApiMock.ExtHallinfo;
import extApiMock.ExtTablePlacesInfo;

class BootStrap {
	def springSecurityService
    def init = { servletContext ->
		 def adminRole = Authority.findOrSaveWhere(authority: 'ROLE_ADMIN')
		 def visitorRole = Authority.findOrSaveWhere(authority: 'ROLE_VISITOR')
		 def password = springSecurityService.encodePassword('password')
		 		 
		 def newCafe = new Cafee(cafeeName: "Tarelka", region: "Mari El", city: "Yoshkar Ola").addToAdmin(new Person(username: 'testerAndrewRes', password:'password',
			 accountExpired: false, accountLocked: false, passwordExpired: false, 
			 firstName:'Andrew', lastName:'Bobkov', email:'pragmus2@gmail.com', isAdminCafee: true,
			 inn: '1234567890')).save(flush:true)
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
			 inn: '9876543210')).save(flush:true)
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
		 extApiRequest2.addToPlacesInTable(extTableInfoForCafee2).save(flush:true)
		 
		 double cost3 = 6.0
		 def extApiRequest3 = ApiRequest.findOrSaveWhere(apiInit: "novikov_api", cafeeName: "Novikov", totalReservationPlaces: 14, placeCost: cost3, currencyType: "USD",
			 isReservationAvailable: true, reservationTimeLimit: false, reservationDateLimit: false, totalPlaces: 25, startTimeLimit: new LocalTime(), endTimeLimit: new LocalTime(),
			 startDateLimit: new Date(), endDateLimit: new Date(), region: "Moscow region", city: "Moscow")
		 def extCafee3 = Cafee.findOrSaveWhere(apiInit: "novikov_api", region: "Moscow region", city: "Moscow")
		 def extTableInfoForCafee3 = new ExtTablePlacesInfo(placesInTableAmount: 4, tableAmount: 8, tableForReservationAmount: 6).save(flush:true)
		 def extTableInfoForCafee3_2 = new ExtTablePlacesInfo(placesInTableAmount: 2, tableAmount: 6, tableForReservationAmount: 8).save(flush:true)
		 def firstHall = ExtHallinfo.findOrSaveWhere(hallName: "First hall")
		 def secondHall = ExtHallinfo.findOrSaveWhere(hallName: "Second hall")		 
		 firstHall.addToTables(extTableInfoForCafee3).save(flush: true)
		 secondHall.addToTables(extTableInfoForCafee3_2).save(flush: true)
		 extApiRequest3.addToPlacesInTable(extTableInfoForCafee3).save(flush: true)
		 extApiRequest3.addToPlacesInTable(extTableInfoForCafee3_2).save(flush: true)
		 extApiRequest3.addToHall(firstHall).save(flush: true)
		 extApiRequest3.addToHall(secondHall).save(flush: true)
		 
		 double cost4 = 7.2
		 def extApiRequest4 = ApiRequest.findOrSaveWhere(apiInit: "piter_api", cafeeName: "Piter", totalReservationPlaces: 15, placeCost: cost4, currencyType: "EUR",
			 isReservationAvailable: true, reservationTimeLimit: false, reservationDateLimit: false, totalPlaces: 25, startTimeLimit: new LocalTime(), endTimeLimit: new LocalTime(),
			 startDateLimit: new Date(), endDateLimit: new Date(), region: "Saint Petersburg region", city: "Saint Petersburg")
		 def extTableInfoForCafee4 = new ExtTablePlacesInfo(tableAmount: 8, tableForReservationAmount: 7).save(flush:true)
		 def extTableInfoForCafee4_2 = new ExtTablePlacesInfo(tableAmount: 6, tableForReservationAmount: 8).save(flush:true)
		 def extCafee4 = Cafee.findOrSaveWhere(apiInit: "piter_api", region: "Saint Petersburg region", city: "Saint Petersburg")
		 def grandHall = ExtHallinfo.findOrSaveWhere(hallName: "Grand hall")
		 def smokingHall = ExtHallinfo.findOrSaveWhere(hallName: "Smoking hall")
		 
		 grandHall.addToTables(extTableInfoForCafee4).save(flush: true)
		 smokingHall.addToTables(extTableInfoForCafee4_2).save(flush: true)
		 extApiRequest4.addToPlacesInTable(extTableInfoForCafee4).save(flush: true)
		 extApiRequest4.addToPlacesInTable(extTableInfoForCafee4_2).save(flush: true)
		 		 
		 extApiRequest4.addToHall(grandHall).save(flush: true)
		 extApiRequest4.addToHall(smokingHall).save(flush: true)
		 
		 double cost5 = 8.2
		 def extApiRequest5 = ApiRequest.findOrSaveWhere(apiInit: "trizet_api", cafeeName: "Trizet", totalReservationPlaces: 10, placeCost: cost5, currencyType: "EUR",
			 isReservationAvailable: true, reservationTimeLimit: false, reservationDateLimit: false, totalPlaces: 14, startTimeLimit: new LocalTime(),
			 startDateLimit: new Date(), endDateLimit: new Date(), region: "Saint Petersburg region", city: "Saint Petersburg")
		 def extTableInfoForCafee5 = new ExtTablePlacesInfo(tableAmount: 8, tableForReservationAmount: 5).save(flush:true)
		 def extTableInfoForCafee5_2 = new ExtTablePlacesInfo(tableAmount: 6, tableForReservationAmount: 5).save(flush:true)
		 def extCafee5 = Cafee.findOrSaveWhere(apiInit: "trizet_api", region: "Saint Petersburg region", city: "Saint Petersburg")
		 def darkHall = ExtHallinfo.findOrSaveWhere(hallName: "Dark hall")
		 def openHall = ExtHallinfo.findOrSaveWhere(hallName: "Open hall")
		 
		 darkHall.addToTables(extTableInfoForCafee5).save(flush: true)
		 openHall.addToTables(extTableInfoForCafee5_2).save(flush: true)
		 extApiRequest5.addToPlacesInTable(extTableInfoForCafee5).save(flush: true)
		 extApiRequest5.addToPlacesInTable(extTableInfoForCafee5_2).save(flush: true)
				  
		 extApiRequest5.addToHall(darkHall).save(flush: true)
		 extApiRequest5.addToHall(openHall).save(flush: true)
		 
		 def bill = VisaMock.findOrSaveWhere(number: "1234567890123456", sum: 100)
		 def bill2 = VisaMock.findOrSaveWhere(number: "6543210123456700", sum: 10)
    }
    def destroy = {
    }
}
