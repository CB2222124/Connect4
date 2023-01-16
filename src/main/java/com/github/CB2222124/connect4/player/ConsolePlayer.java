package com.github.CB2222124.connect4.player;

import com.github.CB2222124.connect4.Board;
import com.github.CB2222124.connect4.Token;

import java.util.Scanner;

public class ConsolePlayer extends Player {

    public ConsolePlayer(Token token, String name) {
        super(token, name);
    }

    @Override
    public int getMove(Board board) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter a column: ");
        return scanner.nextInt();
    }
}
