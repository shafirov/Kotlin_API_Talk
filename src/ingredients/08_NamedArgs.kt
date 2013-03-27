package ingredients._08

//--------------------------------------------------------------------------------------------------------

data class Person(val lastName: String, val firstName: String)

fun display(people: List<Person>) {
    val names = people map { "${it.firstName} ${it.lastName}" }

    println(names.makeString(", "))

    println(names.makeString(separator = ", ", prefix = "[", postfix = "]"))

    println(names.makeString(", ", prefix = "[", postfix = "]",
            limit = 5, truncated = "*"))
}

fun main(args: Array<String>) {
    display(listOf(
            Person("Авдеев", "Дмитрий"),
            Person("Батькович", "Дмитрий"),
            Person("Дернов", "Андрей"),
            Person("Евдокимов", "Сергей"),
            Person("Забродина", "Надежда"),
            Person("Жданов", "Денис"),
            Person("Игнатов", "Сергей"),
            Person("Куделевский", "Евгений"),
            Person("Кудрявцев", "Алексей"),
            Person("Кудряшов", "Василий"),
            Person("Лепенькин", "Ярослав"),
            Person("Лиходедов", "Кирилл"),
            Person("Лобас", "Александр"),
            Person("Медведев", "Максим"),
            Person("Серебряков", "Сергей"),
            Person("Чашников", "Николай"),
            Person("Чепцов", "Андрей"),
            Person("Чернушина", "Ирина"),
            Person("Шафиров", "Максим"),
            Person("Шраго", "Григорий"),
            Person("Фокин", "Денис"))
    )
}

