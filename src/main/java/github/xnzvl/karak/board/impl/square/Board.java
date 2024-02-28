package github.xnzvl.karak.board.impl.square;

import github.xnzvl.karak.board.Rotation;
import github.xnzvl.karak.board.Tile;
import github.xnzvl.karak.board.TileTemplate;
import github.xnzvl.karak.utils.Pair;
import github.xnzvl.karak.utils.Result;

import org.jetbrains.annotations.Nullable;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * Class for representing board of {@link Tile}s.
 *
 * @author Jakub Nezval
 */
public class Board {  // TODO: rename to SquareBoard and create a Board interface
    private final Map<Pair<Integer, Integer>, Tile> board = new HashMap<>();

    private Board() {
        var originCoords = Pair.of(0,0);
        this.board.put(originCoords, new SquareTile(originCoords, TileTemplate.ORIGIN, Rotation.NONE));
    }

    public Set<Pair<Integer, Integer>> getOccupiedCoordinates() {
        return Collections.unmodifiableSet(this.board.keySet());
    }

    public TileTemplate getNextTileTemplate() {
        // TODO: implementation
        return null;
    }

    /**
     * @param coordinates coordinates that should be associated with {@link Tile}
     * @return {@link Tile} located at given coordinates (null if there isn't any)
     */
    public @Nullable Tile getTileAt(
            Pair<Integer, Integer> coordinates
    ) {
        return this.board.get(coordinates);
    }

    // TODO: fix javadoc
    /**
     * Places new {@link Tile} at coordinates.
     * If coordinates are already occupied, does nothing and results with {@link Result#withFailure(Result.Failure)}
     * otherwise results with {@link Result#withSuccess()}
     *
     * @param coordinates coordinates where to place the tile
     * @return result
     * @see Result
     */
    public Result placeNewTileAt(
            Pair<Integer, Integer> coordinates,
            Tile tile
    ) {
        if (this.board.containsKey(coordinates)) return Result.withFailure(Result.Failure.INVALID_CHOICE);
        this.board.put(coordinates, tile);
        return Result.withSuccess();
    }

    /**
     * Obtain coordinates of existing tiles (at the moment of calling this method)
     * that have the desired {@link Tile.Feature}.
     *
     * @param feature looking for tiles with this {@link Tile.Feature}
     * @return unmodifiable {@link Set} of coordinates with the desired {@link Tile}s
     */
    public Set<Pair<Integer, Integer>> getTilesWith(
            Tile.Feature feature
    ) {
        return this.board.keySet()
                .stream()
                .filter((coords) -> this.board.get(coords).getFeature() == feature)
                .collect(Collectors.toUnmodifiableSet());
    }
}
