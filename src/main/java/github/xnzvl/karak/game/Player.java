package github.xnzvl.karak.game;

import github.xnzvl.karak.mortals.Hero;

public interface Player {
    String getName();
    Hero getHero();
    void takeTurn();
}
