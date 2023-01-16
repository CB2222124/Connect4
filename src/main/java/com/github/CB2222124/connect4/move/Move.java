package com.github.CB2222124.connect4.move;

import com.github.CB2222124.connect4.Board;

public interface Move {
    void validateMove(Board board) throws MoveException;

    void makeMove(Board board) throws MoveException;
}
