package restorator

import grails.converters.JSON

class RegionController {

    def ajaxGetCities = {
		println "hello"
		def region = Region.get(params.id)
		render region?.cities as JSON
	}
	
	def categoryChanged(long regionId) {
		println "test"
		Region region = Region.get(regionId)
		def subCategories = []
		if ( region != null ) {
			subCategories = City.findAllByRegion(region, [order:'cityName'])
		}
		render g.select(id:'subCategory', name:'subCategory.id',
			from:subCategories, optionKey:'id', noSelection:[null:' ']
		)
	}
}
