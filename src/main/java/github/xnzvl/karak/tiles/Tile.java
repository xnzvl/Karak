package github.xnzvl.karak.tiles;

import github.xnzvl.karak.utils.Pair;

import java.util.Collection;

/**
 * Interface that represents a game tile.
 *
 * @author Jakub Nezval
 */
public interface Tile {
    Pair<Integer, Integer> getCoordinates();
    TileShape getTileShape();
    TileRotation getRotation();

    /**
     * @return collection of coordinates that are reachable from this tile
     */
    Collection<Pair<Integer, Integer>> getAccessibleCoordinates();
}
