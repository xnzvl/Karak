package github.xnzvl.karak.powerfuls.monsters;

import github.xnzvl.karak.items.Item;
import github.xnzvl.karak.powerfuls.Powerful;

import org.jetbrains.annotations.NotNull;

public interface Monster extends Powerful {
    @NotNull Item getItem();
}
