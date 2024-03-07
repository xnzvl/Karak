package github.xnzvl.karak.board;

import github.xnzvl.karak.utils.Pair;
import github.xnzvl.karak.utils.Result;

import org.jetbrains.annotations.Nullable;

import java.util.Collection;

/**
 * Game board of {@link Tile}s abstraction.
 *
 * @author Jakub Nezval
 */
public interface Board {
    /**
     * @return {@link Collection} of coordinates that currently contain a {@link Tile}
     */
    Collection<Pair<Integer, Integer>> getActiveCoordinates();

    /**
     * Tries to place a {@link Tile} at given coordinates. Result of the attempt is returned.
     *
     * @param coordinates target coordinates
     * @param tile new {@link Tile}
     * @return {@link Result}
     */
    Result placeNewTileAt(Pair<Integer, Integer> coordinates, Tile tile);

    /**
     * @param coordinates target coordinates
     * @return {@link Tile} on the given coordinates
     */
    @Nullable Tile getTileAt(Pair<Integer, Integer> coordinates);

    /**
     * @param feature desired {@link Tile.Feature}
     * @return {@link Collection} of {@link Tile}s with the desired {@link Tile.Feature}
     */
    Collection<Pair<Integer, Integer>> getTilesWith(Tile.Feature feature);
}
