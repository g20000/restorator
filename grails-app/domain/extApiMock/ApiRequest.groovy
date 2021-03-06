package extApiMock

import org.joda.time.LocalTime

import billingMock.PaymentSystems

class ApiRequest {
	String apiInit = ""
    String cafeeName = ""
	int totalReservationPlaces = 0
	double placeCost
	double totalCost
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
	ArrayList<Integer> places
	ArrayList<String> halls
	ArrayList<String> paymentSystems
	int placesInSelectedTable
	String selectedHall
		
	static hasMany = [placesInTable: ExtTablePlacesInfo, hall: ExtHallinfo, availablePaymentSystems: PaymentSystems]
		
    static constraints = {
		apiInit blank: false, unique: true
		placesInTable nullable: true
		places nullable: true
		totalCost nullable: true
		placesInSelectedTable nullable: true
		hall nullable: true
		halls nullable: true
		selectedHall nullable: true
		availablePaymentSystems nullable: true
    }
			
	String getCafeeName(){
		return cafeeName
	}
}
