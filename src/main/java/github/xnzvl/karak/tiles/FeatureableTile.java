package github.xnzvl.karak.tiles;

import org.jetbrains.annotations.NotNull;

public interface FeatureableTile extends Tile {
    @NotNull Feature getFeature();
}
