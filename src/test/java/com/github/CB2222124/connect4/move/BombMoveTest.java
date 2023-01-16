package com.github.CB2222124.connect4.move;

import com.github.CB2222124.connect4.Board;
import com.github.CB2222124.connect4.BoardTestUtils;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class BombMoveTest {

    private final BoardTestUtils boardTestUtils = new BoardTestUtils();

    @Test
    public void insertsIntoEmptyColumn() throws MoveException {
        Board board = boardTestUtils.char2DArrayToBoard(new char[][]{
                {'-', '-', '-', '-', '-', '-'},
                {'-', '-', '-', '-', '-', '-'},
                {'-', '-', '-', '-', '-', '-'},
                {'-', '-', '-', '-', '-', '-'},
                {'-', '-', '-', '-', '-', '-'},
                {'-', '-', '-', '-', '-', '-'},
                {'-', '-', '-', '-', '-', '-'}
        });
        Move move = new BombMove(0);
        move.makeMove(board);
        assertTrue(boardTestUtils.assertBoardsEqual(boardTestUtils.char2DArrayToBoard(new char[][]{
                {'-', '-', '-', '-', '-', '-'},
                {'-', '-', '-', '-', '-', '-'},
                {'-', '-', '-', '-', '-', '-'},
                {'-', '-', '-', '-', '-', '-'},
                {'-', '-', '-', '-', '-', '-'},
                {'-', '-', '-', '-', '-', '-'},
                {'*', '-', '-', '-', '-', '-'}
        }), board));
    }

    @Test
    public void insertsIntoPartialColumn() throws MoveException {
        Board board = boardTestUtils.char2DArrayToBoard(new char[][]{
                {'-', '-', '-', '-', '-', '-'},
                {'-', '-', '-', '-', '-', '-'},
                {'-', '-', '-', '-', '-', '-'},
                {'-', '-', '-', '-', '-', '-'},
                {'O', '-', '-', '-', '-', '-'},
                {'X', '-', '-', '-', '-', '-'},
                {'X', '-', '-', '-', '-', '-'}
        });
        Move move = new BombMove(0);
        move.makeMove(board);
        assertTrue(boardTestUtils.assertBoardsEqual(boardTestUtils.char2DArrayToBoard(new char[][]{
                {'-', '-', '-', '-', '-', '-'},
                {'-', '-', '-', '-', '-', '-'},
                {'-', '-', '-', '-', '-', '-'},
                {'*', '-', '-', '-', '-', '-'},
                {'O', '-', '-', '-', '-', '-'},
                {'X', '-', '-', '-', '-', '-'},
                {'X', '-', '-', '-', '-', '-'}
        }), board));
    }
}
