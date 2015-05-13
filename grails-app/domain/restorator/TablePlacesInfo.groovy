package restorator

class TablePlacesInfo {
	int placesInTableAmount
	int tableAmount
	int tableForReservationAmount
	
	static belongsTo = [cafee: Cafee]

    static constraints = {
		placesInTableAmount blank: false
		tableAmount blank: false
		tableForReservationAmount blank: false
    }
}
