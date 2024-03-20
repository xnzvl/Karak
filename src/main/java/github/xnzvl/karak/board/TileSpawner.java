package github.xnzvl.karak.board;

import org.jetbrains.annotations.Nullable;

public interface TileSpawner {
    /**
     * Returns a new unconfigured {@link Tile}.
     * If the spawner is exhaustible it returns `null` after the last {@link Tile}.
     *
     * @return {@link Tile} instance
     * @see Tile#isConfigured()
     */
    @Nullable
    Tile getNextTile();
}
