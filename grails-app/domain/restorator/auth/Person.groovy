package restorator.auth

class Person {

	transient springSecurityService

	String username
	String password
	boolean enabled = true
	boolean accountExpired
	boolean accountLocked
	boolean passwordExpired
	
	String firstName
	String lastName
	String email
	String inn = ""
	String cafee = ""
	boolean isAdminCafee = false
	static transients = ['springSecurityService']

	static constraints = {
		username blank: false, unique: true
		firstName blank: false
		lastName blank: false
		password blank: false
		email blank: false, unique: true
	}

	static mapping = {
		password column: '`password`'
	}

	Set<Authority> getAuthorities() {
		PersonAuthority.findAllByPerson(this).collect { it.authority }
	}

	def beforeInsert() {
		encodePassword()
	}

	def beforeUpdate() {
		if (isDirty('password')) {
			encodePassword()
		}
	}

	protected void encodePassword() {
		password = springSecurityService?.passwordEncoder ? springSecurityService.encodePassword(password) : password
	}
}
