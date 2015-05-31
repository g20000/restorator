package restorator

import grails.transaction.Transactional

@Transactional
class AutocompleterService {
	//println "hi"
	/*def selectedCafee = Cafee.findAllByCityLike("%${params.query}")
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
	}*/
    def complist(params){
    def query = {
    or {
     like("nasdaqSymbol", "${params.term}%") // term is the parameter send by jQuery autocomplete
     //like("companyName", "${params.term}%")
    }
  projections { // good to select only the required columns.
     property("id")
     property("nasdaqSymbol")
     //property("companyName")
    }
   }
   def clist = Cafee.findAllByCityLike(query) // execute  to the get the list of companies
   def companySelectList = [] // to add each company details
   clist.each {
    def companyMap = [:] // add to map. jQuery autocomplete expects the JSON object to be with id/label/value.
    companyMap.put("id", it[0])
    companyMap.put("label", it[2])
    //companyMap.put("value", it[2])
    //companyMap.put("nasSymbol", it[1]) // will use this to pre-populate the Emp Id
    companySelectList.add(companyMap) // add to the arraylist
 }
   return companySelectList
}
}
