package github.xnzvl.karak.tiles.impl;

import github.xnzvl.karak.tiles.FeatureTile;
import github.xnzvl.karak.tiles.TileRotation;
import github.xnzvl.karak.tiles.TileShape;
import github.xnzvl.karak.utils.Pair;

/**
 * Representing fountain tile.
 * {@link github.xnzvl.karak.strengthfuls.heroes.Hero} should heal here if it ends turn here.
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
