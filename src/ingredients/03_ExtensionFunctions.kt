package ingredients._03

fun String.pluralize(): String {
    return when(this) {
        "child" -> "children"
        "man" -> "men"
        "woman" -> "women"

        else -> when {
            endsWith("y") -> "${this}ies"
            else -> "${this}s"
        }
    }
}

