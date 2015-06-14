package restorator

import grails.converters.JSON
import grails.plugin.springsecurity.annotation.Secured

@Secured(['permitAll'])
class RegionController {

    def ajaxGetCities = {
		println "hello"
		def region = Region.get(params.id)
		render region?.cities as JSON
	}
	
	def categoryChanged(long regionId) {
		println regionId
		Region region = Region.get(regionId)
		def subCategories = []
		if ( region != null ) {
			subCategories = City.findAllWhere(region : region, [order:'cityName'])
		}
		render g.select(id:'subCategory', name:'subCategory.id',
			from:subCategories, optionKey:'id', noSelection:[null:'Выберите город'], optionValue: 'cityName'
		)
	}
}
