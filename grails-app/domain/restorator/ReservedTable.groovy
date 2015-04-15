package restorator

class ReservedTable {
	String visitor = ""
	String owner = ""
	String cafeeName = ""

    static constraints = {
		visitor blank: false
		owner blank: false
		cafeeName blank: false
    }
	
	String getCafeeName(){
		return cafeeName
	}
}
