package chess
import chess.EndGameLogic.Companion.isGameContinue
import chess.Storage.Companion.curPawnName
import chess.Storage.Companion.currentPawns
import chess.Storage.Companion.isWhite
import chess.Storage.Companion.lastMoves
import chess.Storage.Companion.secondPlayer
import chess.EndGameLogic.Companion.isInvalid
import chess.Storage.Companion.oppositePawns

fun getPlayersTurn() {
    getChessBoard()
    do {
        println((if (isWhite) Storage.firstPlayer else secondPlayer) + "'s turn:")
        val input = readLine()!!
        if (input != "exit" && (input.isEmpty() || !input.matches("[a-h][1-8][a-h][1-8]".toRegex()))) {
            println("Invalid Input")
        }
        val curPosition = input.substring(0, 2)
        val newPosition = input.substring(2, 4)

        if (input == "exit") {
            println("Bye!")
            break
        } else if (!currentPawns().contains(curPosition)) {
            println("No ${curPawnName()} pawn at $curPosition")
        } else if (isInvalid(curPosition, newPosition)) {
            println("Invalid Input")
        } else {
            if (oppositePawns().contains(newPosition)) {
                oppositePawns().remove(newPosition)
            }
            oppositePawns().remove("${newPosition[0]}${newPosition[1] + (if (isWhite) -1 else 1)}")
            currentPawns().forEachIndexed { index, it -> if (it == curPosition) {
                currentPawns()[index] = newPosition
            }}
            lastMoves.add(newPosition)
            getChessBoard()
        }
    } while (isGameContinue())
}