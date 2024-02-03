package github.xnzvl.karak.strengthfuls.monsters.impl;

import github.xnzvl.karak.items.Item;
import github.xnzvl.karak.items.chests.impl.OrdinaryChest;
import github.xnzvl.karak.strengthfuls.monsters.VariousMonster;

/**
 * Fallen One monster unit. Drops {@link OrdinaryChest}.
 *
 * @author Jakub Nezval
 */
public class FallenOne extends VariousMonster {
    public FallenOne() {
        super(
                "Fallen One",
                "",
                12,
                Item.from(new OrdinaryChest())
        );
    }
}
