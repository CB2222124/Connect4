package com.github.CB2222124.connect4.player;

import com.github.CB2222124.connect4.Board;

public abstract class Player {

    private final char token;
    private final String name;

    public Player(char token, String name) {
        this.token = token;
        this.name = name;
    }

    public char getToken() {
        return token;
    }

    public String getName() {
        return name;
    }

    public abstract int getMove(Board board, Player opponent);
}
