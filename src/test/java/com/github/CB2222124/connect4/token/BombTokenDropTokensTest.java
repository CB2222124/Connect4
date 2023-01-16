package com.github.CB2222124.connect4.token;

import com.github.CB2222124.connect4.Board;
import com.github.CB2222124.connect4.BoardTestUtils;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class BombTokenDropTokensTest {

    private final BoardTestUtils boardTestUtils = new BoardTestUtils();

    @Test
    public void dropSingleToken() {
        Board board = boardTestUtils.char2DArrayToBoard(new char[][]{
                {'X', '-', '-', '-', '-', '-'},
                {'-', '-', '-', '-', '-', '-'},
                {'-', '-', '-', '-', '-', '-'},
                {'-', '-', '-', '-', '-', '-'},
                {'-', '-', '-', '-', '-', '-'},
                {'-', '-', '-', '-', '-', '-'},
                {'-', '-', '-', '-', '-', '-'}
        });
        BombToken token = new BombToken(-1, -1, -1);
        token.dropFloatingTokens(board);
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
    public void dropMultipleTokens() {
        Board board = boardTestUtils.char2DArrayToBoard(new char[][]{
                {'X', '-', '-', '-', '-', '-'},
                {'X', '-', '-', '-', '-', '-'},
                {'O', '-', '-', '-', '-', '-'},
                {'-', '-', '-', '-', '-', '-'},
                {'-', '-', '-', '-', '-', '-'},
                {'-', '-', '-', '-', '-', '-'},
                {'-', '-', '-', '-', '-', '-'}
        });
        BombToken token = new BombToken(-1, -1, -1);
        token.dropFloatingTokens(board);
        assertTrue(boardTestUtils.assertBoardsEqual(boardTestUtils.char2DArrayToBoard(new char[][]{
                {'-', '-', '-', '-', '-', '-'},
                {'-', '-', '-', '-', '-', '-'},
                {'-', '-', '-', '-', '-', '-'},
                {'-', '-', '-', '-', '-', '-'},
                {'X', '-', '-', '-', '-', '-'},
                {'X', '-', '-', '-', '-', '-'},
                {'O', '-', '-', '-', '-', '-'}
        }), board));
    }

    @Test
    public void dropSplitTokens() {
        Board board = boardTestUtils.char2DArrayToBoard(new char[][]{
                {'X', '-', '-', '-', '-', '-'},
                {'X', '-', '-', '-', '-', '-'},
                {'-', '-', '-', '-', '-', '-'},
                {'X', '-', '-', '-', '-', '-'},
                {'-', '-', '-', '-', '-', '-'},
                {'O', '-', '-', '-', '-', '-'},
                {'-', '-', '-', '-', '-', '-'}
        });
        BombToken token = new BombToken(-1, -1, -1);
        token.dropFloatingTokens(board);
        assertTrue(boardTestUtils.assertBoardsEqual(boardTestUtils.char2DArrayToBoard(new char[][]{
                {'-', '-', '-', '-', '-', '-'},
                {'-', '-', '-', '-', '-', '-'},
                {'-', '-', '-', '-', '-', '-'},
                {'X', '-', '-', '-', '-', '-'},
                {'X', '-', '-', '-', '-', '-'},
                {'X', '-', '-', '-', '-', '-'},
                {'O', '-', '-', '-', '-', '-'}
        }), board));
    }

    @Test
    public void dropMultipleSplitTokens() {
        Board board = boardTestUtils.char2DArrayToBoard(new char[][]{
                {'X', '-', 'O', '-', '-', '-'},
                {'X', '-', '-', '-', 'O', '-'},
                {'-', '-', 'X', '-', '-', '-'},
                {'X', '-', '-', '-', '-', '-'},
                {'-', '-', '-', '-', 'X', '-'},
                {'O', '-', '-', '-', 'X', '-'},
                {'-', '-', '-', '-', '-', '-'}
        });
        BombToken token = new BombToken(-1, -1, -1);
        token.dropFloatingTokens(board);
        assertTrue(boardTestUtils.assertBoardsEqual(boardTestUtils.char2DArrayToBoard(new char[][]{
                {'-', '-', '-', '-', '-', '-'},
                {'-', '-', '-', '-', '-', '-'},
                {'-', '-', '-', '-', '-', '-'},
                {'X', '-', '-', '-', '-', '-'},
                {'X', '-', '-', '-', 'O', '-'},
                {'X', '-', 'O', '-', 'X', '-'},
                {'O', '-', 'X', '-', 'X', '-'}
        }), board));
    }
}
