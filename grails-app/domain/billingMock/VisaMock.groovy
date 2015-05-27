package billingMock

class VisaMock {
	String number
	int sum
	
    static constraints = {
		number nullable: false, unique: true, creditCard: true
		sum nullable: false
    }
}
