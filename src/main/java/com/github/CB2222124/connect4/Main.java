package com.github.CB2222124.connect4;

import com.github.CB2222124.connect4.player.AIPlayer;
import com.github.CB2222124.connect4.player.ConsolePlayer;
import com.github.CB2222124.connect4.view.ConsoleConnect4View;

public class Main {
    public static void main(String[] args) {
        ConsolePlayer player1 = new ConsolePlayer('O', "Human");
        AIPlayer player2 = new AIPlayer('X', "Computer");
        new Connect4(6, 7, player1, player2, new ConsoleConnect4View());
    }
}
