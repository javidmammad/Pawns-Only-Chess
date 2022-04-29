package chess

class Storage {
    companion object {
        var firstPlayer = ""
        var secondPlayer = ""
        var isWhite = true
        val lastMoves = mutableListOf("")
        var pawns: MutableList<MutableList<String>> = getInitPawns()

        fun currentPawns() = if (isWhite) pawns[0] else pawns[1]
        fun oppositePawns() = if (isWhite) pawns[1] else pawns[0]
        fun curPawnName() = if (isWhite) "white" else "black"

        private fun getInitPawns(): MutableList<MutableList<String>> {
            val blackPawns = mutableListOf<String>()
            val whitePawns = mutableListOf<String>()
            for (column in 'a'..'h') {
                blackPawns.add("${column}7")
                whitePawns.add("${column}2")
            }
            return mutableListOf(whitePawns, blackPawns)
        }
    }
}