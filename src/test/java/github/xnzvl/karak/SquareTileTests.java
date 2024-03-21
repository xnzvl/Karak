package github.xnzvl.karak;

import github.xnzvl.karak.board.Tile;
import github.xnzvl.karak.board.impl.square.SquareShape;
import github.xnzvl.karak.board.impl.square.SquareTile;
import github.xnzvl.karak.utils.Pair;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.stream.Stream;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import static org.junit.jupiter.api.Assertions.assertEquals;

class SquareTileTests {
    private static final List<Pair<Integer, Integer>> variousCoords = List.of(
            Pair.of(0,0),
            Pair.of(3,7),
            Pair.of(7,-3),
            Pair.of(-3,-7),
            Pair.of(-7,3)
    );

    private static Stream<Arguments> tileConfigurations() {
        int maxNumberOfShifts = 4;

        List<Arguments> configs = new ArrayList<>(
                variousCoords.size() * SquareShape.values().length * maxNumberOfShifts
        );

        for (var coords : SquareTileTests.variousCoords) {
            for (var shape : SquareShape.values()) {
                for (int shifts = 0; shifts < maxNumberOfShifts; shifts++) {
                    configs.add(Arguments.of(coords, shape, shifts));
                }
            }
        }

        return configs.stream();
    }

    private static Pair<Integer, Integer> clockwiseShift(
            Pair<Integer, Integer> coordsToShift,
            int howManyTimes
    ) {
        int x = coordsToShift.xValue();
        int y = coordsToShift.yValue();
        int tmp;

        for (int i = 0; i < howManyTimes; i++) {
            tmp = x;
            x = y;
            y = -tmp;
        }

        return Pair.of(x, y);
    }

    @ParameterizedTest
    @MethodSource("tileConfigurations")
    void getAccessibleCoordinates_allConfigurations_isCorrect(
            Pair<Integer, Integer> coordinates,
            Tile.Shape shape,
            int numberOfShifts
    ) {
        Tile tile = new SquareTile(coordinates, shape, Tile.Type.HALL, null);

        var expected = tile
                .getShape()
                .getDefaultReachableCoordinates()
                .stream()
                .map(
                        directions -> clockwiseShift(
                                directions,
                                tile.getNumberOfShifts()
                        )
                )
                .map(coords -> Pair.of(
                        coordinates.xValue() + coords.xValue(),
                        coordinates.yValue() + coords.yValue())
                )
                .toList();

        assertEquals(
                new HashSet<>(expected),
                new HashSet<>(tile.getAccessibleCoordinates())
        );
    }
}
