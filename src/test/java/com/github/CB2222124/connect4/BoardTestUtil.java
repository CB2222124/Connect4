package com.github.CB2222124.connect4;

import com.github.CB2222124.connect4.token.BasicToken;
import com.github.CB2222124.connect4.token.BombToken;
import com.github.CB2222124.connect4.token.Token;
import com.github.CB2222124.connect4.token.TokenOwner;

public class BoardTestUtil {

    public void fillBoardWithToken(Board board, Token token) {
        for (int row = 0; row < board.getBoard().length; row++) {
            for (int column = 0; column < board.getBoard()[0].length; column++) {
                board.getBoard()[row][column] = token;
            }
        }
    }

    public void fillColumnWithToken(Board board, int column, Token token) {
        for (int row = 0; row < board.getBoard().length; row++) {
            board.getBoard()[row][column] = token;
        }
    }

    public Board char2DArrayToBoard(char[][] characters) {
        Board board = new Board(characters.length, characters[0].length);
        for (int row = 0; row < characters.length; row++) {
            for (int column = 0; column < characters[0].length; column++) {
                if (characters[row][column] == 'X') {
                    board.getBoard()[row][column] = new BasicToken(TokenOwner.CROSSES);
                } else if (characters[row][column] == 'O') {
                    board.getBoard()[row][column] = new BasicToken(TokenOwner.NOUGHTS);
                } else if (characters[row][column] == '*') {
                    board.getBoard()[row][column] = new BombToken(row, column, 4);
                } else {
                    board.getBoard()[row][column] = new BasicToken(TokenOwner.NONE);
                }
            }
        }
        return board;
    }
}
