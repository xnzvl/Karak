package github.xnzvl.karak.strengthfuls.monsters.impl;

import github.xnzvl.karak.items.Item;
import github.xnzvl.karak.items.spells.impl.HealingWarp;
import github.xnzvl.karak.strengthfuls.monsters.VariousMonster;

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
                Item.from(new HealingWarp())
        );
    }
}