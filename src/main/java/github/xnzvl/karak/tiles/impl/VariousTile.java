package github.xnzvl.karak.tiles.impl;

import github.xnzvl.karak.items.Item;
import github.xnzvl.karak.strengthfuls.monsters.Monster;
import github.xnzvl.karak.tiles.Tile;
import github.xnzvl.karak.tiles.TileFeature;
import github.xnzvl.karak.tiles.TileRotation;
import github.xnzvl.karak.tiles.TileShape;
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
        private final TileShape shape;
        private final TileRotation rotation;
        private @Nullable TileFeature feature = null;
        private @Nullable Either<Monster, Item> subject = null;

        public Builder(
                Pair<Integer, Integer> coordinates,
                TileShape shape,
                TileRotation rotation
        ) {
            this.coordinates = coordinates;
            this.shape = shape;
            this.rotation = rotation;
        }

        public Pair<Integer, Integer> getCoordinates() {
            return coordinates;
        }

        public TileShape getShape() {
            return shape;
        }

        public TileRotation getRotation() {
            return rotation;
        }

        public @Nullable TileFeature getFeature() {
            return feature;
        }

        public @Nullable Either<Monster, Item> getSubject() {
            return subject;
        }

        public void addFeature(
                TileFeature feature
        ) {
            this.feature = feature;
        }

        public void addSubject(
                Either<Monster, Item> subject
        ) {
            this.subject = subject;
        }

        public VariousTile build() {
            return new VariousTile(this);
        }
    }

    private final Pair<Integer, Integer> coordinates;
    private final TileShape shape;
    private final TileRotation rotation;
    private final @Nullable TileFeature feature;
    private @Nullable Either<Monster, Item> subject;

    private VariousTile(
            Builder builder
    ) {
        this.coordinates = builder.getCoordinates();
        this.shape       = builder.getShape();
        this.rotation    = builder.getRotation();
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
    private Pair<Integer, Integer> clockwiseShift(
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
    public Pair<Integer, Integer> getCoordinates() {
        return this.coordinates;
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
    public TileShape getShape() {
        return this.shape;
    }

    @Override
    public TileRotation getRotation() {
        return this.rotation;
    }

    @Override
    public @Nullable Either<Monster, Item> getTileSubject() {
        return this.subject;
    }

    @Override
    public void setTileSubject(
            @Nullable Either<Monster, Item> subject
    ) {
        this.subject = subject;
    }

    @Override
    public @Nullable TileFeature getFeature() {
        return this.feature;
    }
}
