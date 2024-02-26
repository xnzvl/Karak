package github.xnzvl.karak.tiles.impl;

import github.xnzvl.karak.items.Item;
import github.xnzvl.karak.strengthfuls.monsters.Monster;
import github.xnzvl.karak.tiles.TileTemplate;
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
    private final Pair<Integer, Integer> coordinates;
    private final Shape shape;
    private final Rotation rotation;
    private final Type type;
    private final @Nullable Feature feature;
    private @Nullable Either<Monster, Item> subject;

    public VariousTile(
            Pair<Integer, Integer> coordinates,
            Rotation rotation,
            Shape shape,
            Type type,
            @Nullable Feature feature
    ) {
        this.coordinates = coordinates;
        this.rotation    = rotation;
        this.shape   = shape;
        this.type    = type;
        this.feature = feature;
    }

    public VariousTile(
            Pair<Integer, Integer> coordinates,
            Rotation rotation,
            TileTemplate template
    ) {
        this.coordinates = coordinates;
        this.rotation    = rotation;
        this.shape   = template.getShape();
        this.type    = template.getType();
        this.feature = template.getFeature();
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
        if (subject != null) {
            subject.consume(
                    monster -> { assert this.type == Type.HALL : "Monster cannot occupy a hall-type tile"; },
                    item    -> {}
            );
        }
        this.subject = subject;
    }

    @Override
    public @Nullable Feature getFeature() {
        return this.feature;
    }
}
