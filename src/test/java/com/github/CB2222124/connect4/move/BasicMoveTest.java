package com.github.CB2222124.connect4.move;

import com.github.CB2222124.connect4.Board;
import com.github.CB2222124.connect4.BoardTestUtils;
import com.github.CB2222124.connect4.token.TokenOwner;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class BasicMoveTest {

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
        Move move = new BasicMove(0, TokenOwner.CROSSES);
        move.makeMove(board);
        assertTrue(boardTestUtils.assertBoardsEqual(boardTestUtils.char2DArrayToBoard(new char[][]{
                {'-', '-', '-', '-', '-', '-'},
                {'-', '-', '-', '-', '-', '-'},
                {'-', '-', '-', '-', '-', '-'},
                {'-', '-', '-', '-', '-', '-'},
                {'-', '-', '-', '-', '-', '-'},
                {'-', '-', '-', '-', '-', '-'},
                {'X', '-', '-', '-', '-', '-'}
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
        Move move = new BasicMove(0, TokenOwner.CROSSES);
        move.makeMove(board);
        assertTrue(boardTestUtils.assertBoardsEqual(boardTestUtils.char2DArrayToBoard(new char[][]{
                {'-', '-', '-', '-', '-', '-'},
                {'-', '-', '-', '-', '-', '-'},
                {'-', '-', '-', '-', '-', '-'},
                {'X', '-', '-', '-', '-', '-'},
                {'O', '-', '-', '-', '-', '-'},
                {'X', '-', '-', '-', '-', '-'},
                {'X', '-', '-', '-', '-', '-'}
        }), board));
    }
}
