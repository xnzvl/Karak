package github.xnzvl.karak.utils;

import org.jetbrains.annotations.Nullable;

public class Result {
    public enum Failure {
        INVALID_CHOICE,
        NEEDS_KEY,
        NOT_ALLOWED,
        MISSING_CHEST,
        NULL;
    }

    private static final Result SUCCESS = new Result(null);

    public static Result withSuccess() {
        return SUCCESS;
    }

    public static Result withFailure(
            Failure failure
    ) {
        return new Result(failure);
    }

    @Nullable
    private final Result.Failure failure;

    private Result(
            @Nullable Result.Failure errorType
    ) {
        this.failure = errorType;
    }

    @Nullable
    public Result.Failure getFailure() {
        return failure;
    }
}
