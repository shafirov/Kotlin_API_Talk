package ingredients._06

open class Persistent(id : Long)

open class Factory<T: Persistent>() {
    private val entityType = javaClass.getEnclosingClass()!!.getSimpleName()

    fun new() : T {
        val id = -1 // New record in DB.entityType
        return javaClass.getEnclosingClass()!!.getConstructors()[0].newInstance(id) as T
    }

    fun all() : Iterator<T> {
        return listOf<T>().iterator() // select * form DB.entityType
    }
}

//--------------------------------------------------------------------------------------------------------

class Person(id: Long) : Persistent(id) {
    class object: Factory<Person>()
}

fun main(args: Array<String>) {
    val alice = Person.new()

    for (person in Person.all()) {
        println("Doing something to $person")
    }
}
