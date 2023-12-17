package github.xnzvl.karak.tiles;

import github.xnzvl.karak.utils.Pair;

import java.util.Collection;

public interface Tile {
    Collection<Pair<Integer, Integer>> getAccessibleTiles();
    TileShape getTileShape();
    Rotation getRotation();
}
