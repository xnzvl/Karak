package github.xnzvl.karak.items;

import org.jetbrains.annotations.NotNull;

public enum Chest implements Item {
    LOCKED_CHEST   ("Locked Chest"),
    UNLOCKED_CHEST ("Unlocked Chest"),
    SAPHIRE_CHEST  ("Saphire Chest");

    private final @NotNull String chestName;

    Chest(
            @NotNull String chestName
    ) {
        this.chestName = chestName;
    }

    @Override
    public @NotNull String getName() {
        return this.chestName;
    }
}
