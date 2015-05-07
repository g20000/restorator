package restorator

import org.joda.time.LocalTime

import restorator.auth.Person

class Cafee {
	
	String cafeeName = ""
	int totalReservationPlaces = 0
	double placeCost = 0
	String currencyType = ""
	boolean isReservationAvailable = false
	boolean reservationTimeLimit = false
	boolean reservationDateLimit = false
	int totalPlaces = 0
	LocalTime startTimeLimit = new LocalTime()
	LocalTime endTimeLimit = new LocalTime()
	Date startDateLimit = new Date()
	Date endDateLimit = new Date()
	String region = ""
	String city = ""
	String apiInit = ""	
	
	static hasMany = [admin: Person]
	
    static constraints = {
		cafeeName blank: false, unique: true
    }
			
	String getCafeeName(){
		return cafeeName
	}
}
