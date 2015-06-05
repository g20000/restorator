package restorator

class TablePlacesInfo {
	int placesInTableAmount
	int tableAmount
	int tableForReservationAmount
	int placeCost
	String currencyType
	
	static scaffold = true
	static belongsTo = [hall: HallsZones]

    static constraints = {
		placesInTableAmount blank: true
		tableAmount blank: true
		tableForReservationAmount blank: true
		placeCost blank: true
		currencyType blank: true
		hall nullable: true
    }
}
