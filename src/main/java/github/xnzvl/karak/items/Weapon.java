package github.xnzvl.karak.items;

import github.xnzvl.karak.description.Description;
import github.xnzvl.karak.strengthfuls.Strength;

public enum Weapon implements Description, Strength {
    // TODO: Weapon enum descriptions
    DAGGER ("", "", 1),
    SWORD  ("", "", 2),
    AXE    ("", "", 3);

    private final String title;
    private final String details;
    private final int strength;

    Weapon(
            String title,
            String details,
            int strength
    ) {
        this.title = title;
        this.details = details;
        this.strength = strength;
    }

    @Override
    public String getTitle() {
        return this.title;
    }

    @Override
    public String getDetails() {
        return this.details;
    }

    @Override
    public int getStrength() {
        return this.strength;
    }
}
