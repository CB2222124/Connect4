package com.github.CB2222124.connect4.move;

import com.github.CB2222124.connect4.Board;
import com.github.CB2222124.connect4.token.BasicToken;
import com.github.CB2222124.connect4.token.TokenOwner;

public class BlitzMove implements Move {

    private final int column;

    /**
     * Replaces all tokens within the specified column with the empty token.
     *
     * @param column The column to blitz.
     */
    public BlitzMove(int column) {
        this.column = column;
    }

    @Override
    public void validateMove(Board board) throws MoveException {
        if (column < 0 || column >= board.getBoard()[0].length) throw new MoveException("Column index out of bounds");
    }

    @Override
    public void makeMove(Board board) throws MoveException {
        validateMove(board);
        for (int row = 0; row < board.getBoard().length; row++) {
            board.getBoard()[row][column] = new BasicToken(TokenOwner.NONE);
        }
    }
}