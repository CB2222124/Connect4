package com.github.CB2222124.connect4.player;

import com.github.CB2222124.connect4.Board;
import com.github.CB2222124.connect4.move.*;
import com.github.CB2222124.connect4.token.TokenOwner;

import java.util.Scanner;

public class ConsolePlayer extends Player {

    //TODO: In a scaled application there should be a layer of abstraction that leaves the player with some data structure of available moves.
    //Limits the use of these two moves to one for a console player.
    private boolean usedBlitz;
    private boolean usedBomb;

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
            if (usedBlitz) throw new MoveException("Blitz has already been used");
            System.out.print("Enter a column to blitz: ");
            input = scanner.nextLine();
            Move move = new BlitzMove(parseStringAsColumnIndex(input));
            move.validateMove(board);
            usedBlitz = true;
            return move;
        } else if (input.equalsIgnoreCase("T")) {
            if (usedBomb) throw new MoveException("Blitz has already been used");
            System.out.print("Enter a column to drop time bomb: ");
            input = scanner.nextLine();
            Move move = new BombMove(parseStringAsColumnIndex(input));
            move.validateMove(board);
            usedBomb = true;
            return move;
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
