package github.xnzvl.karak.mortals.heroes;

import github.xnzvl.karak.items.Item;
import github.xnzvl.karak.mortals.Mortal;
import github.xnzvl.karak.utils.Pair;

import java.util.HashMap;

public abstract class Hero implements Mortal {
    private final int hitpoints = 5;
    private final Pair<Integer, Integer> position = Pair.of(0, 0);
    private final HashMap<Slot, Item> inventory = HashMap.newHashMap(Slot.values().length);
}
