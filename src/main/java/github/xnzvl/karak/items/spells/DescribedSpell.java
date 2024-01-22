package github.xnzvl.karak.items.spells;

import github.xnzvl.karak.description.DescribedObject;

/**
 * Class for simplifying {@link Spell} implementations.
 *
 * @author Jakub Nezval
 */
public abstract class DescribedSpell extends DescribedObject implements Spell {
    private final SpellType type;

    protected DescribedSpell(
            String title,
            String details,
            SpellType type
    ) {
        super(title, details);
        this.type = type;
    }

    @Override
    public SpellType getType() {
        return this.type;
    }
}