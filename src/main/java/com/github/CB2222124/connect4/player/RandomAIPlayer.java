package com.github.CB2222124.connect4.player;

import com.github.CB2222124.connect4.Board;
import com.github.CB2222124.connect4.token.TokenOwner;

import java.util.ArrayList;
import java.util.Random;


public class RandomAIPlayer extends Player {

    private final Random random;

    public RandomAIPlayer(TokenOwner token, String name) {
        super(token, name);
        random = new Random();
    }

    /**
     * Selects a completely random move.
     *
     * @param board The board to evaluate.
     * @return random valid column index.
     */
    @Override
    public int getMove(Board board) {
        ArrayList<Integer> validColumns = new ArrayList<>();
        for (int column = 0; column < board.getBoard()[0].length; column++)
            if (board.getBoard()[0][column].owner() == TokenOwner.NONE) validColumns.add(column);
        return validColumns.get(random.nextInt(validColumns.size()));
    }
}
