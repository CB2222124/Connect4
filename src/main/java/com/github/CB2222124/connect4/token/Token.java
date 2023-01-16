package com.github.CB2222124.connect4.token;

import com.github.CB2222124.connect4.Board;

public interface Token {
    void update(Board board);

    void position(int row, int column);

    TokenOwner owner();
}
