package restorator

class Cafee {
	
	String cafeeName = ""
	String owner = ""
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
	
    static constraints = {
		cafeeName blank: false, unique: true
		owner blank: false, unique: true
    }
}
