package github.xnzvl.karak.board;

import github.xnzvl.karak.items.Item;
import github.xnzvl.karak.strengthfuls.monsters.Monster;
import github.xnzvl.karak.utils.Either;
import github.xnzvl.karak.utils.Pair;
import github.xnzvl.karak.utils.Result;

import org.jetbrains.annotations.Nullable;

import java.util.Set;
import java.util.stream.Collectors;

public abstract class GeneralTile implements Tile {  // TODO: javadoc
    private final Pair<Integer, Integer> coordinates;
    private final Tile.Shape shape;
    private final Tile.Type type;
    private final Tile.Feature feature;

    @Nullable
    private Integer numberOfShifts;
    @Nullable
    private Either<Monster, Item> subject;

    public GeneralTile(  // TODO: javadoc
            Pair<Integer, Integer> coordinates,
            Tile.Shape shape,
            Tile.Type type,
            Tile.Feature feature
    ) {
        this.coordinates = coordinates;
        this.shape = shape;
        this.type = type;
        this.feature = feature;
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

    protected int safeGetNumberOfShifts() {
        return this.numberOfShifts == null ? 0 : numberOfShifts;
    }

    @Override
    public int getNumberOfShifts() {
        return this.safeGetNumberOfShifts();
    }

    @Override
    public Set<Pair<Integer, Integer>> getAccessibleCoordinates() {
        return this.getShape()
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
        assert numberOfShifts < this.getMaxNumberOfShifts() : "Input guarantee violated";

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
    public Shape getShape() {
        return this.shape;
    }

    @Override
    public Type getType() {
        return this.type;
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
