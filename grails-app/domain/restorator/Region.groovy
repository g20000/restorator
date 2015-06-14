package restorator

class Region {
	String regionName
	
	static hasMany = [cities : City]
	
    static constraints = {
    }
}
