package github.xnzvl.karak.board;

import github.xnzvl.karak.items.Item;
import github.xnzvl.karak.strengthfuls.monsters.Monster;
import github.xnzvl.karak.utils.Either;
import github.xnzvl.karak.utils.Pair;
import github.xnzvl.karak.utils.Result;

import org.jetbrains.annotations.Nullable;

import java.util.Collection;

/**
 * Interface that represents a game tile.
 *
 * @author Jakub Nezval
 */
public abstract class Tile {
    public enum Feature {
        FOUNTAIN,
        PORTAL;
    }

    public enum Type {
        ROOM,
        HALL;
    }

    public abstract Pair<Integer, Integer> getCoordinates();
    public abstract Shape getShape();
    public abstract Rotation getRotation();
    public abstract Type getType();

    public abstract Result setConditionalRotation(Pair<Integer, Integer> reachableFrom, Rotation rotation);

    public abstract @Nullable Feature getFeature();
    public abstract @Nullable Either<Monster, Item> getSubject();

    public abstract void setSubject(@Nullable Either<Monster, Item> roomSubject);

    /**
     * @return {@link Collection} of coordinates that are reachable from this {@link Tile}
     * @see Pair
     */
    public abstract Collection<Pair<Integer, Integer>> getAccessibleCoordinates();
}
