package github.xnzvl.karak.tiles.impl;

import github.xnzvl.karak.items.Item;
import github.xnzvl.karak.strengthfuls.monsters.Monster;
import github.xnzvl.karak.tiles.TileTemplate;
import github.xnzvl.karak.tiles.Tile;
import github.xnzvl.karak.tiles.Feature;
import github.xnzvl.karak.tiles.Rotation;
import github.xnzvl.karak.tiles.Shape;
import github.xnzvl.karak.tiles.Type;
import github.xnzvl.karak.utils.Either;
import github.xnzvl.karak.utils.Pair;
import github.xnzvl.karak.utils.Result;

import org.jetbrains.annotations.Nullable;

import java.util.Collection;

/**
 * Class for representing various tiles.
 *
 * @author Jakub Nezval
 */
public class VariousTile implements Tile {
    private final Pair<Integer, Integer> coordinates;
    private final TileTemplate template;

    private @Nullable Either<Monster, Item> subject;
    private Rotation rotation;

    public VariousTile(
            Pair<Integer, Integer> coordinates,
            TileTemplate template
    ) {
        this.coordinates = coordinates;
        this.template = template;
    }

    public VariousTile(
            Pair<Integer, Integer> coordinates,
            TileTemplate template,
            Rotation rotation
    ) {
        this(coordinates, template);
        this.rotation = rotation;
    }

    public boolean isConfigured() {
        return this.rotation != null;
    }

    @Override
    public Result setConditionalRotation(
            Pair<Integer, Integer> reachableFrom,
            Rotation rotation
    ) {
        this.rotation = rotation;  // TODO: error if already configured

        if (this.getAccessibleCoordinates().contains(reachableFrom)) return Result.withSuccess();

        this.rotation = null;
        return Result.withFailure(Result.Failure.INVALID_CHOICE);
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
        return this.template
                .getShape()
                .getDoorsTo()
                .stream()
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
        return this.template.getShape();
    }

    @Override
    public Type getType() {
        return this.template.getType();
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
                    monster -> {
                        assert this.template.getType() == Type.HALL : "Monster cannot occupy a hall-type tile";
                    },
                    item    -> {}
            );
        }
        this.subject = subject;
    }

    @Override
    public @Nullable Feature getFeature() {
        return this.template.getFeature();
    }
}
