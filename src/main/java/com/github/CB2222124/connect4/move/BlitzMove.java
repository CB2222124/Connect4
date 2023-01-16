package com.github.CB2222124.connect4.move;

import com.github.CB2222124.connect4.Board;

public class BlitzMove implements Move{
    @Override
    public void makeMove(Board board) {

    }
}

/*
Replaces all tokens within the specified column with the empty token.
@param column The column to blitz.
public void makeBlitz(int column) throws IllegalMoveException {
validateMove(column);
for (int row = 0; row < board.length; row++) {
board[row][column] = new BasicToken(TokenOwner.NONE);
}
}
 */
