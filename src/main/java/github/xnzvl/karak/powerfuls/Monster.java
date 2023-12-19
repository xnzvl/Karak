package github.xnzvl.karak.powerfuls;

import github.xnzvl.karak.items.Chest;
import github.xnzvl.karak.items.Item;
import github.xnzvl.karak.items.Key;
import github.xnzvl.karak.items.Spell;
import github.xnzvl.karak.items.Weapon;
import github.xnzvl.karak.powerfuls.Powerful;

import org.jetbrains.annotations.NotNull;

public enum Monster implements Powerful {
    RAT            (5,  Weapon.DAGGER),
    KEY_SKELETON   (8,  Key.getInstance()),
    SWORD_SKELETON (9,  Weapon.SWORD),
    AXE_SKELETON   (10, Weapon.AXE),
    SPIDER         (8,  Spell.FOUNTAIN_TELEPORT),
    MUMMY          (7,  Spell.FLAMING_SWORD),
    GUARDIAN       (12, Chest.UNLOCKED_CHEST),
    DRAGON         (15, Chest.SAPHIRE_CHEST);

    private final int power;
    private final @NotNull Item drop;

    Monster(
            int power,
            @NotNull Item drop
    ) {
        this.power = power;
        this.drop = drop;
    }

    @Override
    public int getPower() {
        return this.power;
    }

    public Item getDrop() {
        return this.drop;
    }

    @Override
    public @NotNull String getName() {
        return this.toString();
    }
}
