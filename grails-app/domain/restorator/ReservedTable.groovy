package restorator

class ReservedTable {
	String visitor
	String owner
	String cafeeName

    static constraints = {
    }
	
	String getCafeeName(){
		return cafeeName
	}
}
