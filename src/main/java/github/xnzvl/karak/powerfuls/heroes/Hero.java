package github.xnzvl.karak.powerfuls.heroes;

import github.xnzvl.karak.exceptions.HeroInvalidStateException;
import github.xnzvl.karak.players.TurnState;
import github.xnzvl.karak.items.Item;
import github.xnzvl.karak.powerfuls.Power;
import github.xnzvl.karak.utils.MapUtils;
import github.xnzvl.karak.utils.Pair;

import java.util.Arrays;
import java.util.Map;
import java.util.Random;

public abstract class Hero implements Power {
    protected static final int MAX_HIT_POINTS = 5;

    private int hitPoints = MAX_HIT_POINTS;

    private Pair<Integer, Integer> position = Pair.of(0, 0);
    private Pair<Integer, Integer> previousPosition = null;

    protected final Random randomGenerator;
    protected final Map<Slot, Item> inventory = MapUtils.defaultHashMapFrom(
            Arrays.asList(Slot.values()), null
    );

    public Hero(
            Random randomGenerator
    ) {
        this.randomGenerator = randomGenerator;
    }

    protected boolean isValidMove(
            Pair<Integer, Integer> nextPosition
    ) {
        return false;
    }

    protected void pickUpItem(
            Item item,
            TurnState turnState
    ) {

    }

    protected void recover() {
        if (this.hitPoints != 0) {
            throw new HeroInvalidStateException(
                    "Cannot perform `Hero::recovery` when Hero hit points are above 0"
            );
        }
        this.hitPoints += 1;
    }

    protected void retreat() {
        if (this.previousPosition == null) {
            throw new HeroInvalidStateException(
                    "Cannot retreat to an unknown previous position"
            );
        }
        this.position = this.previousPosition;
        this.previousPosition = null;
    }

    protected Pair<Integer, Integer> rollDices() {
        return Pair.of(
                this.randomGenerator.nextInt(7),
                this.randomGenerator.nextInt(7)
        );
    }
}
