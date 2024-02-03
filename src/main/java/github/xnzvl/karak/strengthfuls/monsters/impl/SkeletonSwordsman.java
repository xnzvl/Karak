package github.xnzvl.karak.strengthfuls.monsters.impl;

import github.xnzvl.karak.items.Item;
import github.xnzvl.karak.items.weapons.impl.Sword;
import github.xnzvl.karak.strengthfuls.monsters.VariousMonster;

/**
 * Skeleton Swordsman monster unit. Drops {@link Sword}.
 *
 * @author Jakub Nezval
 */
public class SkeletonSwordsman extends VariousMonster {
    public SkeletonSwordsman() {
        super(
                "Skeleton Swordsman",
                "",
                9,
                Item.from(new Sword())
        );
    }
}
