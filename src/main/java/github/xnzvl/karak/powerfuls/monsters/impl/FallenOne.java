package github.xnzvl.karak.powerfuls.monsters.impl;

import github.xnzvl.karak.items.chests.impl.OrdinaryChest;
import github.xnzvl.karak.powerfuls.monsters.VariousMonster;

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
                new OrdinaryChest()
        );
    }
}
