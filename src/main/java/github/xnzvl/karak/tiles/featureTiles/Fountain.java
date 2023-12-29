package github.xnzvl.karak.tiles.featureTiles;

import github.xnzvl.karak.tiles.Hall;
import github.xnzvl.karak.tiles.TileRotation;
import github.xnzvl.karak.tiles.TileShape;
import github.xnzvl.karak.utils.Pair;

/**
 * Representing fountain tile.
 * {@link github.xnzvl.karak.powerfuls.heroes.Hero} should heal here if it ends turn here.
 *
 * @author Jakub Nezval
 */
public class Fountain extends Hall implements FeatureTile {
    public Fountain(
            Pair<Integer, Integer> coordinates,
            TileShape shape,
            TileRotation rotation
    ) {
        super(coordinates, shape, rotation);
    }
}
