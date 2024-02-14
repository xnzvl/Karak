package github.xnzvl.karak.game;

import github.xnzvl.karak.players.Player;
import github.xnzvl.karak.strengthfuls.heroes.Hero;

import java.util.Collections;
import java.util.List;

public class GameState {
    private static final GameState instance = new GameState();

    public static GameState getInstance() {
        return instance;
    }

    private final List<Player> players;
    private Hero cursedHero;

    private GameState(
            List<Player> players
    ) {
        this.players = players;
    }

    public List<Player> getPlayers() {
        return Collections.unmodifiableList(players);
    }

    public List<Hero> getHeroes() {
        return players.stream()
                .map(Player::getHero)
                .toList();
    }

    public void curseHero(
            Hero target
    ) {
        if (this.cursedHero != null) {
            this.cursedHero.cleanseCurse();
        }
        this.cursedHero = target;
        target.acceptCurse();
    }
}
