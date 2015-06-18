package paymentSystems

import grails.transaction.Transactional
import billingMock.VisaMock

@Transactional
class VisaMockService {

    static def requestVisa(bill, sum) {
		def visaBill = VisaMock.findByNumber(bill)
		if(visaBill != null){
			if(sum <= visaBill.getSum()){
				/*visaBill.sum -= sum
				if(!visaBill.save(flush:true)){
					visaBill.errors.each{
						println it
					}
					return 1
				}*/
				return 0
			}else{
				return -1
			}
		}else{
			return 1
		}
    }
	
	static def doPayment(bill, sum){
		def visaBill = VisaMock.findByNumber(bill)
		visaBill.sum -= sum
		println visaBill.getSum()
		if(!visaBill.save(flush:true)){
			visaBill.errors.each{
				println it
			}
			return 1
		}
	}
}
