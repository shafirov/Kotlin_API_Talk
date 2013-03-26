package ingredients._05

public trait StringEnum<T : Enum<T>> : Enum<T> {
    fun value() = name()
}

//--------------------------------------------------------------------------------------------------------

enum class Colors : StringEnum<Colors> {black white green blue red pink}

enum class MimeTypes(val display : String) : StringEnum<MimeTypes> {
    pdf : MimeTypes("application/pdf")
    form : MimeTypes("multipart/form-data")

    override fun value() = display
}

fun main(args: Array<String>) {
    describe(MimeTypes.form)
    describe(Colors.red)
}

fun describe(item : StringEnum<*>) {
    // Calls name() from Enum, value() from the trait
    println("${item.javaClass.getSimpleName()}.${item.name()} = ${item.value()}")
}
