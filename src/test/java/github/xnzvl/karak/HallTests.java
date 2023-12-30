package github.xnzvl.karak;

import github.xnzvl.karak.tiles.impl.Hall;
import github.xnzvl.karak.tiles.TileRotation;
import github.xnzvl.karak.tiles.TileShape;
import github.xnzvl.karak.utils.Pair;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

class HallTests {
    private static final List<Pair<Integer, Integer>> variousCoords = List.of(
            Pair.of(0,0),
            Pair.of(3,7),
            Pair.of(7,-3),
            Pair.of(-3,-7),
            Pair.of(-7,3)
    );

    private static Stream<Arguments> tileConfigurations() {
        List<Arguments> configs = new ArrayList<>(
                variousCoords.size() * TileShape.values().length * TileRotation.values().length
        );
        for (var tileShape : TileShape.values()) {
            for (var rotation : TileRotation.values()) {
                for (var coords : variousCoords) {
                    configs.add(Arguments.of(coords, tileShape, rotation));
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
            TileShape shape,
            TileRotation rotation
    ) {
        Hall hall = new Hall(coordinates, shape, rotation);

        var expected = shape.getDoorsTo().stream()
                .map(directions -> clockwiseShift(directions, rotation.getNumberOfShifts()))
                .map(coords -> Pair.of(
                        coordinates.xValue() + coords.xValue(),
                        coordinates.yValue() + coords.yValue())
                )
                .toList();

        assertEquals(
                new HashSet<>(expected),
                new HashSet<>(hall.getAccessibleCoordinates())
        );
    }
}
