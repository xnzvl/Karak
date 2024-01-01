package github.xnzvl.karak.powerfuls.monsters;

import github.xnzvl.karak.items.Item;
import github.xnzvl.karak.powerfuls.Power;

/**
 * Interface for monster units.
 *
 * @author Jakub Nezval
 */
public interface Monster extends Power {
    /**
     * Monster drops an Item on defeat.
     * Also, defeating some enemies can have additional effects.
     *
     * @return dropped item
     */
    Item defeat();
}
