package chess

import chess.Storage.Companion.curPawnName
import chess.Storage.Companion.currentPawns
import chess.Storage.Companion.isWhite
import chess.Storage.Companion.oppositePawns

class EndGameLogic {
    companion object {
        fun isGameContinue(): Boolean {
            if (isAnyWin() || isStaleMate()) {
                return false
            }
            return true
        }

        private fun isAnyWin(): Boolean { //success
            val winPoint = if (isWhite) '8' else '1'
            currentPawns().forEach { each ->
                if (each[1] == winPoint) {
                    println("${curPawnName().replaceFirstChar { it.uppercase() }} Wins!\nBye!")
                    return true
                }
            }
            if (oppositePawns().size == 0) {
                println("${curPawnName().replaceFirstChar { it.uppercase() }} Wins!\nBye!")
                return true
            }
            return false
        }

        private fun isStaleMate(): Boolean {
            isWhite = !isWhite
            currentPawns().forEach { curPosition ->
                for (row in 'a'..'h') {
                    for (column in '1'..'8') {
                        if (!isInvalid(curPosition, "$row$column")) {
                            return false
                        }
                    }
                }
            }
            println("Stalemate!\nBye!")
            return true
        }

        fun isInvalid(curPos: String, newPos: String): Boolean {
            if (isWhite && curPos[1] != '2' && newPos[1] - curPos[1] == 2) {
                return true
            } else if (!isWhite && curPos[1] != '7' && curPos[1] - newPos[1] == 2) {
                return true
            } else if ((if (isWhite) newPos[1] - curPos[1] else curPos[1] - newPos[1]) !in 1..2) {
                return true
            } else if (oppositePawns().contains(newPos) && curPos[0] == newPos[0]) {
                return true
            } else if (newPos[0] - curPos[0] !in -1..1) {
                return true
            } else if (!oppositePawns().contains(newPos) && curPos[0] != newPos[0]) {
                return Storage.lastMoves.last() != "${newPos[0]}${newPos[1] + (if (isWhite) -1 else 1)}"
            }
            return false
        }
    }
}