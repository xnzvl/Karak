package github.xnzvl.karak.items.chests;

import github.xnzvl.karak.description.DescribedObject;

/**
 * Class for simplifying {@link Chest} implementations.
 *
 * @author Jakub Nezval
 */
public class VariousChest extends DescribedObject implements Chest {
    private final float scoreWorth;

    protected VariousChest(
            String title,
            String details,
            float scoreWorth
    ) {
        super(title, details);
        this.scoreWorth = scoreWorth;
    }

    @Override
    public float getScoreWorth() {
        return this.scoreWorth;
    }
}
