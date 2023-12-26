package github.xnzvl.karak.items;

import org.jetbrains.annotations.NotNull;

public class Key implements Item {
    public Key() {
        // that's all
    }

    @Override
    public @NotNull String getTitle() {
        return "Key";
    }

    @Override
    public @NotNull String getDetails() {
        return "It's used to open locked chests";
    }
}
