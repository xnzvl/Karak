package github.xnzvl.karak.items.spells.impl;

import github.xnzvl.karak.items.spells.SpellType;
import github.xnzvl.karak.items.spells.DescribedSpell;
import github.xnzvl.karak.powerfuls.heroes.Hero;

/**
 * Flaming Sword spell. See Karak rules for more information.
 *
 * @author Jakub Nezval
 */
public class FlamingSword extends DescribedSpell {
    public FlamingSword() {
        super(
                "Flaming Sword",
                "Temporary +1 power.",
                SpellType.OFFENSIVE
        );
    }

    @Override
    public void use(
            Hero hero
    ) {

    }
}