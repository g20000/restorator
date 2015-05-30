package restorator

import extApiMock.ApiRequest
import extApiMock.ExtHallinfo;
import extApiMock.ExtTablePlacesInfo;
import grails.transaction.Transactional

import org.joda.time.LocalTime

@Transactional
class TrizetService {

    static def makeReserve(api, param){
		def cafee = ApiRequest.findByApiInit(api)
		def startTimeReservation = new LocalTime(Integer.parseInt(param['startTimeReservation_hour']), Integer.parseInt(param['startTimeReservation_minute']))
				
		println "hello from makeReserve external"
		if(!cafee.isReservationAvailable){
			render "Sorry, this cafee closed for reservation at the moment!"
			return
		}
		
		if(cafee.reservationDateLimit && (cafee.startDateLimit <= param['reservationDate']) && (cafee.endDateLimit >= param['reservationDate'])){
			render "You can reserve a place in this cafee between " + cafee.startDateLimit + " and " + cafee.endDateLimit
			return
		}
		
		if(cafee.reservationTimeLimit && (cafee.startTimeLimit <= startTimeReservation)){
			render "You can reserve a place in this cafee since " + cafee.startTimeLimit
			return
		}
					
		if(cafee.totalReservationPlaces < 1){
			render "Sorry, no more free places in this cafee for reservation"
			return
		}
		
		def hall = ExtHallinfo.findWhere(hallName: param['hallsAvailable'])
		def table = ExtTablePlacesInfo.findWhere(request: cafee, hall: hall)
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
		def hall = ExtHallinfo.findByHallName(places['hall'])
		def table = ExtTablePlacesInfo.findWhere(request: cafee, hall: hall)
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