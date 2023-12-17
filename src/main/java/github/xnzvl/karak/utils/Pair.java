package github.xnzvl.karak.utils;

public record Pair<X, Y>(X x, Y y) {
    public static <X, Y> Pair<X, Y> of(X x, Y y) {
        return new Pair<>(x, y);
    }
}
