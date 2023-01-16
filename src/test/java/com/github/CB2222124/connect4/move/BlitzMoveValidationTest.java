package com.github.CB2222124.connect4.move;

import com.github.CB2222124.connect4.Board;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class BlitzMoveValidationTest {

    @Test
    public void validMoveDoesNotThrow() {
        assertDoesNotThrow(() -> {
            Board board = new Board(6, 7);
            Move move = new BlitzMove(0);
            move.validateMove(board);
        });
    }

    @Test
    public void outOfLowerBoundThrows() {
        MoveException exception = assertThrows(MoveException.class, () -> {
            Board board = new Board(6, 7);
            Move move = new BlitzMove(-1);
            move.validateMove(board);
        });
        assertEquals("Column index out of bounds", exception.getMessage());
    }

    @Test
    public void outOfUpperBoundThrows() {
        MoveException exception = assertThrows(MoveException.class, () -> {
            Board board = new Board(6, 7);
            Move move = new BlitzMove(7);
            move.validateMove(board);
        });
        assertEquals("Column index out of bounds", exception.getMessage());
    }
}
