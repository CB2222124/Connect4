package com.github.CB2222124.connect4;

import com.github.CB2222124.connect4.player.ConsolePlayer;
import com.github.CB2222124.connect4.player.Player;

public class Main {
    public static void main(String[] args) {
        Board board = new Board(6, 7);
        ConsolePlayer player1 = new ConsolePlayer('O', "O");
        ConsolePlayer player2 = new ConsolePlayer('X', "X");
        while (true) {
            if (handleTurn(board, player1, player2) ||
                handleTurn(board, player2, player1))
                break;
        }
        System.out.println(board);
    }

    public static boolean handleTurn(Board board, Player player, Player opponent) {
        System.out.println(board);
        int move = player.getMove(board, opponent);
        if (board.validMove(move)) {
            board.makeMove(move, player.getToken());
        } else {
            System.out.println("Invalid move, turn forfeited");
        }
        if (board.isWinningPosition(player.getToken())) {
            System.out.println("Winner: " + player.getName());
            return true;
        } else if (board.isFull()) {
            System.out.println("Draw");
            return true;
        } else {
            return false;
        }
    }
}