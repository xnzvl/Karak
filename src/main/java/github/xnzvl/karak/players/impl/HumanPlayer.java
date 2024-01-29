package github.xnzvl.karak.players.impl;

import github.xnzvl.karak.players.PlayerInputHandler;
import github.xnzvl.karak.players.Player;
import github.xnzvl.karak.powerfuls.heroes.Hero;

import java.util.function.Function;

public class HumanPlayer extends Player {
    public HumanPlayer(
            String name,
            Hero hero,
            Function<Hero, PlayerInputHandler> inputHandlerCreator
    ) {
        super(name, hero, inputHandlerCreator);
    }
}
