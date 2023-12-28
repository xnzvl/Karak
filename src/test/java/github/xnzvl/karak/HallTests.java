package github.xnzvl.karak;

import github.xnzvl.karak.tiles.Hall;
import github.xnzvl.karak.tiles.Rotation;
import github.xnzvl.karak.tiles.TileShape;
import github.xnzvl.karak.utils.Pair;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

class HallTests {
    @Test
    void getAccessibleCoordinates_ShapeIRotationOne_isCorrect() {
        var originHall = new Hall(Pair.of(0, 0), TileShape.I, Rotation.ONE);

        assertEquals(
                List.of(Pair.of(0, 1), Pair.of(0, -1)),
                originHall.getAccessibleCoordinates()
        );
    }
}
