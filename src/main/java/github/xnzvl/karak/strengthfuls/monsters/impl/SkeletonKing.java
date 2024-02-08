package github.xnzvl.karak.strengthfuls.monsters.impl;

import github.xnzvl.karak.items.Item;
import github.xnzvl.karak.items.weapons.impl.Axe;
import github.xnzvl.karak.strengthfuls.monsters.VariousMonster;

/**
 * King of Skeletons monster unit. Drops {@link Axe}.
 *
 * @author Jakub Nezval
 */
public class SkeletonKing extends VariousMonster {
    public SkeletonKing() {
        super(
                "Skeleton King",
                "",
                10,
                Item.from(new Axe())
        );
    }
}