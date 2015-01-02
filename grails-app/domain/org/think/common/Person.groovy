package org.think.common

import org.think.security.User
import org.think.skills.Skill

class Person extends User {
	
	String firstName
	String lastName
	
	static hasMany = [skills : Skill]

    static constraints = {
    }
}
