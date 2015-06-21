package billingMock

class PaymentSystemsAvailable {
	String paymentSystemName
	boolean enabled = true
	
    static constraints = {
		paymentSystemName nullable: true
    }
}
