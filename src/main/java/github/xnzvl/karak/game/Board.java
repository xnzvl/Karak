package github.xnzvl.karak.game;

import github.xnzvl.karak.tiles.Tile;
import github.xnzvl.karak.utils.Pair;

import org.jetbrains.annotations.NotNull;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/**
 * Class for representing board of {@link Tile}s.
 *
 * @author Jakub Nezval
 */
public class Board {
    private static final Board instance = new Board();

    /**
     * Method for obtaining singleton instance of this class.
     *
     * @return singleton instance of the class
     */
    public static @NotNull Board getInstance() {
        return instance;
    }

    private final Map<Pair<Integer, Integer>, Tile> board = new HashMap<>();
    private Board() {
        // TODO: place fountain tiles at [0, 0]
    }

    /**
     * @return unmodifiable map of coordinates to tiles
     */
    public @NotNull Map<@NotNull Pair<@NotNull Integer, @NotNull Integer>, @NotNull Tile> getBoard() {
        return Collections.unmodifiableMap(this.board);
    }

    /**
     * Places new ⟨tile⟩ at ⟨coordinates⟩.
     * If ⟨coordinates⟩ are already occupied, does nothing and returns `false`
     * otherwise returns `true`.
     *
     * @param tile new tile
     * @param coordinates coordinates where to place the tile
     * @return `true` on success, otherwise `false`
     */
    public boolean placeNewTile(
            @NotNull Tile tile,
            @NotNull Pair<@NotNull Integer, @NotNull Integer> coordinates
    ) {
        if (this.board.containsKey(coordinates)) return false;

        this.board.put(coordinates, tile);
        return true;
    }

    // TODO: FEATURE TILES

    /**
     * @return set of coordinates on which the fountains are located
     */
    public @NotNull Set<@NotNull Pair<@NotNull Integer, @NotNull Integer>> getFountainCoords() {
        return null;
    }

    /**
     * @return set of coordinates on which the portals are located
     */
    public @NotNull Set<@NotNull Pair<@NotNull Integer, @NotNull Integer>> getPortalCoords() {
        return null;
    }
}
