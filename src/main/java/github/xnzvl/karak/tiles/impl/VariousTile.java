package github.xnzvl.karak.tiles.impl;

import github.xnzvl.karak.items.Item;
import github.xnzvl.karak.strengthfuls.monsters.Monster;
import github.xnzvl.karak.tiles.Tile;
import github.xnzvl.karak.tiles.Feature;
import github.xnzvl.karak.tiles.Rotation;
import github.xnzvl.karak.tiles.Shape;
import github.xnzvl.karak.tiles.Type;
import github.xnzvl.karak.utils.Buildable;
import github.xnzvl.karak.utils.Either;
import github.xnzvl.karak.utils.Pair;

import org.jetbrains.annotations.Nullable;

import java.util.Collection;

/**
 * Class for representing various tiles.
 *
 * @author Jakub Nezval
 */
public class VariousTile implements Tile {
    public static class Builder implements Buildable<VariousTile> {
        private final Pair<Integer, Integer> coordinates;
        private final Shape shape;
        private final Type type;
        private Rotation rotation = Rotation.ONE;
        private @Nullable Feature feature = null;
        private @Nullable Either<Monster, Item> subject = null;

        public Builder(
                Pair<Integer, Integer> coordinates,
                Shape shape,
                Type type
        ) {
            this.coordinates = coordinates;
            this.shape = shape;
            this.type = type;
        }

        public Pair<Integer, Integer> getCoordinates() {
            return coordinates;
        }

        public Rotation getRotation() {
            return rotation;
        }

        public Shape getShape() {
            return shape;
        }

        public Type getType() {
            return this.type;
        }

        public @Nullable Feature getFeature() {
            return feature;
        }

        public @Nullable Either<Monster, Item> getSubject() {
            return subject;
        }

        public Builder setRotation(
                Rotation rotation
        ) {
            this.rotation = rotation;
            return this;
        }

        public Builder addFeature(
                Feature feature
        ) {
            this.feature = feature;
            return this;
        }

        public Builder addSubject(
                Either<Monster, Item> subject
        ) {
            this.subject = subject;
            return this;
        }

        public VariousTile build() {
            if (this.type == Type.HALL && this.subject != null) {
                throw new RuntimeException("Invalid Tile configuration"); // TODO: better exception
            }

            return new VariousTile(this);
        }
    }

    private final Pair<Integer, Integer> coordinates;
    private final Shape shape;
    private final Rotation rotation;
    private final Type type;
    private final @Nullable Feature feature;
    private @Nullable Either<Monster, Item> subject;

    private VariousTile(
            Builder builder
    ) {
        this.coordinates = builder.coordinates;
        this.shape       = builder.getShape();
        this.rotation    = builder.getRotation();
        this.type        = builder.getType();
        this.subject     = builder.getSubject();
        this.feature     = builder.getFeature();
    }

    /**
     * Performs a clockwise shift (turn) of coordinates around the origin.
     *
     * @param coords         coordinates to shift
     * @param numberOfShifts non-negative number of shifts
     * @return shifted coordinates
     */
    private static Pair<Integer, Integer> clockwiseShift(
            Pair<Integer, Integer> coords,
            int numberOfShifts
    ) {
        int x = coords.xValue();
        int y = coords.yValue();
        int tmp;

        for (int i = 0; i < numberOfShifts; i++) {
            tmp = x;
            x = y;
            y = -tmp;
        }

        return Pair.of(x, y);
    }

    @Override
    public Collection<Pair<Integer, Integer>> getAccessibleCoordinates() {
        return this.shape.getDoorsTo().stream()
                .map(directions -> clockwiseShift(directions, this.rotation.getNumberOfShifts()))
                .map(coords -> Pair.of(
                        coords.xValue() + this.coordinates.xValue(),
                        coords.yValue() + this.coordinates.yValue())
                )
                .toList();
    }

    @Override
    public Pair<Integer, Integer> getCoordinates() {
        return this.coordinates;
    }

    @Override
    public Rotation getRotation() {
        return this.rotation;
    }

    @Override
    public Shape getShape() {
        return this.shape;
    }

    @Override
    public Type getType() {
        return this.type;
    }

    @Override
    public @Nullable Either<Monster, Item> getSubject() {
        return this.subject;
    }

    @Override
    public void setSubject(
            @Nullable Either<Monster, Item> subject
    ) {
        this.subject = subject;
    }

    @Override
    public @Nullable Feature getFeature() {
        return this.feature;
    }
}
