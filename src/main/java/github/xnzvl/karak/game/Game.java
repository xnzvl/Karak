package github.xnzvl.karak.game;

import java.util.Collection;

public interface Game {
    void start();
    Collection<Player> getWinner();
}
