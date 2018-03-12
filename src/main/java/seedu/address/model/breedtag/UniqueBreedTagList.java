package seedu.address.model.breedtag;

import static java.util.Objects.requireNonNull;
import static seedu.address.commons.util.CollectionUtil.requireAllNonNull;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import seedu.address.commons.exceptions.DuplicateDataException;
import seedu.address.commons.util.CollectionUtil;

/**
 * A list of breed tag that enforces no nulls and uniqueness between its elements.
 *
 * Supports minimal set of list operations for the app's eatures.
 *
 * @see BreedTag#equals(Object)
 */
public class UniqueBreedTagList implements Iterable<BreedTag> {

    private final ObservableList<BreedTag> internalList = FXCollections.observableArrayList();

    /**
     * Creates empty BreedTagList.
     */
    public UniqueBreedTagList() {}

    /**
     * Creates a UniqueBreedTagList using given tags.
     * Enforces no nulls
     */
    public UniqueBreedTagList(Set<BreedTag> breedTags) {
        requireAllNonNull(breedTags);
        internalList.addAll(breedTags);

        assert CollectionUtil.elementsAreUnique(internalList);
    }

    /**
     * Returns all tags in this list as a Set.
     * This set is mutable and change-insulated agaisnt the internal list.
     */
    public Set<BreedTag> toSet() {
        assert CollectionUtil.elementsAreUnique(internalList);
        return new HashSet<>(internalList);
    }

    /**
     * Replaces the BreedTags in this list with those in argument.
     */
    public void setTags(Set<BreedTag> breedTags) {
        requireAllNonNull(breedTags);
        internalList.setAll(breedTags);
        assert CollectionUtil.elementsAreUnique(internalList);
    }

    /**
     * Ensures every tag in the argument list exists in this object.
     */
    public void mergeFrom(UniqueBreedTagList from) {
        final Set<BreedTag> alreadyInside = this.toSet();
        from.internalList.stream()
                .filter(breedTag -> !alreadyInside.contains(breedTag))
                .forEach(internalList::add);

        assert CollectionUtil.elementsAreUnique(internalList);
    }

    /**
     * Returns true if the list contains an equivalent BreedTag as given argument
     */
    public boolean contains(BreedTag toCheck) {
        requireAllNonNull(toCheck);
        return internalList.contains(toCheck);
    }

    /**
     * Adds a Tag to the list.
     *
     * @throws DuplicateBreedTagException if the Tag to add is a duplicate of an existing Tag in the list.
     */
    public void add(BreedTag toAdd) throws DuplicateBreedTagException {
        requireNonNull(toAdd);
        if (contains(toAdd)) {
            throw new DuplicateBreedTagException();
        }
        internalList.add(toAdd);

        assert CollectionUtil.elementsAreUnique(internalList);
    }

    @Override
    public Iterator<BreedTag> iterator() {
        assert CollectionUtil.elementsAreUnique(internalList);
        return internalList.iterator();
    }

    /**
     * Returns the backing list as an unmodifiable {@code ObservableList}.
     */
    public ObservableList<BreedTag> asObservableList() {
        assert CollectionUtil.elementsAreUnique(internalList);
        return FXCollections.unmodifiableObservableList(internalList);
    }

    @Override
    public boolean equals(Object other) {
        assert CollectionUtil.elementsAreUnique(internalList);
        return other == this // short circuit if same object
                || (other instanceof UniqueBreedTagList // instanceof handles nulls
                && this.internalList.equals(((UniqueBreedTagList) other).internalList));
    }

    /**
     * Returns true if the element in this list is equal to the elements in {@code other}.
     * The elements do not have to be in the same order.
     */
    public boolean equalsOrderInsensitive(UniqueBreedTagList other) {
        assert CollectionUtil.elementsAreUnique(internalList);
        assert CollectionUtil.elementsAreUnique(other.internalList);
        return this == other || new HashSet<>(this.internalList).equals(new HashSet<>(other.internalList));
    }

    @Override
    public int hashCode() {
        assert CollectionUtil.elementsAreUnique(internalList);
        return internalList.hashCode();
    }

    /**
     * Signals that an operation would have violated the 'no duplicates' property of the list.
     */
    public static class DuplicateBreedTagException extends DuplicateDataException {
        protected DuplicateBreedTagException() {
            super("Operation would result in duplicate tags");
        }
    }
}

