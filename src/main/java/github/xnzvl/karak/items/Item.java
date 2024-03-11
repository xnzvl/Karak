package github.xnzvl.karak.items;

import github.xnzvl.karak.items.spells.Spell;
import github.xnzvl.karak.utils.Either;

import java.util.function.Consumer;
import java.util.function.Function;

public abstract class Item {
    public static Item from(
            Weapon weapon
    ) {
        return new Item() {
            @Override
            public <T> T apply(
                    Function<? super Weapon, ? extends T> weaponFunction,
                    Function<? super Spell,  ? extends T> spellFunction,
                    Function<? super Key,    ? extends T> keyFunction,
                    Function<? super Chest,  ? extends T> chestFunction
            ) {
                return weaponFunction.apply(weapon);
            }
        };
    }

    public static Item from(
            Spell spell
    ) {
        return new Item() {
            @Override
            public <T> T apply(
                    Function<? super Weapon, ? extends T> weaponFunction,
                    Function<? super Spell,  ? extends T> spellFunction,
                    Function<? super Key,    ? extends T> keyFunction,
                    Function<? super Chest,  ? extends T> chestFunction
            ) {
                return spellFunction.apply(spell);
            }
        };
    }

    public static Item from(
            Key key
    ) {
        return new Item() {
            @Override
            public <T> T apply(
                    Function<? super Weapon, ? extends T> weaponFunction,
                    Function<? super Spell,  ? extends T> spellFunction,
                    Function<? super Key,    ? extends T> keyFunction,
                    Function<? super Chest,  ? extends T> chestFunction
            ) {
                return keyFunction.apply(key);
            }
        };
    }

    public static Item from(
            Chest chest
    ) {
        return new Item() {
            @Override
            public <T> T apply(
                    Function<? super Weapon, ? extends T> weaponFunction,
                    Function<? super Spell,  ? extends T> spellFunction,
                    Function<? super Key,    ? extends T> keyFunction,
                    Function<? super Chest,  ? extends T> chestFunction
            ) {
                return chestFunction.apply(chest);
            }
        };
    }

    private Item() {
        // on purpose
    }

    public abstract <T> T apply(
            Function<? super Weapon, ? extends T> weaponFunction,
            Function<? super Spell,  ? extends T> spellFunction,
            Function<? super Key,    ? extends T> keyFunction,
            Function<? super Chest,  ? extends T> chestFunction
    );

    public void consume(
            Consumer<? super Weapon> weaponConsumer,
            Consumer<? super Spell>  spellConsumer,
            Consumer<? super Key>    keyConsumer,
            Consumer<? super Chest>  chestConsumer
    ) {
        this.apply(
                Either.createConsumerFunction(weaponConsumer),
                Either.createConsumerFunction(spellConsumer),
                Either.createConsumerFunction(keyConsumer),
                Either.createConsumerFunction(chestConsumer)
        );
    }
}
