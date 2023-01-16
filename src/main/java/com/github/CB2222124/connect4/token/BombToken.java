package com.github.CB2222124.connect4.token;

public class BombToken implements Token {
    @Override
    public void update() {
        //Some stuff
    }

    @Override
    public TokenOwner owner() {
        return TokenOwner.NONE;
    }
}
