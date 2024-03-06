package github.xnzvl.karak.board.impl.square;

import github.xnzvl.karak.board.Board;
import github.xnzvl.karak.board.Tile;
import github.xnzvl.karak.utils.Pair;
import github.xnzvl.karak.utils.Result;

import org.jetbrains.annotations.Nullable;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

public class SquareBoard implements Board {
    private final Map<Pair<Integer, Integer>, Tile> board = new HashMap<>();

    public SquareBoard() {
        var originCoords = Pair.of(0, 0);
        // TODO: add origin SquareTile
    }

    @Override
    public Set<Pair<Integer, Integer>> getActiveCoordinates() {
        return Collections.unmodifiableSet(this.board.keySet());
    }

    @Override
    public Result placeNewTileAt(
            Pair<Integer, Integer> coordinates,
            Tile tile
    ) {
        if (this.board.containsKey(coordinates)) return Result.withFailure(Result.Failure.INVALID_CHOICE);

        this.board.put(coordinates, tile);
        return Result.withSuccess();
    }

    @Override
    public Tile getNextTile() {
        return null;  // TODO: create random new SquareTile
    }

    @Override
    public @Nullable Tile getTileAt(
            Pair<Integer, Integer> coordinates
    ) {
        return this.board.get(coordinates);
    }

    @Override
    public Set<Pair<Integer, Integer>> getTilesWith(
            Tile.Feature feature
    ) {
        return this.board.keySet()
                .stream()
                .filter((coords) -> this.board.get(coords).getFeature() == feature)
                .collect(Collectors.toUnmodifiableSet());
    }
}
