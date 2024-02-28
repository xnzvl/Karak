package github.xnzvl.karak.board;

public enum TileTemplate {
    ORIGIN (Tile.Type.ROOM, Shape.X, Tile.Feature.FOUNTAIN),

    ROOM_X (Tile.Type.ROOM, Shape.X, null),
    ROOM_T (Tile.Type.ROOM, Shape.T, null),
    ROOM_L (Tile.Type.ROOM, Shape.L, null),
    ROOM_I (Tile.Type.ROOM, Shape.I, null),

    HALL_X (Tile.Type.HALL, Shape.X, null),
    HALL_T (Tile.Type.HALL, Shape.T, null),
    HALL_L (Tile.Type.HALL, Shape.L, null),
    HALL_I (Tile.Type.HALL, Shape.I, null),

    FOUNTAIN_L (Tile.Type.HALL, Shape.L, Tile.Feature.FOUNTAIN),
    PORTAL_I   (Tile.Type.HALL, Shape.I, Tile.Feature.PORTAL);

    private final Tile.Type type;
    private final Shape shape;
    private final Tile.Feature feature;

    TileTemplate(
            Tile.Type type,
            Shape shape,
            Tile.Feature feature
    ) {
        this.type = type;
        this.shape = shape;
        this.feature = feature;
    }

    public Tile.Type getType() {
        return this.type;
    }

    public Shape getShape() {
        return this.shape;
    }

    public Tile.Feature getFeature() {
        return this.feature;
    }
}
