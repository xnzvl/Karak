package github.xnzvl.karak.players.impl;

import github.xnzvl.karak.players.PlayerInputHandler;
import github.xnzvl.karak.players.Player;
import github.xnzvl.karak.strengthfuls.heroes.Hero;

import java.util.function.Function;

/**
 * Class representing a human player.
 *
 * @author Jakub Nezval
 */
public class HumanPlayer extends Player {
    /**
     * @see Player#Player(String, Hero, Function) Player constructor
     */
    public HumanPlayer(
            String name,
            Hero hero,
            Function<Hero, PlayerInputHandler> inputHandlerCreator
    ) {
        super(name, hero, inputHandlerCreator);
    }
}
