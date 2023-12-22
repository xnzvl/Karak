package github.xnzvl.karak.tiles.infestedTiles;

import github.xnzvl.karak.items.Item;
import github.xnzvl.karak.powerfuls.monsters.Monster;
import github.xnzvl.karak.tiles.Tile;
import github.xnzvl.karak.utils.Either;

public interface InfestedTile extends Tile {
    Either<Monster, Item> getRoomSubject();
}
