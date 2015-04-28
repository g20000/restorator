package restorator

import org.joda.time.LocalTime

import restorator.auth.Person

class ReservedTable {
	Person visitor
	Person owner
	Cafee cafeeName
	LocalTime startTimeLimit = new LocalTime()
	LocalTime endTimeLimit = new LocalTime()
	Date reservationDate = new Date()

    static constraints = {
		visitor blank: false
		owner blank: false
		cafeeName blank: false
    }
}
