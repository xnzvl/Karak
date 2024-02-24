package github.xnzvl.karak.items.spells;

import github.xnzvl.karak.description.DescribedObject;
import github.xnzvl.karak.strengthfuls.heroes.Hero;

public abstract class Spell extends DescribedObject {
    public enum Target {
        OTHER_ONE,
        SELF;
    }

    public enum Type {
        OFFENSIVE,
        UTILITY;
    }

    private final Spell.Target target;
    private final Spell.Type type;

    protected Spell(
            String title,
            String details,
            Spell.Type type,
            Spell.Target target
    ) {
        super(title, details);
        this.type = type;
        this.target = target;
    }

    public abstract void use(Hero hero);

    public Spell.Target getTarget() {
        return this.target;
    }

    public Spell.Type getType() {
        return this.type;
    }
}
