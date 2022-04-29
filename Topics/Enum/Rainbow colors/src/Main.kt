import java.util.*

enum class Rainbow(val color: String) {
    RED("red"),
    ORANGE("orange"),
    YELLOW("yellow"),
    GREEN("green"),
    BLUE("blue"),
    INDIGO("indigo"),
    VIOLET("violet")
}

fun main() {
    val input = readLine()!!
    for (each in Rainbow.values()) {
        if (input.lowercase(Locale.getDefault()) == each.color) {
            println(true)
            return
        }
    }
    println(false)
}