package github.xnzvl.karak.utils;

/**
 * This interface is mainly meant for inner static builder classes.
 * It only guarantees that implementor class has {@link Buildable#build()} method.
 *
 * @see       Buildable#build()
 * @author    Jakub Nezval
 * @param <T> class that builder is meant to build
 */
public interface Buildable<T> {
    /**
     * @return built instance
     * @see Buildable
     */
    T build();
}
