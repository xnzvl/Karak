package github.xnzvl.karak.powerfuls.monsters;

import github.xnzvl.karak.powerfuls.Strength;

/**
 * Interface for monster units.
 *
 * @author Jakub Nezval
 */
public interface Monster extends Strength {
    /**
     * Monster drops an Item on defeat.
     * Also, defeating some enemies can have additional effects.
     *
     * @return dropped item
     */
    Item defeat();
}
