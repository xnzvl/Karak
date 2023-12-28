package github.xnzvl.karak.tiles;

import github.xnzvl.karak.utils.Pair;

import org.jetbrains.annotations.NotNull;

import java.util.Collection;
import java.util.List;

/**
 * Enumeration for describing {@link Tile} shape.
 *
 * @author Jakub Nezval
 */
public enum TileShape {
    I (List.of(Pair.of(0, 1), Pair.of(0, -1))),
    L (List.of(Pair.of(0, 1), Pair.of(1, 0))),
    T (List.of(Pair.of(0, 1), Pair.of(1, 0), Pair.of(0, -1))),
    X (List.of(Pair.of(0, 1), Pair.of(1, 0), Pair.of(0, -1), Pair.of(-1, 0)));

    private final @NotNull List<@NotNull Pair<@NotNull Integer, @NotNull Integer>> doorsTo;

    TileShape(
            @NotNull List<@NotNull Pair<@NotNull Integer, @NotNull Integer>> doorsTo
    ) {
        this.doorsTo = doorsTo;
    }

    /**
     * Get directions that lead from a {@link Tile} center - Pair.of(0, 0).
     * xValue and yValue of a direction pair are an element of set {-1, 0, 1}.
     *
     * @return collection of direction pairs
     */
    public @NotNull Collection<@NotNull Pair<@NotNull Integer, @NotNull Integer>> getDoorsTo() {
        return this.doorsTo;
    }
}
