package github.xnzvl.karak.tiles.impl;

import github.xnzvl.karak.tiles.Tile;
import github.xnzvl.karak.tiles.TileRotation;
import github.xnzvl.karak.tiles.TileShape;
import github.xnzvl.karak.utils.Pair;

import java.util.Collection;

/**
 * Hall tile representation. There's nothing special about the tile.
 *
 * @author Jakub Nezval
 */
public class Hall implements Tile {
    private final Pair<Integer, Integer> coordinates;
    private final TileShape tileShape;
    private final TileRotation rotation;

    public Hall(
            Pair<Integer, Integer> coordinates,
            TileShape shape,
            TileRotation rotation
    ) {
        this.coordinates = coordinates;
        this.tileShape = shape;
        this.rotation = rotation;
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
        return this.tileShape.getDoorsTo().stream()
                .map(directions -> clockwiseShift(directions, this.rotation.getNumberOfShifts()))
                .map(coords -> Pair.of(
                        coords.xValue() + this.coordinates.xValue(),
                        coords.yValue() + this.coordinates.yValue())
                )
                .toList();
    }

    @Override
    public TileShape getTileShape() {
        return this.tileShape;
    }

    @Override
    public TileRotation getRotation() {
        return this.rotation;
    }
}
