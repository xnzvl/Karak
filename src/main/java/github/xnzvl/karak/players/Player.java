package github.xnzvl.karak.players;

import github.xnzvl.karak.strengthfuls.heroes.Hero;

import org.jetbrains.annotations.Nullable;

import java.util.function.Function;

/**
 * Class representing a player.
 *
 * @author Jakub Nezval
 */
public class Player {
    private final InputHandler inputHandler;
    private final String name;

    private Hero hero;

    /**
     * @param name name of the {@link Player}
     * @param inputHandler intermediary for {@link Player}'s input
     * @see Player#assignHero(Function, Hero.Params)
     * @see InputHandler
     * @see Picker
     */
    public Player(
            String name,
            InputHandler inputHandler
    ) {
        this.name = name;
        this.inputHandler = inputHandler;
    }

    /**
     * @return {@link InputHandler} associated with this {@link Player}
     */
    protected final InputHandler getInputHandler() {
        return this.inputHandler;
    }

    /**
     * @return {@link Player}'s hero
     */
    public final @Nullable Hero getHero() {
        return this.hero;
    }

    /**
     * @return name of the {@link Player}
     */
    public final String getName() {
        return this.name;
    }

    /**
     * Manages assignment of a new {@link Hero} to the {@link Player}.
     * It is expected that `paramObject` is missing only a {@link Picker} to be complete
     * ({@link Hero.Params#isComplete()}) - the {@link Picker} is added to the `paramObject` during execution.
     *
     * @param heroConstructor {@link Function} for creating a desired {@link Hero} instance
     * @param paramObject {@link Hero.Params} object for creating a {@link Hero} instance
     * @return new {@link Hero} instance
     */
    public final Hero assignHero(
            Function<Hero.Params, Hero> heroConstructor,
            Hero.Params paramObject
    ) {
        paramObject.setPicker(this.inputHandler.getPicker());

        this.hero = heroConstructor.apply(paramObject);

        inputHandler.setHero(this.hero);
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
            // TODO: some counter to prevent infinite loop
        }

        this.hero.endTurn();
    }
}
