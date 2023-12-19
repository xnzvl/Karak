package github.xnzvl.karak.mortals.monsters;

import github.xnzvl.karak.items.Item;
import github.xnzvl.karak.items.Weapon;
import github.xnzvl.karak.mortals.Powerful;

import org.jetbrains.annotations.NotNull;

public enum Monster implements Powerful {
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

    @Override
    public @NotNull String getName() {
        return this.toString();
    }
}
