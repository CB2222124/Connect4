package com.github.CB2222124.connect4.view;

import com.github.CB2222124.connect4.Board;
import com.github.CB2222124.connect4.player.Player;

/**
 * Standard output stream view for a connect4 game.
 */
public class ConsoleConnect4View implements Connect4View {

    @Override
    public void showBoard(Board board) {
        System.out.println(board);
    }

    @Override
    public void showWinner(Player player) {
        System.out.println("Winner: " + player.getName());
    }

    @Override
    public void showDraw() {
        System.out.println("Draw");
    }

    @Override
    public void showInvalidMove(String reason) {
        System.out.println("Invalid move, try again (" + reason + ")");
    }
}
