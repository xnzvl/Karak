package github.xnzvl.karak.game;

import github.xnzvl.karak.tiles.Tile;
import github.xnzvl.karak.utils.Pair;

import java.util.Map;

public interface Board {
    Map<Pair<Integer, Integer>, Tile> getBoard();

    void placeNewTile(Tile tile);
}
