package com.github.CB2222124.connect4.player;

import com.github.CB2222124.connect4.Board;
import com.github.CB2222124.connect4.token.TokenOwner;

public abstract class Player {

    private final TokenOwner token;
    private final String name;

    public Player(TokenOwner token, String name) {
        this.token = token;
        this.name = name;
    }

    public TokenOwner getToken() {
        return token;
    }

    public String getName() {
        return name;
    }

    public abstract int getMove(Board board);
}
