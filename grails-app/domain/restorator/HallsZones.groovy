package restorator

class HallsZones {
	String hallName
	
	static scaffold = true
	static hasMany = [table : TablePlacesInfo]
	static belongsTo = [cafee : Cafee]
	
    static constraints = {
		table nullable: true
		cafee nullable: true
    }
}
