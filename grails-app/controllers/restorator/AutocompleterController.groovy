package restorator

import grails.converters.deep.JSON

class AutocompleterController {

    def index() { }
	
	def completeCity(){
		println "hi1"
		def cafees = Cafee.findAllByCityLike("%${params.query}")
		render(contentType: "text/xml") {
			results() {
			cafees.each { cafee ->
			result(){
				city(cafee.getCity())
						//Optional id which will be available in onItemSelect
						id(cafee.id)
					}
				}
			}
		}
	}
	
	def complist = {
		render AutocompleterService.complist(params) as JSON
	}
}
