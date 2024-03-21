package github.xnzvl.karak.board.impl.square;

import github.xnzvl.karak.board.impl.AnyTile;
import github.xnzvl.karak.utils.Pair;

import org.jetbrains.annotations.Nullable;

public class SquareTile extends AnyTile {  // TODO: javadoc
    public SquareTile(  // TODO: javadoc
            Pair<Integer, Integer> coordinates,
            Layout layout,
            Type type,
            @Nullable Feature feature
    ) {
        super(coordinates, layout, type, feature, Shape.SQUARE);
    }

    @Override
    protected Pair<Integer, Integer> clockwiseShift(
            Pair<Integer, Integer> coordinates,
            int numberOfShifts
    ) {
        int x = coordinates.xValue();
        int y = coordinates.yValue();
        int tmp;

        for (int i = 0; i < numberOfShifts; i++) {
            tmp = x;
            x = y;
            y = -tmp;
        }

        return Pair.of(x, y);
    }
}
