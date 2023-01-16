package com.github.CB2222124.connect4.move;

import com.github.CB2222124.connect4.Board;
import com.github.CB2222124.connect4.BoardTestUtils;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class BombMoveValidationTest {

    @Test
    public void validMoveDoesNotThrow() {
        assertDoesNotThrow(() -> {
            Board board = new Board(6, 7);
            Move move = new BombMove(0);
            move.validateMove(board);
        });
    }

    @Test
    public void outOfLowerBoundThrows() {
        MoveException exception = assertThrows(MoveException.class, () -> {
            Board board = new Board(6, 7);
            Move move = new BombMove(-1);
            move.validateMove(board);
        });
        assertEquals("Column index out of bounds", exception.getMessage());
    }

    @Test
    public void outOfUpperBoundThrows() {
        MoveException exception = assertThrows(MoveException.class, () -> {
            Board board = new Board(6, 7);
            Move move = new BombMove(7);
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
            Move move = new BombMove(0);
            move.validateMove(board);
        });
        assertEquals("Column full", exception.getMessage());
    }
}
