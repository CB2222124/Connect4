package com.github.CB2222124.connect4.player;

import com.github.CB2222124.connect4.Board;
import com.github.CB2222124.connect4.move.*;
import com.github.CB2222124.connect4.token.TokenOwner;

import java.util.Scanner;

public class ConsolePlayer extends Player {

    public ConsolePlayer(TokenOwner token, String name) {
        super(token, name);
    }

    @Override
    public Move getMove(Board board) throws MoveException {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter a move: ");
        String input = scanner.nextLine();
        if (input.equalsIgnoreCase("B")) {
            //TODO: Implement;
            return new BlitzMove();
        } else if (input.equalsIgnoreCase("T")) {
            return new BombMove();
        } else {
            try {
                int column = Integer.parseInt(input);
                return new BasicMove(column, getToken());
            } catch (NumberFormatException ex) {
                throw new MoveException("No move provided");
            }
        }
    }
}
