package github.xnzvl.karak.powerfuls.monsters.impl;

import github.xnzvl.karak.items.Item;
import github.xnzvl.karak.items.chests.impl.RubyChest;
import github.xnzvl.karak.powerfuls.monsters.VariousMonster;

/**
 * Dragon monster unit. Drops {@link RubyChest}.
 *
 * @author Jakub Nezval
 */
public class Dragon extends VariousMonster {
    public Dragon() {
        super(
                "Dragon",
                "",
                15,
                Item.from(new RubyChest())
        );
    }
}
