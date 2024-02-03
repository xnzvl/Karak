package github.xnzvl.karak.powerfuls.monsters;

import github.xnzvl.karak.description.DescribedObject;
import github.xnzvl.karak.items.Item;

/**
 * Class for simplifying {@link Monster} implementations.
 *
 * @author Jakub Nezval
 */
public class VariousMonster extends DescribedObject implements Monster {
    private final int strength;
    private final Item drop;

    protected VariousMonster(
            String title,
            String details,
            int strength,
            Item drop
    ) {
        super(title, details);
        this.strength = strength;
        this.drop = drop;
    }

    @Override
    public int getStrength() {
        return this.strength;
    }

    public Item getDrop() {
        return this.drop;
    }
}
