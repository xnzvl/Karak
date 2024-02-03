package github.xnzvl.karak.strengthfuls.monsters;

import github.xnzvl.karak.items.Item;
import github.xnzvl.karak.strengthfuls.Strength;

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
    Item getDrop();
}
