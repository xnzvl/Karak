package github.xnzvl.karak.items.chests;

/**
 * Class for simplifying {@link Chest} implementations.
 *
 * @author Jakub Nezval
 */
public abstract class VariousChest implements Chest {
    private final String title;
    private final String details;
    private final float scoreWorth;

    public VariousChest(
            String title,
            String details,
            float scoreWorth
    ) {
        this.title = title;
        this.details = details;
        this.scoreWorth = scoreWorth;
    }

    @Override
    public String getTitle() {
        return this.title;
    }

    @Override
    public String getDetails() {
        return this.details;
    }

    @Override
    public float getScoreWorth() {
        return this.scoreWorth;
    }
}
