package github.xnzvl.karak.powerfuls;

import github.xnzvl.karak.description.Description;

/**
 * Interface for classes that represent units - Monsters/Heroes - in game.
 *
 * @author Jakub Nezval
 */
public interface Power extends Description {
    /**
     * @return power of the unit
     */
    int getPower();
}
