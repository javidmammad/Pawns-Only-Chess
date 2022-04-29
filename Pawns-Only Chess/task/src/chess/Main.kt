package chess

import chess.Storage.Companion.firstPlayer
import chess.Storage.Companion.secondPlayer

fun main() {
    println("Pawns-Only Chess")
    println("First Player's name:")
    firstPlayer = readLine()!!
    println("Second Player's name:")
    secondPlayer = readLine()!!
    getPlayersTurn()
}