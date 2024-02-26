package github.xnzvl.karak.tiles;

public enum TileTemplate {
    ORIGIN (Type.ROOM, Shape.X, Feature.FOUNTAIN),

    ROOM_X (Type.ROOM, Shape.X, null),
    ROOM_T (Type.ROOM, Shape.T, null),
    ROOM_L (Type.ROOM, Shape.L, null),
    ROOM_I (Type.ROOM, Shape.I, null),

    HALL_X (Type.HALL, Shape.X, null),
    HALL_T (Type.HALL, Shape.T, null),
    HALL_L (Type.HALL, Shape.L, null),
    HALL_I (Type.HALL, Shape.I, null),

    FOUNTAIN_L (Type.HALL, Shape.L, Feature.FOUNTAIN),
    PORTAL_I   (Type.HALL, Shape.I, Feature.PORTAL);

    private final Type type;
    private final Shape shape;
    private final Feature feature;

    TileTemplate(
            Type type,
            Shape shape,
            Feature feature
    ) {
        this.type = type;
        this.shape = shape;
        this.feature = feature;
    }

    public Type getType() {
        return this.type;
    }

    public Shape getShape() {
        return this.shape;
    }

    public Feature getFeature() {
        return this.feature;
    }
}
