package github.xnzvl.karak.board.impl.square;

import github.xnzvl.karak.board.GeneralTile;
import github.xnzvl.karak.utils.Pair;

public class SquareTile extends GeneralTile {  // TODO: javadoc
    private final static int MAXIMUM_NUMBER_OF_SHIFTS = 4;

    public SquareTile(  // TODO: javadoc
            Pair<Integer, Integer> coordinates,
            Shape shape,
            Type type,
            Feature feature
    ) {
        super(coordinates, shape, type, feature);
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

    @Override
    public int getMaxNumberOfShifts() {
        return MAXIMUM_NUMBER_OF_SHIFTS;
    }
}
