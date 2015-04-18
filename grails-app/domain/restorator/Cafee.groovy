package restorator

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
	long startTimeLimit = 0
	long endTimeLimit = 0
	Date startDateLimit = new Date()
	Date endDateLimit = new Date()	
	
	static hasMany = [admin: Person]
	
    static constraints = {
		cafeeName blank: false, unique: true
    }
			
	String getCafeeName(){
		return cafeeName
	}
}
