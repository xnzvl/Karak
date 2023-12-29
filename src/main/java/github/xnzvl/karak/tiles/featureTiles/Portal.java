package github.xnzvl.karak.tiles.featureTiles;

import github.xnzvl.karak.tiles.Hall;
import github.xnzvl.karak.tiles.TileRotation;
import github.xnzvl.karak.tiles.TileShape;
import github.xnzvl.karak.utils.Pair;

/**
 * Representing portal tile.
 * {@link github.xnzvl.karak.powerfuls.heroes.Hero} should be able
 * to reach any other portal tile in one step.
 *
 * @author Jakub Nezval
 */
public class Portal extends Hall implements FeatureTile {
    public Portal(
            Pair<Integer, Integer> coordinates,
            TileShape shape,
            TileRotation rotation
    ) {
        super(coordinates, shape, rotation);
    }
}
