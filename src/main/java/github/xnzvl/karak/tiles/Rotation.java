package github.xnzvl.karak.tiles;

/**
 * Enumeration for number of rotations that can {@link Tile} have.
 *
 * @author Jakub Nezval
 */
public enum Rotation {
    ONE   (0),
    TWO   (1),
    THREE (2),
    FOUR  (3);

    private final int numberOfShifts;

    Rotation(
            int numberOfShifts
    ) {
        this.numberOfShifts = numberOfShifts;
    }

    /**
     * Get number of clockwise shifts. The number is always non-negative.
     *
     * @return number of clockwise shifts
     */
    public int getNumberOfShifts() {
        return this.numberOfShifts;
    }
}
