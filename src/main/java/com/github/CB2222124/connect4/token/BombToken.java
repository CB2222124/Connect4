package com.github.CB2222124.connect4.token;

import com.github.CB2222124.connect4.Board;

import java.util.ArrayList;

public class BombToken implements Token {

    private int row;
    private int column;

    private final int movesUntilExplosion;
    private int movesSinceAdded;

    /**
     * Time bomb that will explode itself and adjacent neighbours after the specified number of moves have passed.
     *
     * @param row                 The current row this token is in.
     * @param column              The current column this token is in.
     * @param movesUntilExplosion The number of moves until this token should explode.
     */
    public BombToken(int row, int column, int movesUntilExplosion) {
        this.row = row;
        this.column = column;
        this.movesUntilExplosion = movesUntilExplosion;
    }

    @Override
    public void update(Board board) {
        if (++movesSinceAdded >= movesUntilExplosion) {
            explode(board);
            dropFloatingTokens(board);
        }
    }

    @Override
    public void position(int row, int column) {
        this.row = row;
        this.column = column;
    }

    @Override
    public TokenOwner owner() {
        return TokenOwner.BOMB;
    }

    public void explode(Board board) {
        ArrayList<RowColumnPair> neighbours = getNeighbouringTokens(board);
        for (RowColumnPair neighbour : neighbours) {
            board.getBoard()[neighbour.row()][neighbour.column()] = new BasicToken(TokenOwner.NONE);
        }
        board.getBoard()[row][column] = new BasicToken(TokenOwner.NONE);
    }

    /**
     * Moves all non-empty tokens downwards on the board, simulating gravity.
     *
     * @param board The board to operate on.
     */
    void dropFloatingTokens(Board board) {
        for (int column = 0; column < board.getBoard()[0].length; column++) {
            int start = 0;
            for (int row = 1; row < board.getBoard().length; row++) {
                if (board.getBoard()[row][column].owner() == TokenOwner.NONE) {
                    for (int i = row; i > start; i--) {
                        board.getBoard()[i][column] = board.getBoard()[i - 1][column];
                        board.getBoard()[i][column].position(i, column);
                        board.getBoard()[i - 1][column] = new BasicToken(TokenOwner.NONE);
                    }
                    start++;
                }
            }
        }
    }

    /**
     * Retrieves all adjacent neighbours that are not out of bounds.
     *
     * @param board The board to evaluate.
     * @return A list containing the row/column index as a pair.
     */
    ArrayList<RowColumnPair> getNeighbouringTokens(Board board) {
        ArrayList<RowColumnPair> neighbours = new ArrayList<>();
        for (int i = -1; i <= 1; i++) {
            for (int j = -1; j <= 1; j++) {
                if (i == 0 && j == 0) continue;
                int row = this.row + i;
                int column = this.column + j;
                if (row >= 0 && row < board.getBoard().length &&
                    column >= 0 && column < board.getBoard()[0].length) {
                    neighbours.add(new RowColumnPair(row, column));
                }
            }
        }
        return neighbours;
    }
}

record RowColumnPair(int row, int column) {
}