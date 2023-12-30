package github.xnzvl.karak.items.weapons;

import github.xnzvl.karak.description.DescribedObject;

/**
 * Class for simplifying {@link Weapon} implementations.
 *
 * @author Jakub Nezval
 */
public class VariousWeapon extends DescribedObject implements Weapon {
    private final int strength;

    protected VariousWeapon(
            String title,
            String details,
            int strength
    ) {
        super(title, details);
        this.strength = strength;
    }

    @Override
    public int getStrength() {
        return this.strength;
    }
}
