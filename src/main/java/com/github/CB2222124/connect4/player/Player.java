package com.github.CB2222124.connect4.player;

import com.github.CB2222124.connect4.Board;
import com.github.CB2222124.connect4.Token;

public abstract class Player {

    private final Token token;
    private final String name;

    public Player(Token token, String name) {
        this.token = token;
        this.name = name;
    }

    public Token getToken() {
        return token;
    }

    public String getName() {
        return name;
    }

    public abstract int getMove(Board board);
}
