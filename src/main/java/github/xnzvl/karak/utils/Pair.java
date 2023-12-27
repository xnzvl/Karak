package github.xnzvl.karak.utils;

import java.util.Objects;

/**
 * Record for pairing two values of any type together.
 *
 * @param xValue first value
 * @param yValue second value
 * @param <X> type of the first value
 * @param <Y> type of the second value
 *
 * @author Jakub Nezval
 */
public record Pair<X, Y>(
        X xValue,
        Y yValue
) {
    /**
     * Sugar method for creating instances.
     *
     * @param xValue x value
     * @param yValue y value
     * @return new instance
     * @param <X> X type
     * @param <Y> Y type
     */
    public static <X, Y> Pair<X, Y> of(
            X xValue,
            Y yValue
    ) {
        return new Pair<>(xValue, yValue);
    }

    @Override
    public boolean equals(
            Object o
    ) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Pair<?, ?> pair = (Pair<?, ?>) o;
        return Objects.equals(this.xValue, pair.xValue) && Objects.equals(this.yValue, pair.yValue);
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.xValue, this.yValue);
    }
}
