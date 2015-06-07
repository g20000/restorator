package restorator

import paymentSystems.VisaMockService


class PaymentSystemsHandler {
	
	static def VISA = "Visa"
	static def WEB_MONEY = "WebMoney"
	static def CHECK_BILL = "check_bill"
	static def DO_PAYMENT = "do_payment"
	
	static def paymentRequest(String paimentSystem, String action, String bill, double sum){
		switch(paimentSystem){
			case VISA : if(action == CHECK_BILL){
							return VisaMockService.requestVisa(bill, sum)
						}else if(action == DO_PAYMENT){
							return VisaMockService.doPayment(bill, sum)
						}
			
			case WEB_MONEY : requestWebMoney(bill, sum)
							 break
			default : break
		}
	}
	
	static def requestWebMoney(bill, sum){
		
	}
}
