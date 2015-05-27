package extApiMock


class ExtHallinfo {
	String hallName
	
	static belongsTo = [request: ApiRequest]
	static hasMany = [tables: ExtTablePlacesInfo]
	
    static constraints = {
		request nullable: true
		tables nullable: true
    }
}
