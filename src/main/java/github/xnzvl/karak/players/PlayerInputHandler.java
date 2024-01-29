package github.xnzvl.karak.players;

import github.xnzvl.karak.powerfuls.heroes.Hero;

/**
 * Abstract class for classes that provide input to the game logic.
 *
 * @author Jakub Nezval
 */
public abstract class PlayerInputHandler {
    private final Hero hero;

    /**
     * @param hero target of {@link PlayerInputHandler#handleInput()} calls
     */
    public PlayerInputHandler(
            Hero hero
    ) {
        this.hero = hero;
    }

    /**
     * @return hero associated with this {@link PlayerInputHandler}
     */
    public Hero getHero() {
        return this.hero;
    }

    /**
     * This function should handle the input and call an adequate method on the Hero instance.
     *
     * @return result
     * @see Player#takeTurn()
     * @see InputResult
     */
    public abstract InputResult handleInput();
}
