package github.xnzvl.karak.items.weapons;

import github.xnzvl.karak.description.DescribedObject;

/**
 * General class that is used for various weapons.
 * Weapon type provides strength and title. Details string is created on instantiation.
 *
 * @author Jakub Nezval
 */
public class VariousWeapon extends DescribedObject implements Weapon {
    private final int strength;

    public VariousWeapon(
            WeaponType type
    ) {
        super(
                type.getTitle(),
                "Provides +" + type.getStrength() + " power to the wielder."
        );
        this.strength = type.getStrength();
    }

    @Override
    public int getStrength() {
        return this.strength;
    }
}
