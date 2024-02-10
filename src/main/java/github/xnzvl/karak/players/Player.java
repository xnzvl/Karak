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
    private final String name;
    private final Function<Hero, PlayerInputHandler> inputHandlerConstructor;
    private final Picker picker;

    private Hero hero;
    private PlayerInputHandler inputHandler;

    /**
     * @param name name of the {@link Player}
     * @param inputHandlerConstructor creates {@link PlayerInputHandler} for user's inputs
     *                                (after calling {@link Player#assignHero})
     * @param picker additional handler for user inputs
     * @see Player#assignHero(Function)
     * @see Picker
     * @see PlayerInputHandler
     */
    public Player(
            String name,
            Function<Hero, PlayerInputHandler> inputHandlerConstructor,
            Picker picker
    ) {
        this.name = name;
        this.inputHandlerConstructor = inputHandlerConstructor;
        this.picker = picker;
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
    
    /**
     * @param heroConstructor {@link Function} for constructing a desired {@link Hero}
     * @see Picker
     */
    public void assignHero(
            Function<Picker, Hero> heroConstructor
    ) {
        this.hero = heroConstructor.apply(this.picker);
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
