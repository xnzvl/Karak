package github.xnzvl.karak.strengthfuls;

import github.xnzvl.karak.description.Description;
import github.xnzvl.karak.items.Chest;
import github.xnzvl.karak.items.Item;
import github.xnzvl.karak.items.Key;
import github.xnzvl.karak.items.Spell;
import github.xnzvl.karak.items.Weapon;

/**
 * Enum for monster units.
 *
 * @author Jakub Nezval
 */
public enum Monster implements Description, Strength {
    // TODO: Monster enum descriptions
    RAT                 ("Rat", "", 5, Item.from(Weapon.DAGGER)),
    SPIDER              ("Spider", "", 6, Item.from(Spell.HEALING_WARP)),
    SKELETON_KEY_KEEPER ("Skeleton Key Keeper", "", 7, Item.from(new Key())),
    MUMMY               ("Mummy", "", 7, Item.from(Spell.FLAMING_SWORD)),
    SKELETON_SWORDSMAN  ("Skeleton Swordsman", "", 9, Item.from(Weapon.SWORD)),
    SKELETON_KING       ("Skeleton King", "", 10, Item.from(Weapon.AXE)),
    FALLEN              ("Fallen", "", 12, Item.from(Chest.SIMPLE_CHEST_UNLOCKED)),
    DRAGON              ("Dragon", "", 15, Item.from(Chest.RUBY_CHEST));

    private final String title;
    private final String details;
    private final int strength;
    private final Item drop;

    Monster(
            String title,
            String details,
            int strength,
            Item drop
    ) {
        this.title = title;
        this.details = details;
        this.strength = strength;
        this.drop = drop;
    }

    public Item getDrop() {
        return this.drop;
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
