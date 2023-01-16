package com.github.CB2222124.connect4.move;

import com.github.CB2222124.connect4.Board;
import com.github.CB2222124.connect4.token.BombToken;
import com.github.CB2222124.connect4.token.TokenOwner;

public class BombMove implements Move {

    private static final int MOVES_UNTIL_EXPLOSION = 4;

    private final int column;

    /**
     * Inserts a time bomb token in the specified column.
     *
     * @param column The column to insert into.
     */
    public BombMove(int column) {
        this.column = column;
    }

    @Override
    public void validateMove(Board board) throws MoveException {
        if (column < 0 || column >= board.getBoard()[0].length) throw new MoveException("Column index out of bounds");
        if (board.getBoard()[0][column].owner() != TokenOwner.NONE) throw new MoveException("Column full");
    }

    @Override
    public void makeMove(Board board) throws MoveException {
        validateMove(board);
        for (int row = board.getBoard().length - 1; row >= 0; row--) {
            if (board.getBoard()[row][column].owner() == TokenOwner.NONE) {
                board.getBoard()[row][column] = new BombToken(row, column, MOVES_UNTIL_EXPLOSION);
                break;
            }
        }
    }
}
