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
     */
    private enum State {
        WANDERING,
        FIGHTING,
        EXHAUSTED;
    }

    private int steps = Hero.DEFAULT_NUMBER_OF_STEPS;
    private State state = State.WANDERING;
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
        return this.steps > 0 && this.state == State.WANDERING;
    }

    /**
     * Safely subtracts one step.
     */
    public void lowerSteps() {
        if (this.steps < 1 || this.state == State.FIGHTING) {
            // TODO: throw error
        }
        this.steps -= 1;
    }

    private void setState(
            TurnState.State state
    ) {
        this.state = state;
    }

    public void setHeroWandering() {
        this.setState(State.WANDERING);
    }

    public void setHeroFighting() {
        this.setState(State.FIGHTING);
    }

    public void setHeroExhausted() {
        this.setState(State.EXHAUSTED);
    }

    public boolean isHeroWandering() {
        return this.state == State.WANDERING;
    }

    public boolean isHeroFighting() {
        return this.state == State.FIGHTING;
    }

    public boolean isHeroExhausted() {
        return this.state == State.EXHAUSTED;
    }
}
