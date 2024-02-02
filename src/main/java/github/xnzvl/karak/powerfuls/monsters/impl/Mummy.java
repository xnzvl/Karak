package github.xnzvl.karak.powerfuls.monsters.impl;

import github.xnzvl.karak.items.spells.impl.FlamingSword;
import github.xnzvl.karak.powerfuls.monsters.VariousMonster;

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
                new FlamingSword()
        );
    }

    @Override
    public Item defeat() {
        // TODO: apply Curse
        System.out.println("APPLY CURSE HERE");
        return this.getDrop();
    }
}
