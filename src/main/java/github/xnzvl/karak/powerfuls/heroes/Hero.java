package github.xnzvl.karak.powerfuls.heroes;

import github.xnzvl.karak.items.Item;
import github.xnzvl.karak.items.spells.Spell;
import github.xnzvl.karak.items.weapons.Weapon;
import github.xnzvl.karak.powerfuls.Power;
import github.xnzvl.karak.utils.MapUtils;
import github.xnzvl.karak.utils.Pair;

import org.jetbrains.annotations.Nullable;

import java.util.Arrays;
import java.util.Map;

public class Hero implements Power {
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
        // nothing so far
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
        // TODO: get item
        // TODO: RECREATE *ITEM* (to be more like Either-ish)
        // return pickUpItem(slot, item);
    }

    private Result pickUpItem(
            Slot slot,
            Weapon weapon
    ) {
        if (!Slot.isWeaponSlot(slot)) return Result.withFailure(Result.Failure.INVALID_CHOICE);

        return Result.withSuccess();
    }

    private Result pickUpItem(
            Slot slot,
            Spell spell
    ) {
        if (!Slot.isSpellSlot(slot)) return Result.withFailure(Result.Failure.INVALID_CHOICE);

        return Result.withSuccess();
    }

    public Result useItem(
            Slot slot
    ) {
        if (Slot.isWeaponSlot(slot))          return Result.withFailure(Result.Failure.INVALID_CHOICE);
        if (this.inventory.get(slot) == null) return Result.withFailure(Result.Failure.NULL);
        // key unlocks a chest! don't forget it

        return Result.withSuccess();
    }

    public int getPower() {
        return -1;
    }

    public String getTitle() {
        return null;
    }

    public String getDetails() {
        return null;
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
