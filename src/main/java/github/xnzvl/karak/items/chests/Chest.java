package github.xnzvl.karak.items.chests;

import github.xnzvl.karak.description.Description;

/**
 * Interface for chests that represent points in the game.
 *
 * @author Jakub Nezval
 */
public interface Chest extends Description {
    /**
     * @return worth of the chest in points
     */
    float getScoreWorth();

    /**
     * @return boolean whether the {@link Chest} is locked
     */
    boolean isLocked();
}
