package github.xnzvl.karak.board;

import github.xnzvl.karak.utils.Pair;
import github.xnzvl.karak.utils.Result;

import org.jetbrains.annotations.Nullable;

import java.util.Set;

/**
 * Game board of {@link Tile}s abstraction.
 *
 * @author Jakub Nezval
 */
public interface Board {
    /**
     * @return {@link Set} of coordinates that currently contain a {@link Tile}
     */
    Set<Pair<Integer, Integer>> getActiveCoordinates();

    /**
     * Tries to place a {@link Tile} at given coordinates. Result of the attempt is returned.
     *
     * @param coordinates target coordinates
     * @param tile new {@link Tile}
     * @return {@link Result}
     */
    Result placeNewTileAt(Pair<Integer, Integer> coordinates, Tile tile);

    /**
     * @return new unconfigured {@link Tile} instance
     * @see Tile#isConfigured()
     */
    Tile getNextTile();  // TODO: Tile interface dependency

    /**
     * @param coordinates target coordinates
     * @return {@link Tile} on the given coordinates
     */
    @Nullable Tile getTileAt(Pair<Integer, Integer> coordinates);

    /**
     * @param feature desired {@link Tile.Feature}
     * @return {@link Set} of {@link Tile}s with the desired {@link Tile.Feature}
     */
    Set<Pair<Integer, Integer>> getTilesWith(Tile.Feature feature);
}
