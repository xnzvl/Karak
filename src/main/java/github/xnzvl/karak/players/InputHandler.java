package github.xnzvl.karak.players;

import github.xnzvl.karak.strengthfuls.heroes.Hero;

import org.jetbrains.annotations.Nullable;

import java.util.function.Function;

/**
 * Abstract root class for classes that provide input to the game logic.
 *
 * @author Jakub Nezval
 */
public abstract class InputHandler {
    private Hero hero;

    /**
     * @return {@link Picker} instance
     * @see InputHandler#assignHero(Function) 
     */
    protected abstract Picker getPicker();

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
     * @param heroConstructor {@link Function} for constructing a desired {@link Hero}
     * @see Hero
     * @see Picker
     */
    public final void assignHero(
            Function<Picker, Hero> heroConstructor
    ) {
        this.hero = heroConstructor.apply(this.getPicker());
    }
}
