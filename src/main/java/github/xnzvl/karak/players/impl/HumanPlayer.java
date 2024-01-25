package github.xnzvl.karak.players.impl;

import github.xnzvl.karak.players.InputResult;
import github.xnzvl.karak.players.PlayerInputHandler;
import github.xnzvl.karak.players.Player;
import github.xnzvl.karak.powerfuls.heroes.Hero;

import java.util.function.Function;

public class HumanPlayer implements Player {
    private final String name;
    private final Hero hero;
    private final PlayerInputHandler inputHandler;

    public HumanPlayer(
            String name,
            Hero hero,
            Function<Hero, PlayerInputHandler> inputHandlerConstructor
    ) {
        this.name = name;
        this.hero = hero;
        this.inputHandler = inputHandlerConstructor.apply(hero);
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
        // Hero::startTurn or smth
        while (this.inputHandler.handleInput() != InputResult.END_TURN) {

        }
        // Hero::endTurn or smth
    }
}
