package github.xnzvl.karak.players;

import github.xnzvl.karak.powerfuls.heroes.Hero;

/**
 * Class representing a player.
 *
 * @author Jakub Nezval
 */
public interface Player {
    /**
     * @return name of the Player
     */
    String getName();

    /**
     * @return Player's hero
     */
    Hero getHero();

    /**
     * This function represents taking a turn.
     * It allows the player to play and to make decisions.
     */
    void takeTurn();
}
