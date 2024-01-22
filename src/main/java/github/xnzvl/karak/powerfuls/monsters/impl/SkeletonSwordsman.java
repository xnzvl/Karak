package github.xnzvl.karak.powerfuls.monsters.impl;

import github.xnzvl.karak.items.weapons.impl.Sword;
import github.xnzvl.karak.powerfuls.monsters.VariousMonster;

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
                new Sword()
        );
    }
}