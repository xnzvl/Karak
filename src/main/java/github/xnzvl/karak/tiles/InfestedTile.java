package github.xnzvl.karak.tiles;

import github.xnzvl.karak.items.Item;
import github.xnzvl.karak.mortals.Monster;
import github.xnzvl.karak.utils.Either;

public interface InfestedTile extends Tile {
    Either<Monster, Item> getRoomSubject();
}
