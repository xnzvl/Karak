package github.xnzvl.karak.game;

import github.xnzvl.karak.mortals.heroes.Hero;

public interface Player {
    String getName();
    Hero getHero();
    void takeTurn();
}
