package github.xnzvl.karak.powerfuls.monsters.impl;

import github.xnzvl.karak.items.spells.impl.HealingWarp;
import github.xnzvl.karak.powerfuls.monsters.VariousMonster;

/**
 * Huge Spider monster unit. Drops {@link HealingWarp}.
 *
 * @author Jakub Nezval
 */
public class Spider extends VariousMonster {
    public Spider() {
        super(
                "Huge Spider",
                "",
                6,
                new HealingWarp()
        );
    }
}
