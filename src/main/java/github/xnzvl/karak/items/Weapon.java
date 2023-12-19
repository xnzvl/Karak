package github.xnzvl.karak.items;

import org.jetbrains.annotations.NotNull;

public enum Weapon implements Item {
    DAGGER (1, "Sharp Dagger"),
    SWORD  (2, "One-handed Sword"),
    AXE    (3, "Double-handed Axe");

    static @NotNull String getHelp() {
        return "WEAPON: HELP STRING";  // TODO
    }

    private final int strength;
    private final @NotNull String weaponName;

    Weapon(
            int strength,
            @NotNull String weaponName
    ) {
        this.strength = strength;
        this.weaponName = weaponName;
    }

    public int getStrength() {
        return this.strength;
    }

    public @NotNull String getName() {
        return this.weaponName;
    }
}
