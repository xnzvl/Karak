package github.xnzvl.karak.powerfuls.monsters.impl;

import github.xnzvl.karak.items.Item;
import github.xnzvl.karak.items.Key;
import github.xnzvl.karak.powerfuls.monsters.VariousMonster;

/**
 * Skeleton Key Keeper monster unit. Drops {@link Key}.
 *
 * @author Jakub Nezval
 */
public class SkeletonKeyKeeper extends VariousMonster {
    public SkeletonKeyKeeper() {
        super(
                "Skeleton Key Keeper",
                "",
                8,
                Item.from(new Key())
        );
    }
}
