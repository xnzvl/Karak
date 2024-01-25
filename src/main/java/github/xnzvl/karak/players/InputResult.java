package github.xnzvl.karak.players;

/**
 * Enumeration for possible outcomes of handling an input from a player.
 * Options are {@link InputResult#CONTINUE_TURN} and {@link InputResult#END_TURN}.
 *
 * @see PlayerInputHandler#handleInput()
 * @author Jakub Nezval
 */
public enum InputResult {
    /**
     * Turn isn't force-ended by the {@link Player}.
     */
    CONTINUE_TURN,
    /**
     * Turn is force-ended by the {@link Player}. Even if there are some possibilities left.
     */
    END_TURN;
}
