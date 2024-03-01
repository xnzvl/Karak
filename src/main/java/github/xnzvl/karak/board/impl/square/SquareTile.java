package github.xnzvl.karak.board.impl.square;

import github.xnzvl.karak.board.Tile;
import github.xnzvl.karak.items.Item;
import github.xnzvl.karak.strengthfuls.monsters.Monster;
import github.xnzvl.karak.utils.Either;
import github.xnzvl.karak.utils.Pair;
import github.xnzvl.karak.utils.Result;

import org.jetbrains.annotations.Nullable;

import java.util.Set;

public class SquareTile implements Tile {
    @Override
    public Pair<Integer, Integer> getCoordinates() {
        return null;
    }

    @Override
    public Shape getShape() {
        return null;
    }

    @Override
    public Type getType() {
        return null;
    }

    @Override
    public int getNumberOfShifts() {
        return 0;
    }

    @Override
    public int getMaxNumberOfShifts() {
        return 0;
    }

    @Override
    public Set<Pair<Integer, Integer>> getAccessibleCoordinates() {
        return null;
    }

    @Override
    public Result setConditionalRotation(Pair<Integer, Integer> reachableFrom, int numberOfShifts) {
        return null;
    }

    @Override
    public @Nullable Tile.Feature getFeature() {
        return null;
    }

    @Override
    public @Nullable Either<Monster, Item> getSubject() {
        return null;
    }

    @Override
    public void setSubject(@Nullable Either<Monster, Item> roomSubject) {

    }

    @Override
    public boolean isConfigured() {
        return false;
    }
}
