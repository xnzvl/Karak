package github.xnzvl.karak.tiles;

import github.xnzvl.karak.items.Item;
import github.xnzvl.karak.powerfuls.monsters.Monster;
import github.xnzvl.karak.utils.Either;

import org.jetbrains.annotations.Nullable;

/**
 * Interface for representing tiles that are infested.
 */
public interface InfestedTile extends Tile {
    @Nullable Either<Monster, Item> getTileSubject();
    void setTileSubject(@Nullable Either<Monster, Item> roomSubject);
}
