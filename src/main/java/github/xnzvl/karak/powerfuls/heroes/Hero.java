package github.xnzvl.karak.powerfuls.heroes;

import github.xnzvl.karak.exceptions.HeroInvalidStateException;
import github.xnzvl.karak.items.Item;
import github.xnzvl.karak.items.spells.Spell;
import github.xnzvl.karak.powerfuls.Power;
import github.xnzvl.karak.utils.MapUtils;
import github.xnzvl.karak.utils.Pair;

import org.jetbrains.annotations.NotNull;

import java.util.Arrays;
import java.util.Map;
import java.util.Random;

public abstract class Hero implements Power {
    protected static final int MAX_HIT_POINTS = 5;

    private int hitPoints = MAX_HIT_POINTS;

    private @NotNull Pair<Integer, Integer> position = Pair.of(0, 0);
    private Pair<Integer, Integer> previousPosition = null;

    protected final @NotNull Random randomGenerator;
    protected final @NotNull Map<Slot, Item> inventory = MapUtils.defaultHashMapFrom(
            Arrays.asList(Slot.values()), null
    );

    public Hero(
            @NotNull Random randomGenerator
    ) {
        this.randomGenerator = randomGenerator;
    }

    protected boolean isValidMove(
            @NotNull Pair<Integer, Integer> nextPosition
    ) {
        return false;
    }

    protected void pickUpItem(
            @NotNull Slot slot
    ) {

    }

    protected void recover() {
        this.hitPoints += 1;
    }

    protected void retreat() {
        if (this.previousPosition != null) {
            this.position = this.previousPosition;
            this.previousPosition = null;
        } else {
            throw new HeroInvalidStateException("Cannot retreat to an unknown previous position");
        }
    }

    protected @NotNull Pair<Integer, Integer> rollDices() {
        return Pair.of(
                this.randomGenerator.nextInt(7),
                this.randomGenerator.nextInt(7)
        );
    }

    protected void useOffensiveSpell(
            @NotNull Spell spell
    ) {

    }

    public void takeTurn() {

    }
}
