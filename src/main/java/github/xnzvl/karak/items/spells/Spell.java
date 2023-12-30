package github.xnzvl.karak.items.spells;

import github.xnzvl.karak.items.Item;
import github.xnzvl.karak.powerfuls.heroes.Hero;

/**
 * Interface for spell items. Spell items have type.
 * They are disposed after use by default.
 *
 * @author Jakub Nezval
 */
public interface Spell extends Item {
    /**
     * @param hero the hero on whom the spell is used
     */
    void use(Hero hero);

    /**
     * @return type of the spell
     */
    SpellType getType();
}
