package github.xnzvl.karak.utils;

import java.util.function.Consumer;
import java.util.function.Function;

public abstract class Either<L, R> {
    public static <T> Function<T, Void> createConsumerFunction(
            Consumer<T> consumer
    ) {
        return (T t) -> {
            consumer.accept(t);
            return null;
        };
    }

    public static <L, R> Either<L, R> fromLeft(
            L value
    ) {
        return new Either<>() {
            @Override
            public <T> T apply(
                    Function<? super L, ? extends T> ltFunction,
                    Function<? super R, ? extends T> rtFunction
            ) {
                return ltFunction.apply(value);
            }
        };
    }

    public static <L, R> Either<L, R> fromRight(
            R value
    ) {
        return new Either<>() {
            @Override
            public <T> T apply(
                    Function<? super L, ? extends T> ltFunction,
                    Function<? super R, ? extends T> rtFunction
            ) {
                return rtFunction.apply(value);
            }
        };
    }

    private Either() {
        // on purpose
    }

    abstract public <T> T apply(
            Function<? super L, ? extends T> ltFunction,
            Function<? super R, ? extends T> rtFunction
    );

    public void consume(
            Consumer<L> lConsumer,
            Consumer<R> rConsumer
    ) {
        this.apply(
                createConsumerFunction(lConsumer),
                createConsumerFunction(rConsumer)
        );
    }
}
