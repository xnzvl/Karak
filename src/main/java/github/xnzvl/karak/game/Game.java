package github.xnzvl.karak.game;

import github.xnzvl.karak.players.Player;

import java.util.Collection;

public interface Game {
    void start();
    Collection<Player> getWinner();
}
