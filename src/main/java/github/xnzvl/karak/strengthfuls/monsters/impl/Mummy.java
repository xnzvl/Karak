package github.xnzvl.karak.strengthfuls.monsters.impl;

import github.xnzvl.karak.items.Item;
import github.xnzvl.karak.items.spells.impl.FlamingSword;
import github.xnzvl.karak.strengthfuls.monsters.VariousMonster;

// TODO: Curse in javadoc
/**
 * Mummy monster unit. Drops {@link FlamingSword}. On defeat Curse is evoked.
 *
 * @author Jakub Nezval
 */
public class Mummy extends VariousMonster {
    public Mummy() {
        super(
                "Mummy",
                "",
                7,
                Item.from(new FlamingSword())
        );
    }

    @Override
    public Item getDrop() {
        // TODO: apply Curse
        System.out.println("APPLY CURSE HERE");
        return super.getDrop();
    }
}
