package restorator

import org.joda.time.LocalTime

import restorator.auth.Person
import billingMock.PaymentSystems

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
	String city = ""
	String region = ""
	String apiInit = ""
	String hall
	
	static hasMany = [admin: Person, availablePaymentSystems: PaymentSystems, halls: HallsZones]
	
    static constraints = {
		admin nullable: true
		hall nullable: true
		availablePaymentSystems nullable: true
		halls nullable: true
    }
			
	String getCafeeName(){
		return cafeeName
	}
}
