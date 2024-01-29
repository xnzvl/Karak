package github.xnzvl.karak.players;

import github.xnzvl.karak.powerfuls.heroes.Hero;

import java.util.function.Function;

/**
 * Class representing a player.
 *
 * @author Jakub Nezval
 */
public class Player {
    private final String name;
    private final Hero hero;
    private final PlayerInputHandler inputHandler;

    /**
     * @param name name of the {@link Player}
     * @param hero {@link Player}'s hero
     * @param inputHandlerCreator handler for user's inputs
     */
    public Player(
            String name,
            Hero hero,
            Function<Hero, PlayerInputHandler> inputHandlerCreator
    ) {
        this.name = name;
        this.hero = hero;
        this.inputHandler = inputHandlerCreator.apply(hero);

        if (this.inputHandler.getHero() != hero) {
            // throw error
        }
    }

    /**
     * @return {@link PlayerInputHandler} associated with this player
     */
    protected PlayerInputHandler getInputHandler() {
        return this.inputHandler;
    }

    /**
     * @return Player's hero
     */
    public Hero getHero() {
        return this.hero;
    }

    /**
     * This function represents taking a turn.
     * It allows the player to play and to make decisions.
     */
    public final void takeTurn() {
        this.hero.startTurn();

        //noinspection StatementWithEmptyBody
        while (this.inputHandler.handleInput() != InputResult.END_TURN) {
            // IDEA warning successfully suppressed!
            // TODO: some counter to prevent infinite loop
        }

        this.hero.endTurn();
    }

    /**
     * @return name of the Player
     */
    public String getName() {
        return this.name;
    }
}
