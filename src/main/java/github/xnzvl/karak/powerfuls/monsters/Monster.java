package github.xnzvl.karak.powerfuls.monsters;

import github.xnzvl.karak.items.Item;
import github.xnzvl.karak.powerfuls.Power;

import org.jetbrains.annotations.NotNull;

public interface Monster extends Power {
    @NotNull Item getItem();
}
