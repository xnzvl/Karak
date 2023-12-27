package github.xnzvl.karak;

import github.xnzvl.karak.utils.Pair;

import org.junit.jupiter.api.Test;

import java.util.HashSet;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

class PairTests {
    @Test
    void twoPair_swapCoords_NotEquals() {
        assertNotEquals(Pair.of(3, 7), Pair.of(7, 3));
    }

    @Test
    void pairs_uniqueCoords_haveUniqueHashCode() {
        Set<Pair<Integer, Integer>> pairs = new HashSet<>();
        for (int i = -100; i <= 100; i++) {
            for (int j = -100; j <= 100; j++) {
                assertTrue(pairs.add(Pair.of(i, j)));
            }
        }
    }
}
