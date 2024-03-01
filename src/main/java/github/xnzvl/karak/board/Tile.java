package github.xnzvl.karak.board;

import github.xnzvl.karak.items.Item;
import github.xnzvl.karak.strengthfuls.monsters.Monster;
import github.xnzvl.karak.utils.Either;
import github.xnzvl.karak.utils.Pair;
import github.xnzvl.karak.utils.Result;

import org.jetbrains.annotations.Nullable;

import java.util.Collection;
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
     * Features influence the importance of a {@link Tile} in a game - brings additional possibilities to the table.
     */
    public enum Feature {
        /**
         * Provides healing opportunity.
         */
        FOUNTAIN,
        /**
         * Provides additional option of movement - to any other {@link Tile} with this feature.
         */
        PORTAL;
    }

    /**
     * Enumeration of types that can a {@link Tile} have.
     * Type dictates whether can a {@link Monster} spawn on the {@link Tile}.
     */
    public enum Type {
        /**
         * {@link Monster}s spawn here on discovering the {@link Tile}.
         */
        ROOM,
        /**
         * {@link Monster}s never spawn here.
         */
        HALL;
    }

    /**
     * Interface for representing a shape.
     */
    public interface Shape {
        /**
         * @return {@link Collection} of reachable coordinates if the {@link Tile} was on [0, 0] coordinates
         * and {@link Tile#getNumberOfShifts()} = 0.
         */
        Collection<Pair<Integer, Integer>> getDefaultReachableCoordinates();
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
    public abstract Tile.Shape getShape();

    /**
     * Together with {@link Tile.Type} forms "appearance" of the {@link Tile}.
     * It also dictates whether a {@link Monster} can spawn on the {@link Tile}.
     *
     * @return type
     * @see Tile#getShape()
     * @see Tile.Type
     */
    public abstract Tile.Type getType();

    /**
     * Gets number of clockwise-shifts done on this {@link Tile}.
     * Returned value is always lower than {@link Tile#getMaxNumberOfShifts()}.
     *
     * @return how many times the {@link Tile} was shifted clock-wise
     * @see Tile#getMaxNumberOfShifts()
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

    public abstract @Nullable Tile.Feature getFeature();

    public abstract @Nullable Either<Monster, Item> getSubject();
    public abstract void setSubject(@Nullable Either<Monster, Item> roomSubject);

    /**
     * @return whether the {@link Tile} was rotated - is ready to be put on a {@link Board}
     * @see Board#placeNewTileAt(Pair, Tile)
     */
    public abstract boolean isConfigured();
}
