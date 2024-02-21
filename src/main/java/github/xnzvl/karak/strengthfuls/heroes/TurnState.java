package github.xnzvl.karak.strengthfuls.heroes;

import github.xnzvl.karak.utils.Pair;

import org.jetbrains.annotations.Nullable;

public class TurnState {  // TODO: maybe package private?
    private enum HeroState {
        WANDERING,
        FIGHTING;
    }

    private int steps = Hero.DEFAULT_NUMBER_OF_STEPS;
    private HeroState heroState = HeroState.WANDERING;
    private Pair<Integer, Integer> prevPosition;

    public int getSteps() {
        return this.steps;
    }

    public void setSteps(
            int steps
    ) {
        this.steps = steps;
    }

    @Nullable
    public Pair<Integer, Integer> getPrevPosition() {
        return prevPosition;
    }

    public void setPrevPosition(
            Pair<Integer, Integer> prevPosition
    ) {
        this.prevPosition = prevPosition;
    }

    public boolean canMove() {
        return this.steps > 0 && this.heroState == HeroState.WANDERING;
    }

    public void lowerSteps() {
        if (this.steps < 1 || this.heroState == HeroState.FIGHTING) {
            // TODO: throw error
        }
        this.steps -= 1;
    }

    public boolean isHeroWandering() {
        return this.heroState == HeroState.WANDERING;
    }

    public boolean isHeroFighting() {
        return this.heroState == HeroState.FIGHTING;
    }

    public void setHeroWandering() {
        this.heroState = HeroState.WANDERING;
    }

    public void setHeroFighting() {
        this.heroState = HeroState.FIGHTING;
    }
}
