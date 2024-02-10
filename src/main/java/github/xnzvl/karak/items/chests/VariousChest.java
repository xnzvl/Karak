package github.xnzvl.karak.items.chests;

import github.xnzvl.karak.description.DescribedObject;

/**
 * Class for simplifying {@link Chest} implementations.
 *
 * @author Jakub Nezval
 */
public class VariousChest extends DescribedObject implements Chest {
    private final float scoreWorth;
    private final boolean isLocked;

    protected VariousChest(
            String title,
            String details,
            float scoreWorth,
            boolean isLocked
    ) {
        super(title, details);
        this.scoreWorth = scoreWorth;
        this.isLocked = isLocked;
    }

    @Override
    public float getScoreWorth() {
        return this.scoreWorth;
    }

    @Override
    public boolean isLocked() {
        return this.isLocked;
    }
}
