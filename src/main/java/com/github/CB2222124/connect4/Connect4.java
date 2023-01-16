package com.github.CB2222124.connect4;

import com.github.CB2222124.connect4.move.MoveException;
import com.github.CB2222124.connect4.move.Move;
import com.github.CB2222124.connect4.player.Player;
import com.github.CB2222124.connect4.token.Token;
import com.github.CB2222124.connect4.view.Connect4View;

public class Connect4 {

    private final Board board;
    private final Player player1;
    private final Player player2;
    private final Connect4View view;

    /**
     * Instantiates a game of connect4.
     *
     * @param rows    The number of rows.
     * @param columns The number of columns.
     * @param player1 Player 1.
     * @param player2 Player 2.
     * @param view    The view used to display game events.
     */
    public Connect4(int rows, int columns, Player player1, Player player2, Connect4View view) {
        this.board = new Board(rows, columns);
        this.player1 = player1;
        this.player2 = player2;
        this.view = view;
        play();
    }

    /**
     * Handles a turn for each player until a game completion event is reached (Winner or full board).
     */
    private void play() {
        while (!board.isFull()) { //TODO: In our modified version of connect4, we should check if the current player can free spaces in the board with a move.
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

    /**
     * Handles a turn for the specified player.
     *
     * @param player The player.
     * @return True if the player wins on this turn, false otherwise.
     */
    private boolean handleTurn(Player player) {
        updateTokens();
        view.showBoard(board);
        handleMove(player);
        return board.isWinningPosition(player.getToken());
    }

    /**
     * Handles a move for the specified player. The player is recursively asked to provide a valid move,
     * the board is then updated.
     *
     * @param player The player.
     */
    private void handleMove(Player player) {
        try {
            Move move = player.getMove(board);
            move.makeMove(board);
        } catch (MoveException ex) {
            view.showInvalidMove();
            handleMove(player);
        }
    }

    @SuppressWarnings("ForLoopReplaceableByForEach")
    private void updateTokens() {
        Token[][] tokens = board.getBoard();
        for (int row = 0; row < tokens.length; row++) {
            for (int column = 0; column < tokens[0].length; column++) {
                tokens[row][column].update();
            }
        }
    }
}