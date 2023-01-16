package com.github.CB2222124.connect4.token;

public enum TokenOwner {
    NONE("-"),
    NOUGHTS("O"),
    CROSSES("X");

    private final String string;

    TokenOwner(String string) {
        this.string = string;
    }

    @Override
    public String toString() {
        return string;
    }
}