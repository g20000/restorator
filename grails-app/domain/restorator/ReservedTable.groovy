package restorator

import restorator.auth.Person

class ReservedTable {
	Person visitor
	Person owner
	Cafee cafeeName

    static constraints = {
		visitor blank: false
		owner blank: false
		cafeeName blank: false
    }
}
