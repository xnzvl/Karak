package github.xnzvl.karak;

import org.jetbrains.annotations.NotNull;

public interface DescribedObject {
    @NotNull String getTitle();
    @NotNull String getDetails();
}
