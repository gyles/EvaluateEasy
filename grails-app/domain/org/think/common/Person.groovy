package org.think.common

import org.think.skills.Skill

class Person {
	
	String firstName
	String lastName
	
	static hasMany = [skills : Skill]

    static constraints = {
    }
}
