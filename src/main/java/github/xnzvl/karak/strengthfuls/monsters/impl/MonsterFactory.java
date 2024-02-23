package github.xnzvl.karak.strengthfuls.monsters.impl;

import github.xnzvl.karak.items.Item;
import github.xnzvl.karak.items.Key;
import github.xnzvl.karak.items.chests.impl.OrdinaryChest;
import github.xnzvl.karak.items.chests.impl.RubyChest;
import github.xnzvl.karak.items.spells.impl.HealingWarp;
import github.xnzvl.karak.items.weapons.impl.Axe;
import github.xnzvl.karak.items.weapons.impl.Dagger;
import github.xnzvl.karak.items.weapons.impl.Sword;
import github.xnzvl.karak.strengthfuls.monsters.Monster;
import github.xnzvl.karak.strengthfuls.monsters.VariousMonster;

public class MonsterFactory {
    private MonsterFactory() {
        // on purpose
    }

    public static Monster createDragon() {
        return new VariousMonster(
                "Dragon",
                "",
                15,
                Item.from(new RubyChest())
        );
    }

    public static Monster createFallen() {
        return new VariousMonster(
                "Fallen",
                "",
                12,
                Item.from(new OrdinaryChest(false))
        );
    }

    public static Monster createMummy() {
        return new Mummy();
    }

    public static Monster createRat() {
        return new VariousMonster(
                "Rat",
                "",
                5,
                Item.from(new Dagger())
        );
    }

    public static Monster createSkeletonKeyKeeper() {
        return new VariousMonster(
                "Skeleton Key Keeper",
                "",
                7,
                Item.from(new Key())
        );
    }

    public static Monster createSkeletonKing() {
        return new VariousMonster(
                "Skeleton King",
                "",
                10,
                Item.from(new Axe())
        );
    }

    public static Monster createSkeletonSwordsman() {
        return new VariousMonster(
                "Skeleton Swordsman",
                "",
                9,
                Item.from(new Sword())
        );
    }

    public static Monster createSpider() {
        return new VariousMonster(
                "Spider",
                "",
                6,
                Item.from(new HealingWarp())
        );
    }
}
