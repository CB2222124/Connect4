package com.github.CB2222124.connect4.view;

import com.github.CB2222124.connect4.Board;
import com.github.CB2222124.connect4.player.Player;

public interface Connect4View {
    void showBoard(Board board);

    void showWinner(Player player);

    void showDraw();

    void showInvalidMove();
}
