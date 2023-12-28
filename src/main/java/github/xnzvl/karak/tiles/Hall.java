package github.xnzvl.karak.tiles;

import github.xnzvl.karak.utils.Pair;

import org.jetbrains.annotations.NotNull;

import java.util.Collection;

/**
 * Class for representing hall tile. There's nothing special about the tile.
 *
 * @author Jakub Nezval
 */
public class Hall implements Tile {
    private final @NotNull Pair<Integer, Integer> coordinates;
    private final @NotNull TileShape tileShape;
    private final @NotNull TileRotation rotation;

    /**
     * @param coordinates coordinates of the tile
     * @param tileShape tile shape of the tile
     * @param rotation rotation of the tile
     */
    public Hall(
            @NotNull Pair<Integer, Integer> coordinates,
            @NotNull TileShape tileShape,
            @NotNull TileRotation rotation
    ) {
        this.coordinates = coordinates;
        this.tileShape = tileShape;
        this.rotation = rotation;
    }

    /**
     * Performs a clockwise shift (turn) of coordinates around the origin.
     *
     * @param coords coordinates to shift
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
    public @NotNull Pair<@NotNull Integer, @NotNull Integer> getCoordinates() {
        return this.coordinates;
    }

    @Override
    public @NotNull Collection<@NotNull Pair<@NotNull Integer, @NotNull Integer>> getAccessibleCoordinates() {
        return this.tileShape.getDoorsTo().stream()
                .map(directions -> Pair.of(
                        directions.xValue(),
                        directions.yValue())
                )
                .map(coords -> Pair.of(
                        coords.xValue() + this.coordinates.xValue(),
                        coords.yValue() + this.coordinates.yValue())
                )
                .toList();
    }

    @Override
    public @NotNull TileShape getTileShape() {
        return this.tileShape;
    }

    @Override
    public @NotNull TileRotation getRotation() {
        return this.rotation;
    }
}
