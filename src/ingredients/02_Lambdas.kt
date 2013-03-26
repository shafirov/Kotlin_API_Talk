package ingredients._02

inline fun <T> readAction(body: () -> T): T {
    // acquire lock here
    try {
        return body()
    }
    finally {
        // release lock here
    }
}

//--------------------------------------------------------------------------------------------------------

fun test() {
    // T is inferred as Unit
    readAction {
        print("I can read!")
    }

    // T is Int
    print("Sum of numbers from 1 to 10 = ${
        readAction {
            (1..10) reduce { i1, i2 -> i1 + i2 }
        }
    }")
}
