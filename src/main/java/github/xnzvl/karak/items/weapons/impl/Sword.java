package github.xnzvl.karak.items.weapons.impl;

import github.xnzvl.karak.items.weapons.VariousWeapon;

/**
 * Wielder should gain +2 power.
 *
 * @author Jakub Nezval
 */
public class Sword extends VariousWeapon {
    public Sword() {
        super(
                "Sword",
                "+2 power.",
                2
        );
    }
}
