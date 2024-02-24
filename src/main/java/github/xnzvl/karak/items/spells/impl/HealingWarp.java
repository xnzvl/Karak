package github.xnzvl.karak.items.spells.impl;

import github.xnzvl.karak.items.spells.Spell;
import github.xnzvl.karak.strengthfuls.heroes.Hero;

/**
 * Healing Warp spell. See Karak rules for more information.
 *
 * @author Jakub Nezval
 */
public class HealingWarp extends Spell {
    public HealingWarp() {
        super(
                "Healing Warp",
                "Teleports Hero to a fountain of their choice and heals them to full health points. "
                    + "If the spell is used before the first step "
                    + "then the Hero can continue their turn like if nothing happened. "
                    + "Otherwise the Hero loses all of the remaining steps and their turn is over.",
                Type.UTILITY,
                Target.SELF
        );
    }

    @Override
    public void use(
            Hero hero
    ) {

    }
}
