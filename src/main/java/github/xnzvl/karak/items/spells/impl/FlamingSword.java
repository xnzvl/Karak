package github.xnzvl.karak.items.spells.impl;

import github.xnzvl.karak.items.spells.Spell;
import github.xnzvl.karak.strengthfuls.heroes.Hero;

/**
 * Flaming Sword spell. See Karak rules for more information.
 *
 * @author Jakub Nezval
 */
public class FlamingSword extends Spell {
    public FlamingSword() {
        super(
                "Flaming Sword",
                "Temporary +1 power.",
                Type.OFFENSIVE,
                Target.SELF
        );
    }

    @Override
    public void use(
            Hero hero
    ) {

    }
}
