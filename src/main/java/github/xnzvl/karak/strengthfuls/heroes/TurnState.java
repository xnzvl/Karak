package github.xnzvl.karak.strengthfuls.heroes;

import github.xnzvl.karak.utils.Pair;

import org.jetbrains.annotations.Nullable;

/**
 * Class for holding additional state variables during {@link Hero}'s turn.
 *
 * @see Hero#startTurn()
 * @see Hero#endTurn()
 * @author Jakub Nezval
 */
public class TurnState {  // TODO: maybe package private?
    /**
     * Auxiliary enumeration for holding {@link Hero}'s state.
     * It is better than {@link Boolean} values.
     */
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

    /**
     * @return boolean value whether the {@link Hero} is able to move and has steps at the same time
     */
    public boolean canMove() {
        return this.steps > 0 && this.heroState == HeroState.WANDERING;
    }

    /**
     * Safely subtracts one step.
     */
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

    /**
     * Sets {@link Hero} into wandering state.
     * In wandering state {@link Hero} can use only utility spells and can move freely.
     *
     * @see TurnState#setHeroFighting()
     */
    public void setHeroWandering() {
        this.heroState = HeroState.WANDERING;
    }

    /**
     * Sets {@link Hero} into fighting state.
     * In fighting state {@link Hero} can use only offensive spells and cannot move until the fight is over.
     *
     * @see TurnState#setHeroWandering()
     */
    public void setHeroFighting() {
        this.heroState = HeroState.FIGHTING;
    }
}
