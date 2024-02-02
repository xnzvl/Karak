package github.xnzvl.karak.items;

import github.xnzvl.karak.description.DescribedObject;
import github.xnzvl.karak.description.Description;

/**
 * Key for opening chests.
 *
 * @author Jakub Nezval
 */
public class Key extends DescribedObject implements Description {
    public Key() {
        super(
                "Key",
                "It's used to open locked chests"
        );
    }
}
