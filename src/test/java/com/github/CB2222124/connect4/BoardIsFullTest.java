package com.github.CB2222124.connect4;

import com.github.CB2222124.connect4.token.BasicToken;
import com.github.CB2222124.connect4.token.TokenOwner;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class BoardIsFullTest {

    BoardTestUtils boardTestUtils = new BoardTestUtils();

    @Test
    public void emptyReturnsFalse() {
        Board board = new Board(3, 3);
        assertFalse(board.isFull());
    }

    @Test
    public void fullReturnsTrue() {
        Board board = new Board(3, 3);
        boardTestUtils.fillBoardWithToken(board, new BasicToken(TokenOwner.NOUGHTS));
        assertTrue(board.isFull());
    }

    @Test
    public void firstColumnEmptyReturnsFalse() {
        Board board = new Board(3, 3);
        boardTestUtils.fillBoardWithToken(board, new BasicToken(TokenOwner.NOUGHTS));
        boardTestUtils.fillColumnWithToken(board, 0, new BasicToken(TokenOwner.NONE));
        assertFalse(board.isFull());
    }

    @Test
    public void lastColumnEmptyReturnsFalse() {
        Board board = new Board(3, 3);
        boardTestUtils.fillBoardWithToken(board, new BasicToken(TokenOwner.NOUGHTS));
        boardTestUtils.fillColumnWithToken(board, 2, new BasicToken(TokenOwner.NONE));
        assertFalse(board.isFull());
    }

    @Test
    public void firstColumnOneSpaceReturnsFalse() {
        Board board = boardTestUtils.char2DArrayToBoard(new char[][]{
                {'-', 'X', 'X'},
                {'X', 'X', 'X'},
                {'X', 'X', 'X'}
        });
        assertFalse(board.isFull());
    }
}
