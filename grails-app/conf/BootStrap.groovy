import org.think.common.Person
import org.think.security.Role
import org.think.security.UserRole

class BootStrap {

    def springSecurityService

    def init = { servletContext ->
		
		def defaultUsers = [
			new Person(firstName: "Juan", lastName: "Dela Cruz"),
			new Person(firstName: "Noy", lastName: "Aquino")
		]
		
		def userRole = Role.findByAuthority("ROLE_USER") ?: new Role(authority: "ROLE_USER").save();
		def adminRole = Role.findByAuthority("ROLE_ADMIN") ?: new Role(authority: "ROLE_ADMIN").save();
		
		def persons = Person.list() ?: []
		
		if (!persons) {
			defaultUsers.each { person ->
				println "Creating person ${person.firstName}"
				person.username = person.firstName
				person.password = person.lastName
				person.enabled = true;
				if (person.validate()) {
					person.save(failOnError:true)
					
					UserRole.create person, adminRole
				}
				else {
					println "Person not valid ${person.firstName}"
				}
			}
		}
    }
	
    def destroy = {
    }
}
