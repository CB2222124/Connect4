package com.github.CB2222124.connect4;

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
                board[row][column] = Token.EMPTY;
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
            if (board[0][column] == Token.EMPTY) return false;
        }
        return true;
    }

    /**
     * Inserts a token into the specified column.
     *
     * @param column The column to insert into.
     * @param token  The token to insert.
     */
    public void makeMove(int column, Token token) throws IllegalMoveException {
        validateMove(column);
        //Occupy the first available row from the end of the specified column.
        for (int row = board.length - 1; row >= 0; row--) {
            if (board[row][column] == Token.EMPTY) {
                board[row][column] = token;
                break;
            }
        }
    }

    /**
     * Replaces all tokens within the specified column with the empty token.
     *
     * @param column The column to blitz.
     */
    public void makeBlitz(int column) throws IllegalMoveException {
        validateMove(column);
        for (int row = 0; row < board.length; row++) {
            board[row][column] = Token.EMPTY;
        }
    }

    /**
     * Validates a standard column insert move.
     *
     * @param column The column to validate
     * @throws IllegalMoveException Where column index is out of bounds or full.
     */
    public void validateMove(int column) throws IllegalMoveException {
        if (column < 0 || column > board[0].length) throw new IllegalMoveException("Column index out of bounds");
        if (board[0][column] != Token.EMPTY) throw new IllegalMoveException("Column full");
    }

    /**
     * Evaluates this board for a winning position for a given token.
     * A winning position is defined as a continuous horizontal, vertical, or diagonal
     * line of four with the given token.
     *
     * @param token The token to evaluate for.
     * @return True if there is a winning position for the given token, false otherwise.
     */
    public boolean isWinningPosition(Token token) {
        //Horizontal evaluation.
        for (int row = 0; row < board.length; row++) {
            for (int column = 0; column < board[0].length - 3; column++) {
                if (board[row][column] == token &&
                    board[row][column + 1] == token &&
                    board[row][column + 2] == token &&
                    board[row][column + 3] == token) {
                    return true;
                }
            }
        }
        //Vertical evaluation.
        for (int row = 0; row < board.length - 3; row++) {
            for (int column = 0; column < board[0].length; column++) {
                if (board[row][column] == token &&
                    board[row + 1][column] == token &&
                    board[row + 2][column] == token &&
                    board[row + 3][column] == token) {
                    return true;
                }
            }
        }
        //Negative diagonal evaluation.
        for (int row = 3; row < board.length; row++) {
            for (int column = 0; column < board[0].length - 3; column++) {
                if (board[row][column] == token &&
                    board[row - 1][column + 1] == token &&
                    board[row - 2][column + 2] == token &&
                    board[row - 3][column + 3] == token) {
                    return true;
                }
            }
        }
        //Positive diagonal evaluation.
        for (int row = 0; row < board.length - 3; row++) {
            for (int column = 0; column < board[0].length - 3; column++) {
                if (board[row][column] == token &&
                    board[row + 1][column + 1] == token &&
                    board[row + 2][column + 2] == token &&
                    board[row + 3][column + 3] == token) {
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
                sb.append(board[row][column]).append(" ");
            }
            sb.append(System.getProperty("line.separator"));
        }
        return sb.toString();
    }
}