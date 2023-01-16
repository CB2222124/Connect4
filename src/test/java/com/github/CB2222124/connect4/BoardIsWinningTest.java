package com.github.CB2222124.connect4;

import com.github.CB2222124.connect4.token.TokenOwner;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class BoardIsWinningTest {

    BoardTestUtils boardTestUtils = new BoardTestUtils();

    @Test
    public void horizontalWinningPositionReturnsTrue() {
        Board board = boardTestUtils.char2DArrayToBoard(new char[][]{
                {'-', '-', '-', '-', '-', '-'},
                {'-', '-', '-', '-', '-', '-'},
                {'-', '-', '-', '-', '-', '-'},
                {'-', '-', '-', '-', '-', '-'},
                {'-', '-', '-', '-', '-', '-'},
                {'-', '-', '-', '-', '-', '-'},
                {'-', 'X', 'X', 'X', 'X', '-'}
        });
        assertTrue(board.isWinningPosition(TokenOwner.CROSSES));
    }

    @Test
    public void verticalWinningPositionReturnsTrue() {
        Board board = boardTestUtils.char2DArrayToBoard(new char[][]{
                {'-', '-', '-', '-', '-', '-'},
                {'-', '-', '-', '-', '-', '-'},
                {'-', '-', '-', '-', '-', '-'},
                {'X', '-', '-', '-', '-', '-'},
                {'X', '-', '-', '-', '-', '-'},
                {'X', '-', '-', '-', '-', '-'},
                {'X', '-', '-', '-', '-', '-'}
        });
        assertTrue(board.isWinningPosition(TokenOwner.CROSSES));
    }

    @Test
    public void positiveDiagonalWinningPositionReturnsTrue() {
        Board board = boardTestUtils.char2DArrayToBoard(new char[][]{
                {'-', '-', '-', '-', '-', '-'},
                {'-', '-', '-', '-', '-', '-'},
                {'-', '-', '-', '-', '-', '-'},
                {'-', '-', '-', 'X', '-', '-'},
                {'-', '-', 'X', '-', '-', '-'},
                {'-', 'X', '-', '-', '-', '-'},
                {'X', '-', '-', '-', '-', '-'}
        });
        assertTrue(board.isWinningPosition(TokenOwner.CROSSES));
    }

    @Test
    public void negativeDiagonalWinningPositionReturnsTrue() {
        Board board = boardTestUtils.char2DArrayToBoard(new char[][]{
                {'-', '-', '-', '-', '-', '-'},
                {'-', '-', '-', '-', '-', '-'},
                {'-', '-', '-', '-', '-', '-'},
                {'-', '-', 'X', '-', '-', '-'},
                {'-', '-', '-', 'X', '-', '-'},
                {'-', '-', '-', '-', 'X', '-'},
                {'-', '-', '-', '-', '-', 'X'}
        });
        assertTrue(board.isWinningPosition(TokenOwner.CROSSES));
    }

    @Test
    public void noWinningPositionReturnsFalse() {
        Board board = boardTestUtils.char2DArrayToBoard(new char[][]{
                {'-', '-', '-', '-', '-', '-'},
                {'-', '-', '-', '-', '-', '-'},
                {'-', '-', '-', '-', '-', '-'},
                {'-', '-', '-', '-', '-', '-'},
                {'-', '-', '-', '-', '-', '-'},
                {'-', '-', '-', '-', '-', '-'},
                {'-', '-', '-', '-', '-', '-'}
        });
        assertFalse(board.isWinningPosition(TokenOwner.CROSSES));
    }

    @Test
    public void interruptedWinningPositionReturnsFalse() {
        Board board = boardTestUtils.char2DArrayToBoard(new char[][]{
                {'-', '-', '-', '-', '-', '-'},
                {'-', '-', '-', '-', '-', '-'},
                {'-', '-', '-', '-', '-', '-'},
                {'X', '-', '-', '-', '-', '-'},
                {'O', '-', '-', '-', '-', '-'},
                {'X', '-', '-', '-', '-', '-'},
                {'X', '-', '-', '-', '-', '-'}
        });
        assertFalse(board.isWinningPosition(TokenOwner.CROSSES));
    }
}
