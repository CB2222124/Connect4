package com.github.CB2222124.connect4.token;

import com.github.CB2222124.connect4.Board;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class BombTokenNeighbourTest {

    private final Board board = new Board(3, 3);

    @Test
    public void eightNeighboursWhenInMiddle() {
        BombToken bombToken = new BombToken(1, 1, 0);
        assertEquals(8, bombToken.getNeighbouringTokens(board).size());
    }

    @Test
    public void fiveNeighboursWhenTopMiddle() {
        BombToken bombToken = new BombToken(0, 1, 0);
        assertEquals(5, bombToken.getNeighbouringTokens(board).size());
    }

    @Test
    public void fiveNeighboursWhenMiddleLeft() {
        BombToken bombToken = new BombToken(1, 0, 0);
        assertEquals(5, bombToken.getNeighbouringTokens(board).size());
    }

    @Test
    public void fiveNeighboursWhenMiddleRight() {
        BombToken bombToken = new BombToken(1, 2, 0);
        assertEquals(5, bombToken.getNeighbouringTokens(board).size());
    }

    @Test
    public void threeNeighboursWhenTopLeft() {
        BombToken bombToken = new BombToken(0, 0, 0);
        assertEquals(3, bombToken.getNeighbouringTokens(board).size());
    }

    @Test
    public void threeNeighboursWhenTopRight() {
        BombToken bombToken = new BombToken(0, 2, 0);
        assertEquals(3, bombToken.getNeighbouringTokens(board).size());
    }

    @Test
    public void threeNeighboursWhenBottomLeft() {
        BombToken bombToken = new BombToken(2, 0, 0);
        assertEquals(3, bombToken.getNeighbouringTokens(board).size());
    }

    @Test
    public void threeNeighboursWhenBottomRight() {
        BombToken bombToken = new BombToken(2, 2, 0);
        assertEquals(3, bombToken.getNeighbouringTokens(board).size());
    }
}
