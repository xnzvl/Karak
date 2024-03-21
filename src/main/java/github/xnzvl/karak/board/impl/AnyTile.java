package github.xnzvl.karak.board.impl;

import github.xnzvl.karak.board.Tile;
import github.xnzvl.karak.items.Item;
import github.xnzvl.karak.strengthfuls.Monster;
import github.xnzvl.karak.utils.Either;
import github.xnzvl.karak.utils.Pair;
import github.xnzvl.karak.utils.Result;

import java.util.Set;
import java.util.stream.Collectors;

import org.jetbrains.annotations.Nullable;

public abstract class AnyTile implements Tile {  // TODO: javadoc
    private final Pair<Integer, Integer> coordinates;
    private final Layout layout;
    private final Tile.Type type;
    private final Tile.Shape shape;
    @Nullable
    private final Tile.Feature feature;

    @Nullable
    private Integer numberOfShifts;
    @Nullable
    private Either<Monster, Item> subject;

    public AnyTile(  // TODO: javadoc
                     Pair<Integer, Integer> coordinates,
                     Layout layout,
                     Tile.Type type,
                     @Nullable Tile.Feature feature,
                     Tile.Shape shape
    ) {
        this.coordinates = coordinates;
        this.layout = layout;
        this.type = type;
        this.feature = feature;
        this.shape = shape;
    }

    /**
     * Performs a clockwise-shift on the given coordinates.
     *
     * @param coordinates coordinates to shift
     * @param numberOfShifts number of shifts
     * @return shifted coordinates
     */
    protected abstract Pair<Integer, Integer> clockwiseShift(
            Pair<Integer, Integer> coordinates,
            int numberOfShifts
    );

    // TODO: javadoc
    protected int safeGetNumberOfShifts() {
        return this.numberOfShifts == null ? 0 : numberOfShifts;
    }

    @Override
    public int getNumberOfShifts() {
        return this.safeGetNumberOfShifts();
    }

    @Override
    public int getMaxNumberOfShifts() {
        return this.shape.getMaxNumberOfShifts();
    }

    @Override
    public Set<Pair<Integer, Integer>> getAccessibleCoordinates() {
        return this.getLayout()
                .getDefaultReachableCoordinates()
                .stream()
                .map(reachable -> clockwiseShift(reachable, this.safeGetNumberOfShifts()))
                .map(coords -> Pair.of(
                        this.coordinates.xValue() + coords.xValue(),
                        this.coordinates.yValue() + coords.yValue()
                ))
                .collect(Collectors.toUnmodifiableSet());
    }

    @Override
    public Result setConditionalRotation(
            Pair<Integer, Integer> reachableFrom,
            int numberOfShifts
    ) {
        assert numberOfShifts < this.getMaxNumberOfShifts() : "number of shifts >= max number of shifts";

        if (this.numberOfShifts != null) return Result.withFailure(Result.Failure.NOT_ALLOWED);

        this.numberOfShifts = numberOfShifts;
        if (this.getAccessibleCoordinates().contains(reachableFrom)) return Result.withSuccess();

        this.numberOfShifts = null;
        return Result.withFailure(Result.Failure.INVALID_CHOICE);
    }

    @Override
    public Pair<Integer, Integer> getCoordinates() {
        return this.coordinates;
    }

    @Override
    public Type getType() {
        return this.type;
    }

    @Override
    public Layout getLayout() {
        return this.layout;
    }

    @Override
    public Shape getShape() {
        return this.shape;
    }

    @Override
    public boolean isConfigured() {
        return this.numberOfShifts != null;
    }

    @Override
    public @Nullable Tile.Feature getFeature() {
        return this.feature;
    }

    @Override
    public @Nullable Either<Monster, Item> getSubject() {
        return this.subject;
    }

    @Override
    public void setSubject(
            @Nullable Either<Monster, Item> roomSubject
    ) {
        this.subject = roomSubject;
    }
}
