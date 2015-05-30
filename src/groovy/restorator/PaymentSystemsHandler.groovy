package restorator

import paymentSystems.VisaMockService


class PaymentSystemsHandler {
	
	static def VISA = "Visa"
	static def WEB_MONEY = "WebMoney"
	
	static def paymentRequest(String paimentSystem, String bill, double sum){
		switch(paimentSystem){
			case VISA : return VisaMockService.requestVisa(bill, sum)
			
			case WEB_MONEY : requestWebMoney(bill, sum)
							 break
			default : break
		}
	}
	
	static def requestWebMoney(bill, sum){
		
	}
}
