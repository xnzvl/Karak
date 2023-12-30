package github.xnzvl.karak.items.spells;

import java.util.List;

/**
 * Flaming Sword spell. See Karak rules for more information.
 *
 * @author Jakub Nezval
 */
public class FlamingSword extends VariousSpell {
    public FlamingSword() {
        super(
                "Flaming Sword",
                "Temporary +1 power.",
                SpellType.OFFENSIVE
        );
    }
}
