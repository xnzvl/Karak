package github.xnzvl.karak.mortals.monsters;

import github.xnzvl.karak.items.Item;
import github.xnzvl.karak.mortals.Mortal;

import org.jetbrains.annotations.NotNull;

public enum Monster implements Mortal {
    ;

    private final int power;
    private final @NotNull Item drop;

    Monster(
            int power,
            @NotNull Item drop
    ) {
        this.power = power;
        this.drop = drop;
    }

    @Override
    public int getPower() {
        return this.power;
    }

    public Item getDrop() {
        return this.drop;
    }
}
