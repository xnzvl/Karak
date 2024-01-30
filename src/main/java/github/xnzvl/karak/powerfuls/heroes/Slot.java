package github.xnzvl.karak.powerfuls.heroes;

import java.util.List;

public enum Slot {
    WEAPON_ONE,
    WEAPON_TWO,
    SPELL_ONE,
    SPELL_TWO,
    SPELL_THREE,
    KEY;

    public List<Slot> getWeaponSlots() {
        return List.of(WEAPON_ONE, WEAPON_TWO);
    }

    public List<Slot> getSpellSlots() {
        return List.of(SPELL_ONE, SPELL_TWO, SPELL_THREE);
    }
}
