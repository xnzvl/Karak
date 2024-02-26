package github.xnzvl.karak.tiles.impl;

import github.xnzvl.karak.tiles.Configuration;
import github.xnzvl.karak.tiles.Rotation;
import github.xnzvl.karak.tiles.Tile;
import github.xnzvl.karak.tiles.Feature;
import github.xnzvl.karak.tiles.Shape;
import github.xnzvl.karak.tiles.Type;
import github.xnzvl.karak.utils.Pair;

public class TileFactory {
    public static Tile createOrigin() {
        return new VariousTile
                .Builder(Pair.of(0, 0), Shape.X, Type.ROOM)
                .addFeature(Feature.FOUNTAIN)
                .build();
    }

    public static Tile createFromConfiguration(
            Pair<Integer, Integer> coordinates,
            Configuration configuration,
            Rotation rotation
    ) {
        return new VariousTile.Builder(
                        coordinates,
                        configuration
                )
                .setRotation(rotation)
                .build();
    }
}
