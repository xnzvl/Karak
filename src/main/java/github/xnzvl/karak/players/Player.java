package github.xnzvl.karak.players;

import github.xnzvl.karak.strengthfuls.heroes.Hero;

import org.jetbrains.annotations.Nullable;

import java.util.function.Function;
import java.util.function.Supplier;

/**
 * Class representing a player.
 *
 * @author Jakub Nezval
 */
public class Player {
    private final String name;
    private final Function<Hero, PlayerInputHandler> inputHandlerConstructor;

    private Hero hero;
    private PlayerInputHandler inputHandler;

    /**
     * @param name name of the {@link Player}
     * @param inputHandlerConstructor creates {@link PlayerInputHandler} for user's inputs
     *                                (after calling {@link Player#assignHero})
     * @see Player#assignHero(Hero)
     * @see PlayerInputHandler
     */
    public Player(
            String name,
            Function<Hero, PlayerInputHandler> inputHandlerConstructor
    ) {
        this.name = name;
        this.inputHandlerConstructor = inputHandlerConstructor;
    }

    /**
     * @return {@link PlayerInputHandler} associated with this {@link Player}
     */
    protected @Nullable PlayerInputHandler getInputHandler() {
        return this.inputHandler;
    }

    /**
     * @return {@link Player}'s hero
     */
    public @Nullable Hero getHero() {
        return this.hero;
    }

    /**
     * @return name of the {@link Player}
     */
    public String getName() {
        return this.name;
    }

    // TODO: - Picker for the Hero
    //       - fix Player#Player javadoc
    /**
     * @param heroConstructor {@link Function} for constructing a desired {@link Hero}
     */
    public void assignHero(
            Function<Object, Hero> heroConstructor  // fix type
    ) {
        this.hero = null; // use constructor here
        this.inputHandler = this.inputHandlerConstructor.apply(hero);
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
}
