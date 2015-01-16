package org.think.skills

import org.think.common.Person

class Skill {

    String name
	
	static hasMany = [persons : Person]
	static belongsTo = Person

    static constraints = {
    }
}
