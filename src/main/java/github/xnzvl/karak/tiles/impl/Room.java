package github.xnzvl.karak.tiles.impl;

import github.xnzvl.karak.items.Item;
import github.xnzvl.karak.powerfuls.monsters.Monster;
import github.xnzvl.karak.tiles.TileRotation;
import github.xnzvl.karak.tiles.TileShape;
import github.xnzvl.karak.tiles.InfestedTile;
import github.xnzvl.karak.utils.Either;
import github.xnzvl.karak.utils.Pair;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/**
 * Room tile representation. Room is a hall that has an extra `subject` on top of that.
 * Subject is either {@link Monster}, {@link Item} or `null`.
 *
 * @author Jakub Nezval
 */
public class Room extends Hall implements InfestedTile {
    @Nullable Either<Monster, Item> roomSubject;

    /**
     * @param coordinates coordinates of the tile
     * @param shape       shape of the tile
     * @param rotation    rotation of the tile
     * @param roomSubject room subject
     */
    public Room(
            Pair<Integer, Integer> coordinates,
            TileShape shape,
            TileRotation rotation,
            @NotNull Either<Monster, Item> roomSubject
    ) {
        super(coordinates, shape, rotation);
        this.roomSubject = roomSubject;
    }

    @Override
    public @Nullable Either<Monster, Item> getTileSubject() {
        return this.roomSubject;
    }

    @Override
    public void setTileSubject(
            @Nullable Either<Monster, Item> roomSubject
    ) {
        this.roomSubject = roomSubject;
    }
}
