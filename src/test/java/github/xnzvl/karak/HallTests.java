package github.xnzvl.karak;

import github.xnzvl.karak.tiles.Hall;
import github.xnzvl.karak.tiles.Rotation;
import github.xnzvl.karak.tiles.TileShape;
import github.xnzvl.karak.utils.Pair;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.List;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

class HallTests {
    private static Stream<Arguments> tileCoordsStream() {
        return Stream.of(
                Arguments.of(Pair.of(0,0)),
                Arguments.of(Pair.of(3,7)),
                Arguments.of(Pair.of(7,-3)),
                Arguments.of(Pair.of(-3,-7)),
                Arguments.of(Pair.of(-7,3))
        );
    }

    @ParameterizedTest
    @MethodSource("tileCoordsStream")
    void getAccessibleCoordinates_ShapeIRotationOne_isCorrect(
            Pair<Integer, Integer> tileCoords
    ) {
        Hall hall = new Hall(tileCoords, TileShape.I, Rotation.ONE);

        var expected = List.of(
                Pair.of(tileCoords.xValue(), tileCoords.yValue() + 1),
                Pair.of(tileCoords.xValue(), tileCoords.yValue() - 1)
        );

        assertEquals(
                expected,
                hall.getAccessibleCoordinates()
        );
    }
}
