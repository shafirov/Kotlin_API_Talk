package ingredients._07

import java.util.HashMap
import ingredients.*

class Person {
    private val bag : MutableMap<String, String> = HashMap()

    var age : Int
        get() = Integer.parseInt(bag.get("age") ?: error("Age is not specified!"))
        set(a) {
            bag.put("age", a.toString())
        }
}

//--------------------------------------------------------------------------------------------------------

fun teenagers(people: List<Person>) = people filter {it.age in 11..16} // *it* doesn't look right here :)
fun Person.letsHaveBirthday() = age++
