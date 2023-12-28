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

    @Override
    public @NotNull Pair<@NotNull Integer, @NotNull Integer> getCoordinates() {
        return this.coordinates;
    }

    @Override
    public @NotNull Collection<@NotNull Pair<@NotNull Integer, @NotNull Integer>> getAccessibleCoordinates() {
        return this.tileShape.getDoorsTo().stream()
                .map(
                        direction -> Pair.of(
                                direction.xValue() + this.coordinates.xValue(),
                                direction.yValue() + this.coordinates.yValue()
                        )
                )
                .toList();
    }

    @Override
    public @NotNull TileShape getTileShape() {
        return tileShape;
    }

    @Override
    public @NotNull TileRotation getRotation() {
        return rotation;
    }
}
