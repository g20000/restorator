package restorator

import extApiMock.ApiRequest

class ExtTablePlacesInfo {
	
	int placesInTableAmount
	int tableAmount
	int tableForReservationAmount
	
	static belongsTo = [request: ApiRequest]

	static constraints = {
		placesInTableAmount blank: false
		tableAmount blank: false
		tableForReservationAmount blank: false
	}
}
