package restoratorUserSpace

import restorator.Cafee
import restorator.HallsZones
import restorator.TablePlacesInfo
import restorator.auth.Person
import billingMock.PaymentSystems
import extApiHandler.ApiHandlerController
import extApiMock.ApiRequest
import grails.plugin.springsecurity.SpringSecurityService
import grails.plugin.springsecurity.annotation.Secured

@Secured(['ROLE_ROOT_ADMIN'])
class RootAdminSpaceController {
	def springSecurityService = new SpringSecurityService()
	
    def index() { 
		ArrayList<Cafee>allCafees = Cafee.list()
		ArrayList<Cafee>availableCafee = new ArrayList<Cafee>()
		ApiRequest apiRequest
		for(Cafee cafee : allCafees){
			if(cafee.apiInit != ""){
				apiRequest = ApiHandlerController.request(cafee.apiInit)
				availableCafee.add(new Cafee(cafeeName: apiRequest.cafeeName, placeCost: apiRequest.placeCost, currencyType: apiRequest.currencyType, apiInit: apiRequest.apiInit,
					city: apiRequest.getCity(), region: apiRequest.getRegion()))
			}else{
				availableCafee.add(cafee)
			}
		}
		
		render (view:'index.gsp', model: [availableCafee: availableCafee])
	}
	
	def goToCafeePage(params){
		ApiRequest apiRequest
		def goalCafee
		try {
			if(params['cafeeApiInit'] != ""){
				apiRequest = ApiHandlerController.request(params['cafeeApiInit'])
						goalCafee = new Cafee(cafeeName: apiRequest.cafeeName, placeCost: apiRequest.placeCost, currencyType: apiRequest.currencyType, apiInit: apiRequest.apiInit, 
								endTimeLimit : apiRequest.endTimeLimit)
				
				ArrayList<Integer>tablePlaces = new ArrayList<Integer>()
				for(int places : apiRequest.places){
					tablePlaces.add(new TablePlacesInfo(placesInTableAmount : places))
				}
				
				ArrayList<String>hallNames = new ArrayList<String>()
						for(String hall : apiRequest.halls){
							hallNames.add(hall)
						}
				
				render (view:'cafeeInfo.gsp', model: [cafeeName: goalCafee, tableInfo: tablePlaces, halls: hallNames])
			}else{
					goalCafee = Cafee.findById(params['id'])
					def owner = goalCafee.admin.iterator().next()
					def halls = HallsZones.findAllWhere(cafee : goalCafee)
					def tablePlacesQuery = TablePlacesInfo.createCriteria()			
					def tablePlaces = tablePlacesQuery.list {
				'in'("hall", halls)
				}
				
				ArrayList<String>hallNames = new ArrayList<String>()
						for(def hall : halls){
							hallNames.add(hall.getHallName())
						}
				render (view:'cafeeInfo.gsp', model: [cafeeName: goalCafee, cafeeOwner: owner])
			}
		} catch (Exception e) {
			render (view:'error.gsp')
			e.printStackTrace()
		}
	}
	
	def showUsers(){
		def users = Person.list()
		render (view:'users.gsp', model: [usersList: users])
	}
	
	def goToUserInfo(params){
		def user = Person.findById(params['id'])
		render (view:'userInfo.gsp', model: [userInfo: user])
	}
	
	def editPrivateData(){
		def user = springSecurityService.currentUser
		if(user.isAdminCafee){
			render (view:'editPrivateData.gsp', model: [user: user])
		}else{
			render (view:'editPrivateData.gsp', model: [user: user])
		}
	}
	
	def setupBillingSystem(){
		def user = Person.findByUsername(springSecurityService.currentUser.username)
		def cafee = user.cafee
		Map<String, Boolean>paymentSystemsStatus = new HashMap<String, Boolean>()
		def paymentSystems = PaymentSystems.list()
		for(def paymentSystem : paymentSystems){
			if(paymentSystem.getEnabled()){
				paymentSystemsStatus.put(paymentSystem.getPaymentSystemName(), true)
			}else{
				paymentSystemsStatus.put(paymentSystem.getPaymentSystemName(), false)
			}
		}
		render (view:'billingSystemControl.gsp', model: [paymentSystems: paymentSystemsStatus])
	}
	
	def saveSetupBillingSystems(params){
		Map<String, Boolean>paymentSystemsStatus = new HashMap<String, Boolean>()
		def paymentSystems = PaymentSystems.list()
		def service
		for(def paymentSystem : paymentSystems){
			if(params.containsKey(paymentSystem.getPaymentSystemName())){
				service = PaymentSystems.findByPaymentSystemName(paymentSystem.getPaymentSystemName())
				service.enabled = true
				if(!service.save(flush:true)){
					service.errors.each{
						println it
					}
					return
				}
			}else if(!params.containsKey(paymentSystem.getPaymentSystemName())){
				service = PaymentSystems.findByPaymentSystemName(paymentSystem.getPaymentSystemName())
				service.enabled = false
				if(!service.save(flush:true)){
					service.errors.each{
						println it
					}
					return
				}
			}
		}
		setupBillingSystem()
	}
}