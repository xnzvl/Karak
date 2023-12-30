package github.xnzvl.karak.items.spells;

import github.xnzvl.karak.items.spells.effects.Effect;

import java.util.List;

/**
 * Class for simplifying {@link Spell} implementations.
 *
 * @author Jakub Nezval
 */
public class VariousSpell implements Spell {
    private final String title;
    private final String details;
    private final SpellType type;
    private final List<Effect> effects;

    protected VariousSpell(
            String title,
            String details,
            SpellType type,
            List<Effect> effects
    ) {
        this.title = title;
        this.details = details;
        this.type = type;
        this.effects = effects;
    }

    @Override
    public String getTitle() {
        return this.title;
    }

    @Override
    public String getDetails() {
        return this.details;
    }

    @Override
    public SpellType getType() {
        return this.type;
    }

    @Override
    public List<Effect> getEffects() {
        return this.effects;
    }
}
