package github.xnzvl.karak.tiles;

import github.xnzvl.karak.utils.Pair;

import java.util.Collection;

/**
 * Interface that represents a game tile.
 *
 * @author Jakub Nezval
 */
public interface Tile {
    /**
     * @return get coordinates of the tile
     */
    Pair<Integer, Integer> getCoordinates();

    /**
     * @return collection of coordinates that are reachable from this tile
     */
    Collection<Pair<Integer, Integer>> getAccessibleCoordinates();

    /**
     * @return tile shape of the tile
     */
    TileShape getTileShape();

    /**
     * @return rotation of the tile
     */
    TileRotation getRotation();
}
