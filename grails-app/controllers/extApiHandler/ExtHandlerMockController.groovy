package extApiHandler

import org.joda.time.LocalTime

import extApiMock.ApiRequest
import grails.plugin.springsecurity.annotation.Secured

@Secured(['permitAll'])
class ExtHandlerMockController {

    def index() { }
	
	static def makeReserve(api, param){
		def cafee = ApiRequest.findByApiInit(api)
		def startTimeReservation = new LocalTime(Integer.parseInt(param['startTimeReservation_hour'])/*, Integer.parseInt(param['startTimeReservation_minute'])*/)
		def endTimeReservation = new LocalTime(Integer.parseInt(param['endTimeReservation_hour'])/*, Integer.parseInt(param['endTimeReservation_minute'])*/)
		
		if(startTimeReservation >= endTimeReservation){
			def errorCode = 4
			return errorCode
		}
				
		println "hello from makeReserve external"
		if(!cafee.isReservationAvailable){
			def errorCode = 1
			return errorCode
		}
		
		if(cafee.reservationDateLimit && (cafee.startDateLimit <= param['reservationDate']) && (cafee.endDateLimit >= param['reservationDate'])){
			def errorMessage = "You can reserve a place in this cafee between " + cafee.startDateLimit + " and " + cafee.endDateLimit
			return errorMessage
		}
		
		if(cafee.reservationTimeLimit && (cafee.startTimeLimit <= startTimeReservation) && (cafee.endTimeLimit >= startTimeReservation)
			&& (cafee.startTimeLimit <= endTimeReservation) && (cafee.endTimeLimit >= endTimeReservation)){
			def errorMessage = "You can reserve a place in this cafee between " + cafee.startTimeLimit + " and " + cafee.endTimeLimit
			return errorMessage
		}
					
		if(cafee.totalReservationPlaces < 1){
			def errorCode = 3
			return errorCode
		}
			
		println param['reservationDate']
		cafee.totalReservationPlaces -= 1
		if(!cafee.save()){
			cafee.errors.each {
				println it
			}
		}
		return cafee
	}
	
	static def deleteReservedTable(api){
		def cafee = ApiRequest.findByApiInit(api)
		cafee.totalReservationPlaces += 1
		if(!cafee.save()){
			cafee.errors.each {
				println it
			}
		}
		return cafee
	}
	
}
