package github.xnzvl.karak.powerfuls.heroes;

import github.xnzvl.karak.items.Item;
import github.xnzvl.karak.powerfuls.Powerful;
import github.xnzvl.karak.utils.Pair;

import java.util.HashMap;

public abstract class Hero implements Powerful {
    private final int hitPoints = 5;
    private final Pair<Integer, Integer> position = Pair.of(0, 0);
    private final HashMap<Slot, Item> inventory = HashMap.newHashMap(Slot.values().length);
}
