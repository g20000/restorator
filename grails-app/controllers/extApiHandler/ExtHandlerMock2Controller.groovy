package extApiHandler

import org.joda.time.LocalTime

import extApiMock.ApiRequest
import extApiMock.ExtTablePlacesInfo;
import grails.plugin.springsecurity.annotation.Secured

@Secured(['permitAll'])
class ExtHandlerMock2Controller {

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
			
		def table = ExtTablePlacesInfo.findWhere(request: cafee, placesInTableAmount: Integer.parseInt(param['tablePlacesAvailable']))
		if(table.tableForReservationAmount < 1){
			render "Sorry, no more such tables for reservation"
			return
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
