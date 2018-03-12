package seedu.address.model;

import javafx.collections.ObservableList;
import seedu.address.model.breedtag.BreedTag;
import seedu.address.model.person.Person;
import seedu.address.model.pet.Pet;
import seedu.address.model.tag.Tag;

/**
 * Unmodifiable view of an address book
 */
public interface ReadOnlyAddressBook {

    /**
     * Returns an unmodifiable view of the persons list.
     * This list will not contain any duplicate persons.
     */
    ObservableList<Person> getPersonList();

    /**
     * Returns an unmodifiable view of the pets list.
     * This list will not contain any duplicate pets.
     */
    ObservableList<Pet> getPetList();

    /**
     * Returns an unmodifiable view of the tags list.
     * This list will not contain any duplicate tags.
     */
    ObservableList<Tag> getTagList();

    /**
     * Returns an unmodifiable view of the breed tags list.
     * This list will not contain any duplicate tags.
     */
    ObservableList<BreedTag> getBreedTagList();

}
