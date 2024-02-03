package github.xnzvl.karak.strengthfuls.heroes;

import github.xnzvl.karak.description.DescribedObject;
import github.xnzvl.karak.items.Item;
import github.xnzvl.karak.items.Key;
import github.xnzvl.karak.items.chests.Chest;
import github.xnzvl.karak.items.spells.Spell;
import github.xnzvl.karak.items.weapons.Weapon;
import github.xnzvl.karak.strengthfuls.Strength;
import github.xnzvl.karak.utils.MapUtils;
import github.xnzvl.karak.utils.Pair;

import org.jetbrains.annotations.Nullable;

import java.util.Arrays;
import java.util.Map;
import java.util.function.Predicate;

public class Hero extends DescribedObject implements Strength {
    public static final int MAX_HIT_POINTS = 5;
    public static final int DEFAULT_NUMBER_OF_STEPS = 4;

    private int hitPoints = MAX_HIT_POINTS;
    private Pair<Integer, Integer> position = Pair.of(0, 0);
    private final Map<Slot, @Nullable Item> inventory = MapUtils.defaultHashMapFrom(
            Arrays.asList(Slot.values()), null
    );

    @Nullable
    private TurnConstraint turnConstraint = null;

    protected Hero() {
        super(null, null);
    }

    public void startTurn() {
        this.turnConstraint = new TurnConstraint(Hero.DEFAULT_NUMBER_OF_STEPS);
    }

    public void endTurn() {
        this.turnConstraint = null;
    }

    public Result move(
            Pair<Integer, Integer> newPosition
    ) {
        if (!isValidMove(newPosition)) return Result.withFailure(Result.Failure.INVALID_CHOICE);

        // TODO: change position + remember last position

        return Result.withSuccess();
    }

    public Result pickUpItem(
            Slot slot
    ) {
        // TODO: what if you don't want to pick up the item
        // TODO: get item
        Item item;
        return item.apply(
                weapon -> pickUpWeapon(slot, weapon),
                spell  -> pickUpSpell(slot, spell),
                key    -> pickUpKey(slot, key),
                this::pickUpChest
        );
    }

    private Result pickUpItem(
            Slot slot,
            Predicate<Slot> isSlotValid,
            Item item
    ) {
        if (!isSlotValid.test(slot)) return Result.withFailure(Result.Failure.INVALID_CHOICE);
        this.inventory.put(slot, item);
        return Result.withSuccess();
    }

    protected Result pickUpWeapon(
            Slot slot,
            Weapon weapon
    ) {
        return pickUpItem(slot, Slot::isWeaponSlot, Item.from(weapon));
    }

    protected Result pickUpSpell(
            Slot slot,
            Spell spell
    ) {
        return pickUpItem(slot, Slot::isSpellSlot, Item.from(spell));
    }

    protected Result pickUpKey(
            Slot slot,
            Key key
    ) {
        return pickUpItem(slot, (slotArg -> slotArg != Slot.KEY), Item.from(key));
    }

    protected Result pickUpChest(
            Chest chest
    ) {
        // TODO - Hero::pickUpChest
        return Result.withSuccess();
    }

    public Result useItem(
            Slot slot
    ) {
        if (Slot.isWeaponSlot(slot))          return Result.withFailure(Result.Failure.INVALID_CHOICE);
        if (this.inventory.get(slot) == null) return Result.withFailure(Result.Failure.NULL);
        // TODO: key unlocks a chest! don't forget it
        // TODO: check if spell is usable in the situation
        return Result.withSuccess();
    }

    public int getStrength() {
        int strength = 0;
        Item item;

        for (var weaponSlot : Slot.getWeaponSlots()) {
            item = this.inventory.get(weaponSlot);
            if (item != null) {
                strength += item.apply(
                        Weapon::getStrength, x -> 0, x -> 0, x -> 0
                );
            }
        }

        return strength;
    }

    protected boolean isValidMove(
            Pair<Integer, Integer> newPosition
    ) {
        return false;
    }

    protected void recover() {
        /*
        if (this.hitPoints != 0) {
            throw new HeroInvalidStateException(
                    "Cannot perform `Hero::recovery` when Hero hit points are above 0"
            );
        }
        this.hitPoints += 1;
        */
    }

    protected void retreat() {
        /*
        if (this.previousPosition == null) {
            throw new HeroInvalidStateException(
                    "Cannot retreat to an unknown previous position"
            );
        }
        this.position = this.previousPosition;
        this.previousPosition = null;
        */
    }
}
