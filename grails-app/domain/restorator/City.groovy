package restorator

class City {
	String cityName
	static belongsTo = [region : Region]
	
    static constraints = {
    }
}
