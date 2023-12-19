package github.xnzvl.karak.items;

import org.jetbrains.annotations.NotNull;

public class Key implements Item {
    private static Key instance = null;

    public static Key getInstance() {
        if (instance == null) {
            instance = new Key();
        }
        return instance;
    }

    private Key() {
        // that's all
    }

    @Override
    public @NotNull String getName() {
        return "Key";
    }
}
