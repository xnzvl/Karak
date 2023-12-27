package github.xnzvl.karak.game;

import org.jetbrains.annotations.NotNull;

import java.util.Collection;

public interface Game {
    void start();
    @NotNull Collection<@NotNull Player> getWinner();
}
