package github.xnzvl.karak.powerfuls.heroes;

public class TurnConstraint {
    private int steps;
    private HeroState heroState;

    public TurnConstraint(
            int initialSteps
    ) {
        this.steps = initialSteps;
    }

    public int getSteps() {
        return this.steps;
    }

    public void setSteps(
            int steps
    ) {
        this.steps = steps;
    }

    public HeroState getHeroState() {
        return this.heroState;
    }

    public void setHeroState(
            HeroState heroState
    ) {
        this.heroState = heroState;
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

    public void setWandering() {
        this.setHeroState(HeroState.WANDERING);
    }

    public void setFighting() {
        this.setHeroState(HeroState.FIGHTING);
    }
}
