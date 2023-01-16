package com.github.CB2222124.connect4.token;

import com.github.CB2222124.connect4.Board;
import com.github.CB2222124.connect4.BoardTestUtils;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class BombTokenExplodeTest {

    private final BoardTestUtils boardTestUtils = new BoardTestUtils();

    @Test
    public void explodeInMiddleRemovesAllNeighbours() {
        Board board = boardTestUtils.char2DArrayToBoard(new char[][]{
                {'-', '-', '-', '-', '-', '-'},
                {'-', '-', '-', '-', '-', '-'},
                {'-', '-', '-', '-', '-', '-'},
                {'-', '-', '-', '-', '-', '-'},
                {'O', 'O', 'X', '-', '-', '-'},
                {'X', '*', 'O', '-', '-', '-'},
                {'X', 'X', 'O', '-', '-', '-'}
        });
        BombToken token = new BombToken(5, 1, 0);
        token.explode(board);
        assertTrue(boardTestUtils.assertBoardsEqual(boardTestUtils.char2DArrayToBoard(new char[][]{
                {'-', '-', '-', '-', '-', '-'},
                {'-', '-', '-', '-', '-', '-'},
                {'-', '-', '-', '-', '-', '-'},
                {'-', '-', '-', '-', '-', '-'},
                {'-', '-', '-', '-', '-', '-'},
                {'-', '-', '-', '-', '-', '-'},
                {'-', '-', '-', '-', '-', '-'}
        }), board));
    }

    @Test
    public void explodeOnLeftRemovesRightNeighbours() {
        Board board = boardTestUtils.char2DArrayToBoard(new char[][]{
                {'-', '-', '-', '-', '-', '-'},
                {'-', '-', '-', '-', '-', '-'},
                {'-', '-', '-', '-', '-', '-'},
                {'-', '-', '-', '-', '-', '-'},
                {'O', 'O', 'X', '-', '-', '-'},
                {'*', 'X', 'O', '-', '-', '-'},
                {'X', 'X', 'O', '-', '-', '-'}
        });
        BombToken token = new BombToken(5, 0, 0);
        token.explode(board);
        assertTrue(boardTestUtils.assertBoardsEqual(boardTestUtils.char2DArrayToBoard(new char[][]{
                {'-', '-', '-', '-', '-', '-'},
                {'-', '-', '-', '-', '-', '-'},
                {'-', '-', '-', '-', '-', '-'},
                {'-', '-', '-', '-', '-', '-'},
                {'-', '-', 'X', '-', '-', '-'},
                {'-', '-', 'O', '-', '-', '-'},
                {'-', '-', 'O', '-', '-', '-'}
        }), board));
    }

    @Test
    public void explodeOnRightRemovesLeftNeighbours() {
        Board board = boardTestUtils.char2DArrayToBoard(new char[][]{
                {'-', '-', '-', '-', '-', '-'},
                {'-', '-', '-', '-', '-', '-'},
                {'-', '-', '-', '-', '-', '-'},
                {'-', '-', '-', '-', '-', '-'},
                {'-', '-', '-', 'O', 'O', 'X'},
                {'-', '-', '-', 'X', 'X', '*'},
                {'-', '-', '-', 'X', 'X', 'O'}
        });
        BombToken token = new BombToken(5, 5, 0);
        token.explode(board);
        assertTrue(boardTestUtils.assertBoardsEqual(boardTestUtils.char2DArrayToBoard(new char[][]{
                {'-', '-', '-', '-', '-', '-'},
                {'-', '-', '-', '-', '-', '-'},
                {'-', '-', '-', '-', '-', '-'},
                {'-', '-', '-', '-', '-', '-'},
                {'-', '-', '-', 'O', '-', '-'},
                {'-', '-', '-', 'X', '-', '-'},
                {'-', '-', '-', 'X', '-', '-'}
        }), board));
    }

    @Test
    public void explodeOnBottomLeftRemovesTopRightNeighbours() {
        Board board = boardTestUtils.char2DArrayToBoard(new char[][]{
                {'-', '-', '-', '-', '-', '-'},
                {'-', '-', '-', '-', '-', '-'},
                {'-', '-', '-', '-', '-', '-'},
                {'-', '-', '-', '-', '-', '-'},
                {'O', 'O', 'X', '-', '-', '-'},
                {'X', 'X', 'O', '-', '-', '-'},
                {'*', 'X', 'O', '-', '-', '-'}
        });
        BombToken token = new BombToken(6, 0, 0);
        token.explode(board);
        assertTrue(boardTestUtils.assertBoardsEqual(boardTestUtils.char2DArrayToBoard(new char[][]{
                {'-', '-', '-', '-', '-', '-'},
                {'-', '-', '-', '-', '-', '-'},
                {'-', '-', '-', '-', '-', '-'},
                {'-', '-', '-', '-', '-', '-'},
                {'O', 'O', 'X', '-', '-', '-'},
                {'-', '-', 'O', '-', '-', '-'},
                {'-', '-', 'O', '-', '-', '-'}
        }), board));
    }
}
