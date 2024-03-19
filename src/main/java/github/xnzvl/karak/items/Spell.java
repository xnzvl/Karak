package github.xnzvl.karak.items;

import github.xnzvl.karak.description.Description;

import java.util.List;

public enum Spell implements Description {
    // TODO: Spell enum descriptions + values
    FLAMING_SWORD ("", "", null, null),
    HEALING_WARP  ("", "", null, null);

    public enum Type {
        UTILITY,
        OFFENSIVE;
    }

    public enum Effect {
        FOUNTAIN_PORT,
        HEAL,
        TEMPORARY_STRENGTH_ONE;
    }

    private final String title;
    private final String details;
    private final Spell.Type type;
    private final List<Spell.Effect> effects;

    Spell(
            String title,
            String details,
            Type type,
            List<Effect> effects
    ) {
        this.title = title;
        this.details = details;
        this.type = type;
        this.effects = effects;
    }

    @Override
    public String getTitle() {
        return title;
    }

    @Override
    public String getDetails() {
        return details;
    }

    public Type getType() {
        return type;
    }

    public List<Effect> getEffects() {
        return effects;
    }
}
