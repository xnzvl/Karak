package github.xnzvl.karak.tiles.featurableTiles;

import github.xnzvl.karak.tiles.Tile;
import org.jetbrains.annotations.NotNull;

public interface FeatureableTile extends Tile {
    @NotNull Feature getFeature();
}
