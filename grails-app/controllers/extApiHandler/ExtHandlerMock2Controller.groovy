package extApiHandler

import org.joda.time.LocalTime

import extApiMock.ApiRequest
import extApiMock.ExtTablePlacesInfo;
import grails.plugin.springsecurity.annotation.Secured

@Secured(['permitAll'])
class ExtHandlerMock2Controller {
	static def MINUTE_ZERO = 0
    def index() { }
	
	static def makeReserve(api, param){
		def cafee = ApiRequest.findByApiInit(api)
		def startTimeReservation = new LocalTime(Integer.parseInt(param['startTimeReservation_hour']), MINUTE_ZERO)
		def endTimeReservation = new LocalTime(Integer.parseInt(param['endTimeReservation_hour']), MINUTE_ZERO)
		
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
			def errorCode = 2
			return errorCode
		}
			
		def table = ExtTablePlacesInfo.findWhere(request: cafee, placesInTableAmount: Integer.parseInt(param['tablePlacesAvailable']))
		if(table.tableForReservationAmount < 1){
			def errorCode = 3
			return errorCode
		}
		table.tableForReservationAmount -= 1
		cafee.totalReservationPlaces -= 1
		
		if(!table.save()){
			table.errors.each {
				println it
			}
		}
		
		if(!cafee.save()){
			cafee.errors.each {
				println it
			}
		}
		return cafee
	}
	
	static def deleteReservedTable(api, places){
		def cafee = ApiRequest.findByApiInit(api)
		def table = ExtTablePlacesInfo.findWhere(request: cafee, placesInTableAmount: Integer.parseInt(places['placesAmount']))
		table.tableForReservationAmount += 1
		cafee.totalReservationPlaces += 1
		
		if(!table.save()){
			table.errors.each {
				println it
			}
		}
		
		if(!cafee.save()){
			cafee.errors.each {
				println it
			}
		}
		return cafee
	}
}
