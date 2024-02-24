package github.xnzvl.karak.strengthfuls.heroes;

import github.xnzvl.karak.description.DescribedObject;
import github.xnzvl.karak.game.Board;
import github.xnzvl.karak.items.Item;
import github.xnzvl.karak.items.Key;
import github.xnzvl.karak.items.chests.Chest;
import github.xnzvl.karak.items.spells.Spell;
import github.xnzvl.karak.items.weapons.Weapon;
import github.xnzvl.karak.players.Picker;
import github.xnzvl.karak.strengthfuls.Strength;
import github.xnzvl.karak.strengthfuls.monsters.Monster;
import github.xnzvl.karak.tiles.Tile;
import github.xnzvl.karak.utils.Either;
import github.xnzvl.karak.utils.Holder;
import github.xnzvl.karak.utils.MapUtils;
import github.xnzvl.karak.utils.Pair;
import github.xnzvl.karak.utils.Result;

import org.jetbrains.annotations.Nullable;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.function.Predicate;
import java.util.function.Supplier;

public class Hero extends DescribedObject implements Strength {
    public static class Params {
        private Supplier<List<Hero>> allHeroesSupplier;
        private Board board;
        private Holder<Hero> curseHolder;
        private Picker picker;

        public Params setAllHeroesSupplier(
                Supplier<List<Hero>> allHeroesSupplier
        ) {
            this.allHeroesSupplier = allHeroesSupplier;
            return this;
        }

        public Params setBoard(
                Board board
        ) {
            this.board = board;
            return this;
        }

        public Params setCurseHolder(
                Holder<Hero> curseHolder
        ) {
            this.curseHolder = curseHolder;
            return this;
        }

        public Params setPicker(
                Picker picker
        ) {
            this.picker = picker;
            return this;
        }

        public boolean isComplete() {
            return this.allHeroesSupplier != null
                    & this.board != null
                    & this.curseHolder != null
                    & this.picker != null;
        }

        public Params copy() {
            return new Params()
                .setAllHeroesSupplier(this.allHeroesSupplier)
                .setBoard(this.board)
                .setCurseHolder(this.curseHolder)
                .setPicker(this.picker);
        }
    }

    public static final int MAX_HIT_POINTS = 5;
    public static final int DEFAULT_NUMBER_OF_STEPS = 4;

    private final Supplier<List<Hero>> allHeroesSupplier;
    private final Board board;
    private final Holder<Hero> curseHolder;
    private final Map<Slot, @Nullable Item> inventory = MapUtils.defaultHashMapFrom(
            Arrays.asList(Slot.values()), null
    );
    private final Picker picker;

    private int hitPoints = MAX_HIT_POINTS;
    private Pair<Integer, Integer> position = Pair.of(0, 0);
    @Nullable
    private TurnState turnState = null;

    // TODO: javadoc
    protected Hero(
            Hero.Params paramObject
    ) {
        super(null, null);  // TODO: title + details

        if (!paramObject.isComplete()) throw new IllegalArgumentException("paramObject isn't complete");

        this.allHeroesSupplier = paramObject.allHeroesSupplier;
        this.board = paramObject.board;
        this.curseHolder = paramObject.curseHolder;
        this.picker = paramObject.picker;
    }

    public void startTurn() {
        this.turnState = new TurnState();
    }

    public void endTurn() {
        this.turnState = null;
    }

    protected Slot pickInventorySlot() {
        return this.picker.pick(Picker.Context.INVENTORY_SLOT, Arrays.asList(Slot.values()));
    }

    @Nullable
    protected Either<Monster, Item> getCurrentSubject() {
        Tile currentTile = this.board.getTileAt(this.position);
        assert currentTile != null : "Hero is outside of the Board";
        return currentTile.getSubject();
    }

    public Result move(
            Pair<Integer, Integer> newPosition
    ) {
        if (!isValidMove(newPosition)) return Result.withFailure(Result.Failure.INVALID_CHOICE);

        // TODO: - change position + remember last position
        //       - place a new Tile if needed

        return Result.withSuccess();
    }

    public Result heal() {
        // TODO: impl
        return Result.withSuccess();
    }

    public Result pickUpItem() {
        Either<Monster, Item> subject = this.getCurrentSubject();
        if (subject == null) return Result.withFailure(Result.Failure.NULL);

        Item item = subject.apply(
                monsterOption -> null,
                itemOption -> itemOption
        );
        if (item == null) return Result.withFailure(Result.Failure.NOT_ALLOWED);

        Slot slot = this.pickInventorySlot();
        return item.apply(
                weapon -> pickUpWeapon(slot, weapon),
                spell  -> pickUpSpell(slot, spell),
                key    -> pickUpKey(slot, key),
                this::pickUpChest
        );
    }

    private Result pickUpItem(
            Item item,
            Slot slot,
            Predicate<Slot> isSlotValid
    ) {
        if (!isSlotValid.test(slot)) return Result.withFailure(Result.Failure.INVALID_CHOICE);
        this.inventory.put(slot, item);
        return Result.withSuccess();
    }

    protected Result pickUpWeapon(
            Slot slot,
            Weapon weapon
    ) {
        return pickUpItem(Item.from(weapon), slot, Slot::isWeaponSlot);
    }

    protected Result pickUpSpell(
            Slot slot,
            Spell spell
    ) {
        return pickUpItem(Item.from(spell), slot, Slot::isSpellSlot);
    }

    protected Result pickUpKey(
            Slot slot,
            Key key
    ) {
        return pickUpItem(Item.from(key), slot, (slotArg -> slotArg != Slot.KEY));
    }

    protected Result pickUpChest(
            Chest chest
    ) {
        // TODO - Hero::pickUpChest
        return Result.withSuccess();
    }

    public Result useItem() {
        Slot slot = this.pickInventorySlot();

        if (Slot.isWeaponSlot(slot))          return Result.withFailure(Result.Failure.INVALID_CHOICE);
        // TODO: do I want to use Weapons?
        if (this.inventory.get(slot) == null) return Result.withFailure(Result.Failure.NULL);

        // TODO: - key unlocks a chest! don't forget it
        //       - check if spell is usable in the situation

        return Result.withSuccess();
    }

    public int getStrength() {
        int strength = 0;
        Item item;

        for (var weaponSlot : Slot.getWeaponSlots()) {
            item = this.inventory.get(weaponSlot);
            if (item != null) {
                strength += item.apply(
                        Weapon::getStrength, x -> 0, x -> 0, x -> 0
                );
            }
        }

        return strength;
    }

    protected boolean isValidMove(
            Pair<Integer, Integer> newPosition
    ) {
        return false;
    }
}
