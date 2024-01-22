package github.xnzvl.karak.players.impl;

import github.xnzvl.karak.players.InteractionDelegate;
import github.xnzvl.karak.players.Player;
import github.xnzvl.karak.powerfuls.heroes.Hero;

public class HumanPlayer implements Player {
    private final String name;
    private final Hero hero;
    private final InteractionDelegate interactionDelegate;

    public HumanPlayer(
            String name,
            Hero hero,
            InteractionDelegate interactionDelegate
    ) {
        this.name = name;
        this.hero = hero;
        this.interactionDelegate = interactionDelegate;
    }

    @Override
    public String getName() {
        return this.name;
    }

    @Override
    public Hero getHero() {
        return this.hero;
    }

    @Override
    public void takeTurn() {
        // create TurnState
        // do while doAction
    }
}
