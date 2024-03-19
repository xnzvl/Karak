package github.xnzvl.karak.items;

import github.xnzvl.karak.description.Description;

// TODO: javadoc
public enum Chest implements Description {
    // TODO: Chest enum descriptions
    RUBY_CHEST            ("", "", 1.5F, false),
    SIMPLE_CHEST_LOCKED   ("", "", 1.0F, true),
    SIMPLE_CHEST_UNLOCKED ("", "", 1.0F, false);

    private final String title;
    private final String details;
    private final float scoreWorth;
    private final boolean isLocked;

    Chest(
            String title,
            String details,
            float scoreWorth,
            boolean isLocked
    ) {
        this.title = title;
        this.details = details;
        this.scoreWorth = scoreWorth;
        this.isLocked = isLocked;
    }

    @Override
    public String getTitle() {
        return this.title;
    }

    @Override
    public String getDetails() {
        return this.details;
    }

    public float getScoreWorth() {
        return this.scoreWorth;
    }

    public boolean isLocked() {
        return this.isLocked;
    }
}
