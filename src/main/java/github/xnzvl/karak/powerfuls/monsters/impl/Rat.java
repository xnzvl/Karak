package github.xnzvl.karak.powerfuls.monsters.impl;

import github.xnzvl.karak.items.Item;
import github.xnzvl.karak.items.weapons.impl.Dagger;
import github.xnzvl.karak.powerfuls.monsters.VariousMonster;

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
