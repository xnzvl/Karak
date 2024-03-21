package github.xnzvl.karak.board.impl.square;

import github.xnzvl.karak.board.Tile;
import github.xnzvl.karak.utils.Pair;

import java.util.Collection;
import java.util.List;

public enum SquareLayout implements Tile.Layout { // TODO: javadoc
    X (
            List.of(
                    Pair.of(0, 1),
                    Pair.of(1, 0),
                    Pair.of(0, -1),
                    Pair.of(-1, 0)
            )
    ),
    T (
            List.of(
                    Pair.of(1, 0),
                    Pair.of(0, -1),
                    Pair.of(-1, 0)
            )
    ),
    L (
            List.of(
                    Pair.of(0, 1),
                    Pair.of(1, 0)
            )
    ),
    I (
            List.of(
                    Pair.of(0, 1),
                    Pair.of(0, -1)
            )
    );

    private final Collection<Pair<Integer, Integer>> reachableDirections;

    SquareLayout(
            Collection<Pair<Integer, Integer>> reachableDirections
    ) {
        this.reachableDirections = reachableDirections;
    }

    @Override
    public Collection<Pair<Integer, Integer>> getDefaultReachableCoordinates() {
        return this.reachableDirections;
    }
}
