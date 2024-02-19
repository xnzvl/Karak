package github.xnzvl.karak.players;

import github.xnzvl.karak.strengthfuls.heroes.Hero;

import org.jetbrains.annotations.Nullable;

/**
 * Abstract root class for classes that provide input to the game logic.
 *
 * @author Jakub Nezval
 */
public abstract class InputHandler {
    private Hero hero;

    /**
     * @return {@link Picker} instance
     */
    public abstract Picker getPicker();

    /**
     * This function should handle the input and call an adequate method on the {@link Hero} instance.
     *
     * @return result
     * @see Player#takeTurn()
     * @see InputResult
     */
    public abstract InputResult handleInput();

    /**
     * @return hero associated with this {@link InputHandler}
     */
    public @Nullable Hero getHero() {
        return this.hero;
    }

    /**
     * Sets {@link Hero} for the {@link InputHandler}.
     * Namely for {@link InputHandler#handleInput()} method.
     *
     * @param hero hero instance
     * @see InputHandler#handleInput()
     */
    public void setHero(
            Hero hero
    ) {
        this.hero = hero;
    }
}
