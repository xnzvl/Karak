package github.xnzvl.karak.items.weapons;

/**
 * Weapon type that holds information about strength and title.
 *
 * @author Jakub Nezval
 */
public enum WeaponType {
    DAGGER (
            "Dagger",
            1
    ),
    SWORD  (
            "Sword",
            2
    ),
    AXE    (
            "Axe",
            3
    );

    private final String title;
    private final int strength;

    WeaponType(
            String title,
            int strength
    ) {
        this.title = title;
        this.strength = strength;
    }

    public String getTitle() {
        return this.title;
    }

    public int getStrength() {
        return this.strength;
    }
}
