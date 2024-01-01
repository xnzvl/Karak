package github.xnzvl.karak.powerfuls.monsters;

import github.xnzvl.karak.description.DescribedObject;
import github.xnzvl.karak.items.Item;

/**
 * Class for simplifying {@link Monster} implementations.
 *
 * @author Jakub Nezval
 */
public class VariousMonster extends DescribedObject implements Monster {
    private final int power;
    private final Item drop;

    protected VariousMonster(
            String title,
            String details,
            int power,
            Item drop
    ) {
        super(title, details);
        this.power = power;
        this.drop = drop;
    }

    protected Item getDrop() {
        return this.drop;
    }

    @Override
    public int getPower() {
        return this.power;
    }

    @Override
    public Item defeat() {
        return this.drop;
    }
}
