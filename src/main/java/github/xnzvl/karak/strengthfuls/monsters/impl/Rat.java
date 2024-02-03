package github.xnzvl.karak.strengthfuls.monsters.impl;

import github.xnzvl.karak.items.Item;
import github.xnzvl.karak.items.weapons.impl.Dagger;
import github.xnzvl.karak.strengthfuls.monsters.VariousMonster;

/**
 * Rat monster unit. Drops {@link Dagger}.
 *
 * @author Jakub Nezval
 */
public class Rat extends VariousMonster {
    public Rat() {
        super(
                "Rat",
                "",
                5,
                Item.from(new Dagger())
        );
    }
}
