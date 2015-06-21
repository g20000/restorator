package billingMock

import restorator.Cafee
import extApiMock.ApiRequest

class PaymentSystems {
	String paymentSystemName
	//long bill
	boolean enabled = true
	
	//static belongsTo = [cafee: Cafee]
		
    static constraints = {
		//bill nullable: true
    }
}
