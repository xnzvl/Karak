package github.xnzvl.karak.items.spells;

import github.xnzvl.karak.items.Item;
import github.xnzvl.karak.items.spells.effects.Effect;

import java.util.List;

public interface Spell extends Item {
    List<Effect> getEffects();
}
