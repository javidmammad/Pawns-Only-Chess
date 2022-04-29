package chess

import chess.Storage.Companion.pawns

fun getChessBoard() {
    for (row in 17 downTo  1) {
        print(if (row % 2 == 0) "${row / 2} " else "  ")
        for (column in 'a'..'h') {
            if (row % 2 == 0) {
                if (pawns[0].contains("${column}${row / 2}")) {
                    print("| W ")
                } else if (pawns[1].contains("${column}${row / 2}")) {
                    print("| B ")
                } else {
                    print("|   ")
                }
            } else {
                print("+---")
            }
        }
        print(if (row % 2 == 0) "|" else "+")
        println()
    }
    print("  ")
    for (letter in 'a'..'h') {
        print("  $letter ")
    }
    println()
}