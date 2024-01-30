package github.xnzvl.karak.powerfuls.heroes;

import github.xnzvl.karak.items.Item;
import github.xnzvl.karak.items.spells.Spell;
import github.xnzvl.karak.items.weapons.Weapon;
import github.xnzvl.karak.powerfuls.Power;
import github.xnzvl.karak.utils.MapUtils;
import github.xnzvl.karak.utils.Pair;
import github.xnzvl.karak.utils.Result;

import org.jetbrains.annotations.Nullable;

import java.util.Arrays;
import java.util.Map;

public class Hero implements Power {
    public static final int MAX_HIT_POINTS = 5;
    public static final int DEFAULT_NUMBER_OF_STEPS = 4;

    private int hitPoints = MAX_HIT_POINTS;
    private Pair<Integer, Integer> position = Pair.of(0, 0);
    private final Map<Slot, Item> inventory = MapUtils.defaultHashMapFrom(
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
        if (!isValidMove(newPosition)) return Result.FAILURE;

        // TODO: change position + remember last position

        return Result.SUCCESS;
    }

    public Result pickUpItem() {

    }

    public Result pickUpItem(
            @Nullable Slot slot
    ) {

    }

    private Result pickUpItem(
            Slot slot,
            Weapon weapon
    ) {

    }

    private Result pickUpItem(
            Slot slot,
            Spell spell
    ) {

    }

    public Result useItem(
            Slot slot
    ) {

    }

    public int getPower() {

    }

    public String getTitle() {

    }

    public String getDetails() {

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
