@SuppressWarnings("MagicNumber")
data class Player(val id: Int, val name: String) {
    companion object {
        private const val defaultSpeed = 8
        fun calcMovePenalty(cell: Int): Int = defaultSpeed - cell % 3
    }
}

fun calculatePlayerSpeed(cell: Int): Int {
    return Player.calcMovePenalty(cell)
}