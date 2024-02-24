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
import github.xnzvl.karak.tiles.Feature;
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
import java.util.Objects;
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

    private float points = 0;
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

    protected Tile getCurrentTile() {
        return this.board.getTileAt(this.position);
    }

    @Nullable
    protected Either<Monster, Item> getCurrentSubject() {
        Tile currentTile = getCurrentTile();
        assert currentTile != null : "Hero is outside of the Board";
        return currentTile.getSubject();
    }

    @Nullable Monster getMonster() {
        Either<Monster, Item> subject = this.getCurrentSubject();
        return subject == null ? null : subject.apply(
                monster -> monster,
                item    -> null
        );
    }

    @Nullable
    protected Item getItem() {
        Either<Monster, Item> subject = this.getCurrentSubject();
        return subject == null ? null : subject.apply(
                monster -> null,
                item    -> item
        );
    }

    @Nullable
    protected Chest getChest() {
        return null;  // TODO: impl
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
        if (!this.board.getTilesWith(Feature.FOUNTAIN).contains(this.position)) {
            return Result.withFailure(Result.Failure.NOT_ALLOWED);
        }

        this.hitPoints = Hero.MAX_HIT_POINTS;
        if (this.curseHolder.getInstance().equals(this)) {
            this.curseHolder.setInstance(null);
        }
        return Result.withSuccess();
    }

    public Result pickUpItem() {
        Item item = this.getItem();
        if (item == null) return Result.withFailure(Result.Failure.NULL);

        Slot slot = this.pickInventorySlot();
        return item.apply(
                weapon -> pickUpWeapon(slot, weapon),
                spell  -> pickUpSpell(slot, spell),
                key    -> pickUpKey(slot, key),
                chest  -> Result.withFailure(Result.Failure.NEEDS_KEY)  // TODO: think about this
        );
    }

    private Result pickUpItem(  // TODO: visibility?
            Item item,
            Slot slot,
            Predicate<Slot> isSlotValid
    ) {
        if (!isSlotValid.test(slot)) return Result.withFailure(Result.Failure.INVALID_CHOICE);
        // TODO: replace item - this only rewrites current inventory slot
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

    public Result useItem() {
        Slot slot = this.pickInventorySlot();

        Item item = this.inventory.get(slot);
        if (item == null) return Result.withFailure(Result.Failure.NULL);

        return item.apply(
                weapon -> Result.withFailure(Result.Failure.INVALID_CHOICE),
                spell  -> useSpell(slot, spell),
                key    -> useKey(),
                chest  -> Result.withFailure(Result.Failure.INVALID_CHOICE)  // TODO: questionable
        );
    }

    protected Result useKey() {
        Chest chest = this.getChest();
        if (chest == null) return Result.withFailure(Result.Failure.MISSING_CHEST);

        if (chest.isLocked()) {
            if (this.inventory.get(Slot.KEY) == null) return Result.withFailure(Result.Failure.NOT_ALLOWED);
            this.inventory.put(Slot.KEY, null);
        }

        this.points += chest.getScoreWorth();
        return Result.withSuccess();
    }

    protected Result useSpell(
            Slot slot,
            Spell spell
    ) {
        return Result.withSuccess();  // TODO: impl
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
        return this.getCurrentTile().getAccessibleCoordinates().contains(newPosition);
    }

    @Override
    public boolean equals(
            Object o
    ) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Hero hero = (Hero) o;
        return Objects.equals(this.getTitle(), hero.getTitle());
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.getTitle());
    }
}
