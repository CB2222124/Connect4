package com.github.CB2222124.connect4.move;

import com.github.CB2222124.connect4.Board;
import com.github.CB2222124.connect4.BoardTestUtils;
import com.github.CB2222124.connect4.token.TokenOwner;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class BasicMoveValidationTest {

    @Test
    public void validMoveDoesNotThrow() {
        assertDoesNotThrow(() -> {
            Board board = new Board(6, 7);
            Move move = new BasicMove(0, TokenOwner.NOUGHTS);
            move.validateMove(board);
        });
    }

    @Test
    public void outOfLowerBoundThrows() {
        MoveException exception = assertThrows(MoveException.class, () -> {
            Board board = new Board(6, 7);
            Move move = new BasicMove(-1, TokenOwner.NOUGHTS);
            move.validateMove(board);
        });
        assertEquals("Column index out of bounds", exception.getMessage());
    }

    @Test
    public void outOfUpperBoundThrows() {
        MoveException exception = assertThrows(MoveException.class, () -> {
            Board board = new Board(6, 7);
            Move move = new BasicMove(7, TokenOwner.NOUGHTS);
            move.validateMove(board);
        });
        assertEquals("Column index out of bounds", exception.getMessage());
    }

    @Test
    public void columnFullThrows() {
        MoveException exception = assertThrows(MoveException.class, () -> {
            BoardTestUtils boardTestUtils = new BoardTestUtils();
            Board board = boardTestUtils.char2DArrayToBoard(new char[][]{
                    {'X', '-', '-'},
                    {'O', '-', '-'},
                    {'X', '-', '-'}
            });
            Move move = new BasicMove(0, TokenOwner.NOUGHTS);
            move.validateMove(board);
        });
        assertEquals("Column full", exception.getMessage());
    }
}
