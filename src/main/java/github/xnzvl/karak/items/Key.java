package github.xnzvl.karak.items;

import github.xnzvl.karak.description.DescribedObject;

/**
 * Key for opening chests.
 *
 * @author Jakub Nezval
 */
public class Key extends DescribedObject implements Item {
    public Key() {
        super(
                "Key",
                "It's used to open locked chests"
        );
    }
}
