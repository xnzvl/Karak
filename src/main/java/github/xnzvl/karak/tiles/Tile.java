package github.xnzvl.karak.tiles;

import github.xnzvl.karak.items.Item;
import github.xnzvl.karak.strengthfuls.monsters.Monster;
import github.xnzvl.karak.utils.Either;
import github.xnzvl.karak.utils.Pair;

import org.jetbrains.annotations.Nullable;

import java.util.Collection;

/**
 * Interface that represents a game tile.
 *
 * @author Jakub Nezval
 */
public interface Tile {
    Pair<Integer, Integer> getCoordinates();
    TileShape getShape();
    TileRotation getRotation();

    @Nullable Either<Monster, Item> getTileSubject();
    void setTileSubject(@Nullable Either<Monster, Item> roomSubject);

    @Nullable TileFeature getFeature();

    /**
     * @return {@link Collection} of coordinates that are reachable from this {@link Tile}
     * @see Pair
     */
    Collection<Pair<Integer, Integer>> getAccessibleCoordinates();
}
