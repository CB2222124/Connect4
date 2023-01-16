package com.github.CB2222124.connect4;

import com.github.CB2222124.connect4.player.Player;
import com.github.CB2222124.connect4.view.Connect4View;

public class Connect4 {

    private final Board board;
    private final Player player1;
    private final Player player2;
    private final Connect4View view;

    public Connect4(int rows, int columns, Player player1, Player player2, Connect4View view) {
        this.board = new Board(rows, columns);
        this.player1 = player1;
        this.player2 = player2;
        this.view = view;
        play();
    }

    private void play() {
        while (!board.isFull()) {
            if (handleTurn(player1)) {
                view.showWinner(player1);
                return;
            } else if (handleTurn(player2)) {
                view.showWinner(player2);
                return;
            }
        }
        view.showDraw();
    }

    private boolean handleTurn(Player player) {
        view.showBoard(board);
        handleMove(player);
        return board.isWinningPosition(player.getToken());
    }

    private void handleMove(Player player) {
        try {
            board.makeMove(player.getMove(board), player.getToken());
        } catch (IllegalMoveException ex) {
            view.showInvalidMove();
            handleMove(player);
        }
    }
}