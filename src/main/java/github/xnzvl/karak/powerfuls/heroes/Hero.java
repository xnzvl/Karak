package github.xnzvl.karak.powerfuls.heroes;

import github.xnzvl.karak.items.Item;
import github.xnzvl.karak.items.spells.Spell;
import github.xnzvl.karak.powerfuls.Powerful;
import github.xnzvl.karak.utils.MapUtils;
import github.xnzvl.karak.utils.Pair;

import org.jetbrains.annotations.NotNull;

import java.util.Arrays;
import java.util.Map;

public abstract class Hero implements Powerful {
    protected static final int MAX_HIT_POINTS = 5;

    private int hitPoints = MAX_HIT_POINTS;

    private Pair<Integer, Integer> position = Pair.of(0, 0);
    private Pair<Integer, Integer> lastPosition = null;

    private final Map<Slot, Item> inventory = MapUtils.defaultHashMapFrom(Arrays.asList(Slot.values()), null);

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
        this.hitPoints += 1;
    }

    protected void retreat() {
        this.position = this.lastPosition;
        this.lastPosition = null;
    }

    protected @NotNull Pair<Integer, Integer> rollDices() {
        return null;
    }

    protected void useOffensiveSpell(
            Spell spell
    ) {

    }

    public void takeTurn() {

    }
}
