package restorator

import org.joda.time.LocalTime

import extApiMock.ApiRequest
import grails.plugin.springsecurity.annotation.Secured

@Secured(['permitAll'])
class ExtHandlerMockController {

    def index() { }
	
	static def makeReserve(api, param){
		def cafee = ApiRequest.findByApiInit(api)
		def startTimeReservation = new LocalTime(Integer.parseInt(param['startTimeReservation_hour']), Integer.parseInt(param['startTimeReservation_minute']))
		def endTimeReservation = new LocalTime(Integer.parseInt(param['endTimeReservation_hour']), Integer.parseInt(param['endTimeReservation_minute']))
		
		if(startTimeReservation >= endTimeReservation){
			render "Start time reservation can not be more than end time reservation!"
			return
		}
				
		println "hello from makeReserve external"
		if(!cafee.isReservationAvailable){
			render "Sorry, this cafee closed for reservation at the moment!"
			return
		}
		
		if(cafee.reservationDateLimit && (cafee.startDateLimit <= param['reservationDate']) && (cafee.endDateLimit >= param['reservationDate'])){
			render "You can reserve a place in this cafee between " + cafee.startDateLimit + " and " + cafee.endDateLimit
			return
		}
		
		if(cafee.reservationTimeLimit && (cafee.startTimeLimit <= startTimeReservation) && (cafee.endTimeLimit >= startTimeReservation)
			&& (cafee.startTimeLimit <= endTimeReservation) && (cafee.endTimeLimit >= endTimeReservation)){
			render "You can reserve a place in this cafee between " + cafee.startTimeLimit + " and " + cafee.endTimeLimit
			return
		}
					
		if(cafee.totalReservationPlaces < 1){
			render "Sorry, no more free places in this cafee for reservation"
			return
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
