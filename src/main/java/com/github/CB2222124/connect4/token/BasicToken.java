package com.github.CB2222124.connect4.token;

import com.github.CB2222124.connect4.Board;

public record BasicToken(TokenOwner owner) implements Token {

    @Override
    public void update(Board board) {

    }

    @Override
    public void position(int row, int column) {

    }
}
