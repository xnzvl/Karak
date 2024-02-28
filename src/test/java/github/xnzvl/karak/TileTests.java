package github.xnzvl.karak;

import github.xnzvl.karak.board.Tile;
import github.xnzvl.karak.board.TileTemplate;
import github.xnzvl.karak.board.impl.square.SquareTile;
import github.xnzvl.karak.board.Rotation;
import github.xnzvl.karak.board.Shape;
import github.xnzvl.karak.utils.Pair;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

class TileTests {
    private static final List<Pair<Integer, Integer>> variousCoords = List.of(
            Pair.of(0,0),
            Pair.of(3,7),
            Pair.of(7,-3),
            Pair.of(-3,-7),
            Pair.of(-7,3)
    );

    private static Stream<Arguments> tileConfigurations() {
        List<Arguments> configs = new ArrayList<>(
                variousCoords.size() * Shape.values().length * Rotation.values().length
        );
        for (var coords : TileTests.variousCoords) {
            for (var template : TileTemplate.values()) {
                for (var rotation : Rotation.values()) {
                    configs.add(Arguments.of(coords, template, rotation));
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
            TileTemplate template,
            Rotation rotation
    ) {
        Tile tile = new SquareTile(coordinates, template, rotation);

        var expected = template
                .getShape()
                .getDoorsTo()
                .stream()
                .map(
                        directions -> clockwiseShift(
                                directions,
                                tile.getRotation().getNumberOfShifts()
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
