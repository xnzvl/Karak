package github.xnzvl.karak.tiles.impl;

import github.xnzvl.karak.tiles.TileTemplate;
import github.xnzvl.karak.tiles.Rotation;
import github.xnzvl.karak.tiles.Tile;
import github.xnzvl.karak.utils.Pair;

public class TileFactory {
    public static Tile createOrigin() {
        return new VariousTile(
                Pair.of(0, 0),
                Rotation.NONE,
                TileTemplate.ORIGIN
        );
    }

    public static Tile createFromTemplate(  // TODO: is it necessary?
            Pair<Integer, Integer> coordinates,
            Rotation rotation,
            TileTemplate template
    ) {
        return new VariousTile(
                coordinates,
                rotation,
                template
        );
    }
}
