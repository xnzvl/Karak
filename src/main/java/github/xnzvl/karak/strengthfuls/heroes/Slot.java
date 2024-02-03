package github.xnzvl.karak.strengthfuls.heroes;

import java.util.Collection;
import java.util.Set;

public enum Slot {
    WEAPON_ONE,
    WEAPON_TWO,
    SPELL_ONE,
    SPELL_TWO,
    SPELL_THREE,
    KEY;

    private static final Collection<Slot> weaponSlots;
    private static final Collection<Slot> spellSlots;

    static {
        weaponSlots = java.util.Set.copyOf(Set.of(WEAPON_ONE, WEAPON_TWO));
        spellSlots = java.util.Set.copyOf(Set.of(SPELL_ONE, SPELL_TWO, SPELL_THREE));
    }

    public static Collection<Slot> getWeaponSlots() {
        return Slot.weaponSlots;
    }

    public static Collection<Slot> getSpellSlots() {
        return Slot.spellSlots;
    }

    public static boolean isWeaponSlot(
            Slot slot
    ) {
        return weaponSlots.contains(slot);
    }

    public static boolean isSpellSlot(
            Slot slot
    ) {
        return spellSlots.contains(slot);
    }
}
