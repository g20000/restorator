package restorator

import org.joda.time.LocalTime

import extApiMock.ApiRequest
import extApiMock.ExtHallinfo;
import extApiMock.ExtTablePlacesInfo;
import grails.transaction.Transactional

@Transactional
class NovikovService {
	static def MINUTE_ZERO = 0
	
	static def makeReserve(api, param){
		def cafee = ApiRequest.findByApiInit(api)
		def startTimeReservation = new LocalTime(Integer.parseInt(param['startTimeReservation_hour']), MINUTE_ZERO)
		def endTimeReservation = new LocalTime(Integer.parseInt(param['endTimeReservation_hour']), MINUTE_ZERO)
		
		if(startTimeReservation >= endTimeReservation){
			//render "Start time reservation can not be more than end time reservation!"
			def errorCode = 4
			return errorCode
		}	
		
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
		
		def hall = ExtHallinfo.findWhere(hallName: param['hallsAvailable'])	
		def table = ExtTablePlacesInfo.findWhere(request: cafee, placesInTableAmount: Integer.parseInt(param['tablePlacesAvailable']), hall: hall)
		if(table == null){
			def errorCode = 3
			return errorCode
		}
		
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
		def hall = ExtHallinfo.findByHallName(places['hall'])
		def table = ExtTablePlacesInfo.findWhere(request: cafee, placesInTableAmount: Integer.parseInt(places['placesAmount']), hall: hall)
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
