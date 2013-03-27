package ingredients

public fun error(message: String): Nothing = throw RuntimeException(message)
public fun nop(): Nothing = throw UnsupportedOperationException()
