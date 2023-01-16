package com.github.CB2222124.connect4.player;

import com.github.CB2222124.connect4.Board;
import com.github.CB2222124.connect4.move.Move;
import com.github.CB2222124.connect4.token.TokenOwner;

public class MinimaxAIPlayer extends Player {

    public MinimaxAIPlayer(TokenOwner token, String name) {
        super(token, name);
    }

    @Override
    public Move getMove(Board board) {
        throw new UnsupportedOperationException("Not implemented yet");
    }
}
