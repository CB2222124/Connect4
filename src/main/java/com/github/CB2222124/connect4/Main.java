package com.github.CB2222124.connect4;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Board board = new Board(6, 7);
        Scanner scanner = new Scanner(System.in);

        char token = 'X';
        boolean playing = true;

        while (playing) {
            System.out.print(board);
            System.out.println("Enter a column: ");
            int column = scanner.nextInt();
            if (!board.makeMove(column, token)) {
                System.out.println("Invalid move, turn forfeited");
            } else if (board.isWinningPosition(token)) {
                System.out.println("Winner: " + token);
                playing = false;
            } else if (board.isFull()) {
                System.out.println("Board full, draw");
                playing = false;
            } else {
                token = token == 'X' ? 'O' : 'X';
            }
        }
        System.out.print(board);
    }
}