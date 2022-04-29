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
    val input = readLine()!!.lowercase(Locale.getDefault())
    Rainbow.values().forEachIndexed{ ind,it ->
        run {
            if (input == it.color) {
                println(ind + 1)
            }
        }
    }
}