package github.xnzvl.karak.exceptions;

public class HeroInvalidStateException extends RuntimeException {
    public HeroInvalidStateException() {
        // nothing here
    }

    public HeroInvalidStateException(
            String message
    ) {
        super(message);
    }

    public HeroInvalidStateException(
            String message,
            Throwable cause
    ) {
        super(message, cause);
    }

    public HeroInvalidStateException(
            Throwable cause
    ) {
        super(cause);
    }
}
