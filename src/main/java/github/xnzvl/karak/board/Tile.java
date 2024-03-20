package github.xnzvl.karak.board;

import github.xnzvl.karak.items.Item;
import github.xnzvl.karak.strengthfuls.Monster;
import github.xnzvl.karak.utils.Either;
import github.xnzvl.karak.utils.Pair;
import github.xnzvl.karak.utils.Result;

import java.util.Collection;
import java.util.Set;

import org.jetbrains.annotations.Nullable;

/**
 * Game tile abstraction.
 *
 * @see Board
 * @author Jakub Nezval
 */
public interface Tile {
    /**
     * Enumeration of features that can a {@link Tile} have.
     * Features influence the importance of a {@link Tile} in a game - brings additional possibilities to the table.
     */
    enum Feature {
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
    enum Type {
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
    interface Shape {
        /**
         * @return {@link Collection} of reachable coordinates if the {@link Tile} was on [0, 0] coordinates
         * and {@link Tile#getNumberOfShifts()} = 0.
         */
        Collection<Pair<Integer, Integer>> getDefaultReachableCoordinates();
    }

    Pair<Integer, Integer> getCoordinates();

    /**
     * Together with {@link Tile.Type} forms "appearance" of the {@link Tile}.
     * It also dictates where you can go from the {@link Tile}.
     *
     * @return shape
     * @see Tile#getType()
     * @see Tile.Shape
     */
    Tile.Shape getShape();

    /**
     * Together with {@link Tile.Shape} forms "appearance" of the {@link Tile}.
     * It also dictates whether a {@link Monster} can spawn on the {@link Tile}.
     *
     * @return type
     * @see Tile#getShape()
     * @see Tile.Type
     */
    Tile.Type getType();

    /**
     * Gets number of clockwise-shifts done on this {@link Tile}.
     * Returned value is always lower than {@link Tile#getMaxNumberOfShifts()}.
     * If the {@link Tile} is not {@link Tile#isConfigured()} then 0 is used by default.
     *
     * @return how many times the {@link Tile} was shifted clock-wise
     * @see Tile#getMaxNumberOfShifts()
     */
    int getNumberOfShifts();

    /**
     * @return maximum number of clock-wise shifts possible for this {@link Tile}
     * @see Tile#getNumberOfShifts()
     */
    int getMaxNumberOfShifts();

    /**
     * @return {@link Set} of coordinates that are directly reachable from this {@link Tile}
     *         (unmodifiable)
     */
    Set<Pair<Integer, Integer>> getAccessibleCoordinates();

    /**
     * Tries to configure the {@link Tile}. However, the desired `numberOfShifts` might cause an invalid situation.
     * In that case results with a failure.
     *
     * @param reachableFrom coordinates from which the {@link Tile} must be reachable
     * @param numberOfShifts desired rotation (always lower that {@link Tile#getMaxNumberOfShifts()})
     * @return result
     * @see Result
     */
    Result setConditionalRotation(Pair<Integer, Integer> reachableFrom, int numberOfShifts);

    /**
     * @return whether the {@link Tile} was rotated - is ready to be put on a {@link Board}
     * @see Board#placeNewTileAt(Pair, Tile)
     */
    boolean isConfigured();

    @Nullable Tile.Feature getFeature();

    @Nullable Either<Monster, Item> getSubject();
    void setSubject(@Nullable Either<Monster, Item> roomSubject);
}
