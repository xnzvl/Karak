package github.xnzvl.karak.items.spells;

import github.xnzvl.karak.items.Item;
import github.xnzvl.karak.items.spells.effects.Effect;

import java.util.List;

/**
 * Interface for spell items. Spell items have type and effects.
 * They are disposed after use by default.
 *
 * @author Jakub Nezval
 */
public interface Spell extends Item {
    /**
     * @return spell type of the spell
     */
    SpellType getType();

    /**
     * @return effects that the spell has
     */
    List<Effect> getEffects();
}
