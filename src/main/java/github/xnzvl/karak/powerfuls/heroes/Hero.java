package github.xnzvl.karak.powerfuls.heroes;

import github.xnzvl.karak.items.Item;
import github.xnzvl.karak.powerfuls.Power;
import github.xnzvl.karak.utils.MapUtils;
import github.xnzvl.karak.utils.Pair;

import org.jetbrains.annotations.Nullable;

import java.util.Arrays;
import java.util.Map;

public abstract class Hero implements Power {
    public static final int MAX_HIT_POINTS = 5;

    private int hitPoints = MAX_HIT_POINTS;
    private Pair<Integer, Integer> position = Pair.of(0, 0);
    private final Map<Slot, Item> inventory = MapUtils.defaultHashMapFrom(
            Arrays.asList(Slot.values()), null
    );

    @Nullable
    private TurnConstraint turnConstraint = null;

    public Hero() {
        // nothing so far
    }

    public void startTurn() {

    }

    public void endTurn() {

    }

    protected boolean isValidMove(
            Pair<Integer, Integer> nextPosition
    ) {
        return false;
    }

    protected void pickUpItem(
            Slot slot
    ) {

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
