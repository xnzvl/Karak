package github.xnzvl.karak.items;

import org.jetbrains.annotations.NotNull;

public enum Spell implements Item {
    FOUNTAIN_TELEPORT ("Fountain Teleport"),
    FLAMING_SWORD     ("Flaming Sword");

    private final @NotNull String spellName;

    Spell(
            @NotNull String spellName
    ) {
        this.spellName = spellName;
    }

    @Override
    public @NotNull String getName() {
        return this.spellName;
    }
}
