package github.xnzvl.karak.items.chests;

import github.xnzvl.karak.items.Item;

/**
 * Interface for chests that represent points in the game.
 *
 * @author Jakub Nezval
 */
public interface Chest extends Item {
    /**
     * @return worth of the chest in points
     */
    float getScoreWorth();
}
