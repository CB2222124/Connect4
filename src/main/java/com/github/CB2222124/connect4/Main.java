package com.github.CB2222124.connect4;

import com.github.CB2222124.connect4.player.AIPlayer;
import com.github.CB2222124.connect4.player.ConsolePlayer;
import com.github.CB2222124.connect4.player.Player;

public class Main {
    public static void main(String[] args) {
        Board board = new Board(6, 7);
        ConsolePlayer player1 = new ConsolePlayer('O', "Human");
        AIPlayer player2 = new AIPlayer('X', "Computer");
        while (true) {
            if (handleTurn(board, player1, player2) ||
                handleTurn(board, player2, player1))
                break;
        }
        System.out.println(board);
    }

    private static boolean handleTurn(Board board, Player player, Player opponent) {
        System.out.println(board);
        int move = getMove(board, player, opponent);
        board.makeMove(move, player.getToken());
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

    private static int getMove(Board board, Player player, Player opponent) {
        int move = player.getMove(board, opponent);
        if (board.validMove(move)) {
            return move;
        } else {
            return getMove(board, player, opponent);
        }
    }
}