package extApiMock

import java.util.Date;

import org.joda.time.LocalTime;

class ApiRequest {
	String apiInit = ""
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
		
    static constraints = {
		apiInit blank: false, unique: true
    }
			
	String getCafeeName(){
		return cafeeName
	}
}
