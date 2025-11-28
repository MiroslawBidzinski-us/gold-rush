package edu.io;

import edu.io.token.GoldToken;
import edu.io.token.PlayerToken;
import edu.io.token.PyriteToken;

public class Game {
    private Player player;
    private final Board board;

    public Game() {
        board = new Board();
    }
    
    public void join(Player player) {
        this.player = player;
        this.player.assignToken(new PlayerToken(this.player, this.board));
    }

    public void start() {
        board.placeToken(0,5, new GoldToken(1.5));
        board.placeToken(1,6, new PyriteToken());
        board.placeToken(3,1, new GoldToken(1.0));
        board.placeToken(3,3, new GoldToken(1.25));
        board.display();
        // todo: do zrobienia sterowanie graczem
    }
}