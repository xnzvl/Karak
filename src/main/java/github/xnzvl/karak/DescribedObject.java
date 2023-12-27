package github.xnzvl.karak;

import org.jetbrains.annotations.NotNull;

/**
 * Interface for convenient obtaining description of an object.
 *
 * @author Jakub Nezval
 */
public interface DescribedObject {
    /**
     * Method for obtaining the shortest possible description of the object.
     * Returned string should contain only smaller units of words.
     *
     * @return short description of the object
     */
    @NotNull String getTitle();

    /**
     * Method for obtaining the detailed description of the object.
     * Careful! This method might return longer texts.
     *
     * @return detailed description of the object
     */
    @NotNull String getDetails();
}
