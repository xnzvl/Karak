package github.xnzvl.karak.tiles;

import github.xnzvl.karak.utils.Pair;

import org.jetbrains.annotations.NotNull;

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
    @NotNull Pair<@NotNull Integer, @NotNull Integer> getCoordinates();

    /**
     * @return collection of coordinates that are reachable from this tile
     */
    @NotNull Collection<@NotNull Pair<@NotNull Integer, @NotNull Integer>> getAccessibleCoordinates();

    /**
     * @return tile shape of the tile
     */
    @NotNull TileShape getTileShape();

    /**
     * @return rotation of the tile
     */
    @NotNull TileRotation getRotation();
}
