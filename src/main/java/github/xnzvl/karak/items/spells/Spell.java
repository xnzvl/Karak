package github.xnzvl.karak.items.spells;

import github.xnzvl.karak.items.Item;

/**
 * Interface for spell items. Spell items have type.
 * They are disposed after use by default.
 *
 * @author Jakub Nezval
 */
public interface Spell extends Item {
    /**
     * @return type of the spell
     */
    SpellType getType();
}
