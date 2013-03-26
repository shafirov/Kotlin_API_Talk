package ingredients._09

import java.util.HashMap
import ingredients._09.Color.*

class Machine<A, S: Enum<S>>(val initial: S) {
    private val transitions = HashMap<S, (s : A) -> S>()
    fun S.invoke(transition: (s : A) -> S) {
        transitions[this] = transition
    }

    fun play(sequence: Iterator<A>) {
        var state = initial
        for (a in sequence) {
            print("($state, $a) -> ")
            state = transitions[state](a)
            println("$state")
        }
    }
}

fun <A, S: Enum<S>> machine(initial: S, build: Machine<A, S>.()->Unit) : Machine<A, S> {
    val answer = Machine<A, S>(initial)
    answer.build()
    return answer
}

//--------------------------------------------------------------

enum class Color {red green blue}

fun main(args: Array<String>) {
    machine<Char, Color>(red) {
        red {
            when (it) {
                '0' -> green
                '1' -> blue
                else -> red
            }
        }

        green {
            when (it) {
                '0' -> red
                else -> green
            }
        }

        blue {
            when (it) {
                in '0'..'9' -> red
                else -> blue
            }
        }
    } play "01010203049234823451920349023490".iterator()
}
