package restorator

import org.joda.time.LocalTime
import org.joda.time.format.DateTimeFormatter

import restorator.auth.Person

class ReservedTable {
	Person visitor
	Person owner
	Cafee cafeeName
	LocalTime startTimeLimit = new LocalTime()
	LocalTime endTimeLimit = new LocalTime()
	Date reservationDate = new Date()
	int places
	double cost
	String hall

	static scaffold = true
    static constraints = {
		visitor blank: false
		owner nullable: true
		cafeeName blank: false
		places nullable: true
		cost nullable: true
		hall nullable: true
		endTimeLimit nullable: true
    }
}
