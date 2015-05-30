package billingMock

import restorator.Cafee
import extApiMock.ApiRequest

class PaymentSystems {
	String paymentSystemName
	
	//static belongsTo = [cafee: Cafee, extCafee: ApiRequest]
	
    static constraints = {
		//extCafee nullable: true
		//cafee nullable: true
    }
}
