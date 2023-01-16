package com.github.CB2222124.connect4;

import com.github.CB2222124.connect4.token.BasicToken;
import com.github.CB2222124.connect4.token.Token;
import com.github.CB2222124.connect4.token.TokenOwner;

@SuppressWarnings("ForLoopReplaceableByForEach")
public class Board {

    private final Token[][] board;

    /**
     * Instantiates a Connect 4 board.
     * A board is represented and handled as a square 2D array (grid) with top-left origin,
     * where row precedes column.
     *
     * @param rows    The number of rows.
     * @param columns The number of columns.
     */
    public Board(int rows, int columns) {
        if (rows < 1 || columns < 1) throw new IllegalArgumentException("There must be at least one row and column");
        board = new Token[rows][columns];
        instantiateBoard();
    }

    /**
     * Populates this board with empty tokens.
     */
    private void instantiateBoard() {
        for (int row = 0; row < board.length; row++) {
            for (int column = 0; column < board[0].length; column++) {
                board[row][column] = new BasicToken(TokenOwner.NONE);
            }
        }
    }

    /**
     * Checks if this board is full of non-empty tokens.
     *
     * @return True if this board is full, false otherwise.
     */
    public boolean isFull() {
        for (int column = 0; column < board[0].length; column++) {
            if (board[0][column].owner() == TokenOwner.NONE) return false;
        }
        return true;
    }

    /**
     * Evaluates this board for a winning position for a given token.
     * A winning position is defined as a continuous horizontal, vertical, or diagonal
     * line of four with the given token.
     *
     * @param token The token to evaluate for.
     * @return True if there is a winning position for the given token, false otherwise.
     */
    public boolean isWinningPosition(TokenOwner token) {
        //Horizontal evaluation.
        for (int row = 0; row < board.length; row++) {
            for (int column = 0; column < board[0].length - 3; column++) {
                if (board[row][column].owner() == token &&
                    board[row][column + 1].owner() == token &&
                    board[row][column + 2].owner() == token &&
                    board[row][column + 3].owner() == token) {
                    return true;
                }
            }
        }
        //Vertical evaluation.
        for (int row = 0; row < board.length - 3; row++) {
            for (int column = 0; column < board[0].length; column++) {
                if (board[row][column].owner() == token &&
                    board[row + 1][column].owner() == token &&
                    board[row + 2][column].owner() == token &&
                    board[row + 3][column].owner() == token) {
                    return true;
                }
            }
        }
        //Negative diagonal evaluation.
        for (int row = 3; row < board.length; row++) {
            for (int column = 0; column < board[0].length - 3; column++) {
                if (board[row][column].owner() == token &&
                    board[row - 1][column + 1].owner() == token &&
                    board[row - 2][column + 2].owner() == token &&
                    board[row - 3][column + 3].owner() == token) {
                    return true;
                }
            }
        }
        //Positive diagonal evaluation.
        for (int row = 0; row < board.length - 3; row++) {
            for (int column = 0; column < board[0].length - 3; column++) {
                if (board[row][column].owner() == token &&
                    board[row + 1][column + 1].owner() == token &&
                    board[row + 2][column + 2].owner() == token &&
                    board[row + 3][column + 3].owner() == token) {
                    return true;
                }
            }
        }
        return false;
    }

    /**
     * @return 2D array representation of board.
     */
    public Token[][] getBoard() {
        return board;
    }

    /**
     * Returns a string representation of this board. Each row occupies
     * a new line and each column is separated by whitespace.
     *
     * @return The string representation of this board.
     */
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (int row = 0; row < board.length; row++) {
            for (int column = 0; column < board[0].length; column++) {
                sb.append(board[row][column].owner()).append(" ");
            }
            sb.append(System.getProperty("line.separator"));
        }
        return sb.toString();
    }
}