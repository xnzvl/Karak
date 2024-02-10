package github.xnzvl.karak.players.impl;

import github.xnzvl.karak.players.InputHandler;
import github.xnzvl.karak.players.Player;

/**
 * Class representing a human player.
 *
 * @author Jakub Nezval
 */
public class HumanPlayer extends Player {
    /**
     * @see Player#Player(String, InputHandler)
     */
    public HumanPlayer(  // TODO: maybe this class is useless
            String name,
            InputHandler inputHandler
    ) {
        super(name, inputHandler);
    }
}
