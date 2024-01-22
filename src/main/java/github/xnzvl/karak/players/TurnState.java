package github.xnzvl.karak.players;

public class TurnState {
    private int steps;
    private boolean hasTurnEndedEarly = false;

    public TurnState(
            int initialSteps
    ) {
        this.steps = initialSteps;
    }

    public int getSteps() {
        return this.steps;
    }

    public void minusStep() {
        this.steps -= 1;
    }

    public void endTurnEarly() {
        this.hasTurnEndedEarly = true;
    }

    public boolean isTurnInProgress() {
        return steps > 0 && !hasTurnEndedEarly;
    }
}
