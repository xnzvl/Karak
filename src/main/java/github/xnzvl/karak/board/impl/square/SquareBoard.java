package github.xnzvl.karak.board.impl.square;

import github.xnzvl.karak.board.Board;
import github.xnzvl.karak.board.Tile;
import github.xnzvl.karak.utils.Pair;
import github.xnzvl.karak.utils.Result;

import org.jetbrains.annotations.Nullable;

import java.util.Set;

public class SquareBoard implements Board {
    @Override
    public Set<Pair<Integer, Integer>> getActiveCoordinates() {
        return null;
    }

    @Override
    public Result placeNewTileAt(Pair<Integer, Integer> coordinates, Tile tile) {
        return null;
    }

    @Override
    public Tile getNextTile() {
        return null;
    }

    @Override
    public @Nullable Tile getTileAt(Pair<Integer, Integer> coordinates) {
        return null;
    }

    @Override
    public Set<Pair<Integer, Integer>> getTilesWith(Tile.Feature feature) {
        return null;
    }
}
