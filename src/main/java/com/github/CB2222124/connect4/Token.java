package com.github.CB2222124.connect4;

public enum Token {

    EMPTY("-"),
    NOUGHTS("O"),
    CROSSES("X");

    private final String string;

    Token(String string) {
        this.string = string;
    }

    @Override
    public String toString() {
        return string;
    }
}