package restorator

class TablePlacesInfo {
	int placesInTableAmount
	int tableAmount
	int tableForReservationAmount
	
	static belongsTo = [cafee: Cafee]

    static constraints = {
		placesInTableAmount blank: true
		tableAmount blank: true
		tableForReservationAmount blank: true
    }
}
