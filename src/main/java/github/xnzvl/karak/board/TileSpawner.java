package github.xnzvl.karak.board;

public interface TileSpawner {
    /**
     * @return new unconfigured {@link Tile} instance
     * @see Tile#isConfigured()
     */
    Tile getNextTile();
}
