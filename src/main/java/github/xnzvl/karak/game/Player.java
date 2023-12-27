package github.xnzvl.karak.game;

import github.xnzvl.karak.DescribedObject;
import github.xnzvl.karak.powerfuls.heroes.Hero;

public interface Player extends DescribedObject {
    String getName();
    Hero getHero();
    void takeTurn();
}
