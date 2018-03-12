package seedu.address.model.breedtag;

import static java.util.Objects.requireNonNull;
import static seedu.address.commons.util.AppUtil.checkArgument;

public class BreedTag {

    public static final String MESSAGE_BREEDTAG_CONSTRAINTS = "Tags names should be alphanumeric";
    public static final String BREEDTAG_VALIDATION_REGEX = "\\p{Alnum}+";

    public final String breedTagName;

    /**
     * Constructs a {@code BreedTag}
     *
     * @param breedTagName A valid breed tag name
     */

    public BreedTag(String breedTagName) {
        requireNonNull(breedTagName);
        checkArgument(isValidBreedTagName(breedTagName), MESSAGE_BREEDTAG_CONSTRAINTS);
        this.breedTagName = breedTagName;
    }

    /**
     * Returns true if a given string is a valid breed tag name
     */
    public static boolean isValidBreedTagName(String test) {
        return test.matches(BREEDTAG_VALIDATION_REGEX);
    }

    @Override
    public boolean equals(Object other) {
        return other == this
              || (other instanceof BreedTag)
              && this.breedTagName.equals(((BreedTag) other).breedTagName);
    }

    @Override
    public int hashCode() {
        return breedTagName.hashCode();
    }

    /**
     * Format state as text for viewing
     */
    public String toString() {
        return '[' + breedTagName + ']';
    }

}
