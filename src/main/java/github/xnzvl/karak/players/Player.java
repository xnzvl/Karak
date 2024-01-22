package github.xnzvl.karak.players;

import github.xnzvl.karak.description.Description;
import github.xnzvl.karak.powerfuls.heroes.Hero;

public interface Player extends Description {
    String getName();
    Hero getHero();
    void takeTurn();
}
