package github.xnzvl.karak.description;

/**
 * Convenient implementor of {@link Description}
 * that should simplify implementations of interfaces that extend it.
 *
 * @author Jakub Nezval
 */
public class DescribedObject implements Description {
    private final String title;
    private final String details;

    protected DescribedObject(
            String title,
            String details
    ) {
        this.title = title;
        this.details = details;
    }

    @Override
    public String getTitle() {
        return this.title;
    }

    @Override
    public String getDetails() {
        return this.details;
    }
}
