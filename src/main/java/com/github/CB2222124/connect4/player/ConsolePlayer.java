package com.github.CB2222124.connect4.player;

import com.github.CB2222124.connect4.Board;
import com.github.CB2222124.connect4.move.*;
import com.github.CB2222124.connect4.token.TokenOwner;

import java.util.Scanner;

public class ConsolePlayer extends Player {

    /**
     * Human player that inputs moves through the Standard input stream.
     *
     * @param token The token ownership associated with this player.
     * @param name  The display name for this player.
     */
    public ConsolePlayer(TokenOwner token, String name) {
        super(token, name);
    }

    @Override
    public Move getMove(Board board) throws MoveException {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter a move: ");
        String input = scanner.nextLine();

        if (input.equalsIgnoreCase("B")) {
            System.out.print("Enter a column to blitz: ");
            input = scanner.nextLine();
            return new BlitzMove(parseStringAsColumnIndex(input));
        } else if (input.equalsIgnoreCase("T")) {
            System.out.print("Enter a column to drop time bomb: ");
            input = scanner.nextLine();
            return new BombMove(parseStringAsColumnIndex(input));
        } else {
            return new BasicMove(parseStringAsColumnIndex(input), getToken());
        }
    }

    private int parseStringAsColumnIndex(String string) throws MoveException {
        try {
            return Integer.parseInt(string);
        } catch (NumberFormatException ex) {
            throw new MoveException("No move provided");
        }
    }
}
