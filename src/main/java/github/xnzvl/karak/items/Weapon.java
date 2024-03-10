package github.xnzvl.karak.items;

import github.xnzvl.karak.strengthfuls.Strength;

public enum Weapon implements Strength {
    DAGGER (1),
    SWORD  (2),
    AXE    (3);

    private final int strength;

    Weapon(
            int strength
    ) {
        this.strength = strength;
    }

    @Override
    public int getStrength() {
        return this.strength;
    }
}
