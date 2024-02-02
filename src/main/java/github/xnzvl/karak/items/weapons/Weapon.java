package github.xnzvl.karak.items.weapons;

import github.xnzvl.karak.description.Description;

/**
 * Weapons provide a power boost to the wielder.
 * The power boost is equal to their strength.
 *
 * @author Jakub Nezval
 */
public interface Weapon extends Description {
    int getStrength();
}
