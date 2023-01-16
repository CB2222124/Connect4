package com.github.CB2222124.connect4.move;

import com.github.CB2222124.connect4.Board;
import com.github.CB2222124.connect4.BoardTestUtils;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class BlitzMoveTest {

    private final BoardTestUtils boardTestUtils = new BoardTestUtils();

    @Test
    public void clearsFullColumn() throws MoveException {
        Board board = boardTestUtils.char2DArrayToBoard(new char[][]{
                {'X', '-', '-', '-', '-', '-'},
                {'O', '-', '-', '-', '-', '-'},
                {'X', '-', '-', '-', '-', '-'},
                {'O', '-', '-', '-', '-', '-'},
                {'X', '-', '-', '-', '-', '-'},
                {'O', '-', '-', '-', '-', '-'},
                {'X', '-', '-', '-', '-', '-'}
        });
        Move move = new BlitzMove(0);
        move.makeMove(board);
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
    public void clearsPartialColumn() throws MoveException {
        Board board = boardTestUtils.char2DArrayToBoard(new char[][]{
                {'-', '-', '-', '-', '-', '-'},
                {'-', '-', '-', '-', '-', '-'},
                {'-', '-', '-', '-', '-', '-'},
                {'O', '-', '-', '-', '-', '-'},
                {'X', '-', '-', '-', '-', '-'},
                {'O', '-', '-', '-', '-', '-'},
                {'X', '-', '-', '-', '-', '-'}
        });
        Move move = new BlitzMove(0);
        move.makeMove(board);
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
    public void handlesEmptyColumn() throws MoveException {
        Board board = boardTestUtils.char2DArrayToBoard(new char[][]{
                {'-', '-', '-', '-', '-', '-'},
                {'-', '-', '-', '-', '-', '-'},
                {'-', '-', '-', '-', '-', '-'},
                {'-', '-', '-', '-', '-', '-'},
                {'-', '-', '-', '-', '-', '-'},
                {'-', '-', '-', '-', '-', '-'},
                {'-', '-', '-', '-', '-', '-'}
        });
        Move move = new BlitzMove(0);
        move.makeMove(board);
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

}
