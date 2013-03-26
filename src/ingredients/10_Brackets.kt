package ingredients._10

import ingredients.*

class Property<T>(name: String)

open class Persistent(val id : Long) {
    fun <T> get(property: Property<T>) : T = nop()
    fun <T> set(property: Property<T>, value: T) {
        nop()
    }
}

open class Factory<T: Persistent>() {
    fun <P> find(p: Property<P>, value: P) : Iterable<T> {
        nop()
    }
}

//--------------------------------------------------------------------------------------------------------

class Person(id: Long) : Persistent(id) {
    class object: Factory<Person>()
}

val firstName = Property<String>("FIRST_NAME")
val age       = Property<Int>("AGE")

fun main(args: Array<String>) {
    for (person in Person.find(firstName, "Максим")) {
        println("${person[firstName]} is ${person[age]} years old")
    }
}
