package com.github.CB2222124.connect4.player;

import com.github.CB2222124.connect4.Board;

import java.util.ArrayList;
import java.util.Random;


public class AIPlayer extends Player {

    private final Random random;

    public AIPlayer(char token, String name) {
        super(token, name);
        random = new Random();
    }

    @Override
    public int getMove(Board board, Player opponent) {
        ArrayList<Integer> validColumns = new ArrayList<>();
        for (int column = 0; column < board.getBoard()[0].length; column++)
            if (board.getBoard()[0][column] == '-') validColumns.add(column);
        return validColumns.get(random.nextInt(validColumns.size()));
    }
}
