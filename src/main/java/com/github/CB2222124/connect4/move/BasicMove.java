package com.github.CB2222124.connect4.move;

import com.github.CB2222124.connect4.Board;
import com.github.CB2222124.connect4.token.BasicToken;
import com.github.CB2222124.connect4.token.TokenOwner;

public class BasicMove implements Move {

    private final int column;
    private final TokenOwner owner;

    /**
     * Inserts a token into the specified column.
     *
     * @param column The column to insert into.
     * @param owner  The owner of the token to insert.
     */
    public BasicMove(int column, TokenOwner owner) {
        this.column = column;
        this.owner = owner;
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
                board.getBoard()[row][column] = new BasicToken(owner);
                break;
            }
        }
    }
}
