package github.xnzvl.karak.players;

import java.util.List;

/**
 * Abstract class for providing additional form of {@link Player} input.
 *
 * @author Jakub Nezval
 */
public abstract class Picker {
    /**
     * Context in which the {@link Picker} is used.
     * @see Picker#pick(Context, List)
     */
    public enum Context {
        INVENTORY_SLOT,
        FOUNTAIN_PORT;
    }

    /**
     * Provides the ability to choose one of the provided options.
     *
     * @param context context of usage
     * @param options provided options
     * @return chosen option
     * @param <T> type variable
     * @see Picker.Context
     */
    public abstract <T> T pick(Context context, List<T> options);
}
