package org.think.skills

import org.think.common.Person

class Skill {

    String name
	Integer rating
	
	static hasMany = [persons : Person]
	static belongsTo = Person

    static constraints = {
    }
}
