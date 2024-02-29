package github.xnzvl.karak.board;

import github.xnzvl.karak.items.Item;
import github.xnzvl.karak.strengthfuls.monsters.Monster;
import github.xnzvl.karak.utils.Either;
import github.xnzvl.karak.utils.Pair;
import github.xnzvl.karak.utils.Result;

import org.jetbrains.annotations.Nullable;

import java.util.Set;

/**
 * Abstract class that represents a game tile.
 *
 * @see Board
 * @author Jakub Nezval
 */
public abstract class Tile {
    /**
     * Enumeration of features that can a {@link Tile} have.
     */
    public enum Feature {
        FOUNTAIN,
        PORTAL;
    }

    /**
     * Enumeration of types that can a {@link Tile} have.
     */
    public enum Type {
        ROOM,
        HALL;
    }

    public abstract Pair<Integer, Integer> getCoordinates();

    /**
     * Together with {@link Tile.Type} forms "appearance" of the {@link Tile}.
     * It also dictates where you can go from the {@link Tile}.
     *
     * @return shape
     * @see Tile#getType()
     * @see Tile.Shape
     */
    public abstract Shape getShape();  // TODO: Shape maybe should be an inner class of Tile

    /**
     * Together with {@link Tile.Type} forms "appearance" of the {@link Tile}.
     * It also dictates whether a {@link Monster} can spawn on the {@link Tile}.
     *
     * @return type
     * @see Tile#getShape()
     * @see Tile.Type
     */
    public abstract Type getType();

    /**
     * @return how many times the {@link Tile} was shifted clock-wise
     */
    public abstract int getNumberOfShifts();

    /**
     * @return maximum number of clock-wise shifts possible for this {@link Tile}
     * @see Tile#getNumberOfShifts()
     */
    public abstract int getMaxNumberOfShifts();

    /**
     * @return {@link Set} of coordinates that are directly reachable from this {@link Tile}
     */
    public abstract Set<Pair<Integer, Integer>> getAccessibleCoordinates();

    /**
     * Tries to configure the {@link Tile}. However, the desired `numberOfShifts` might cause an invalid situation.
     * In that case results with a failure.
     *
     * @param reachableFrom coordinates from which the {@link Tile} must be reachable
     * @param numberOfShifts desired rotation
     * @return result
     * @see Result
     */
    public abstract Result setConditionalRotation(Pair<Integer, Integer> reachableFrom, int numberOfShifts);

    public abstract @Nullable Feature getFeature();

    public abstract @Nullable Either<Monster, Item> getSubject();
    public abstract void setSubject(@Nullable Either<Monster, Item> roomSubject);

    /**
     * @return whether the {@link Tile} was rotated - is ready to be put on a {@link Board}
     * @see Board#placeNewTileAt(Pair, Tile)
     */
    public abstract boolean isConfigured();
}
