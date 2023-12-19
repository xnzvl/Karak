package github.xnzvl.karak.game;

import github.xnzvl.karak.powerfuls.heroes.Hero;

public interface Player {
    String getName();
    Hero getHero();
    void takeTurn();
}
