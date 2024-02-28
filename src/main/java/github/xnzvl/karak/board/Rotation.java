package github.xnzvl.karak.board;

/**
 * Enumeration for number of rotations that can {@link Tile} have.
 *
 * @author Jakub Nezval
 */
public enum Rotation {
    NONE          (0),
    QUARTER       (1),
    HALF          (2),
    THREE_QUARTER (3);

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
