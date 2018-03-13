package seedu.address.model.pet;
import static seedu.address.commons.util.CollectionUtil.requireAllNonNull;

import java.util.Collections;
import java.util.Objects;
import java.util.Set;

import seedu.address.model.appointment.Appointment;
import seedu.address.model.breedtag.BreedTag;
import seedu.address.model.breedtag.UniqueBreedTagList;
import seedu.address.model.client.Client;

/**
 * Represents a Pet in the applications.
 * Guarantees: details are present and not null, field values are validated, immutable.
 */
public class Pet {

    private final PetName petName;
    private final PetAge petAge;
    private final Species species;
    private final PetGender petGender;
    private final Client petClient;
    private final Appointment petAppointment;

    private final UniqueBreedTagList tags;

    /**
     * Every field must be present and not null
     */
    public Pet(PetName petName, PetAge petAge, Species species, PetGender petGender,
               Client petClient, Appointment petAppointment, Set<BreedTag> tags) {
        requireAllNonNull(petName, petAge, species, petGender, tags);
        this.petName = petName;
        this.petAge = petAge;
        this.species = species;
        this.petGender = petGender;
        this.petClient = petClient;
        this.petAppointment = petAppointment;

        //protect internal tags from changes in the arg lis
        this.tags = new UniqueBreedTagList(tags);
    }

    public PetName getPetName() {
        return petName;
    }

    public PetAge getPetAge() {
        return petAge;
    }

    public Species getSpecies() {
        return species;
    }

    public PetGender getPetGender() {
        return petGender;
    }

    public Client getPetClient() {
        return petClient;
    }

    public Appointment getPetAppointment() {
        return petAppointment;
    }

    /**
     * Returns an immutable tag set, which throws {@code UnsupportedOperationException}
     * if modification is attempted.
     */
    public Set<BreedTag> getBreedTags() {
        return Collections.unmodifiableSet(tags.toSet());
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }

        if (!(other instanceof Pet)) {
            return false;
        }

        Pet otherPet = (Pet) other;
        return otherPet.getPetName().equals(this.getPetName())
                && otherPet.getPetAge().equals(this.getPetAge())
                && otherPet.getSpecies().equals(this.getSpecies())
                && otherPet.getPetGender().equals(this.getPetGender())
                && otherPet.getPetClient().equals(this.getPetClient())
                && otherPet.getPetAppointment().equals(this.getPetAppointment());
    }

    @Override
    public int hashCode() {
        // use this method for custom fields hashing instead of implementing your own
        return Objects.hash(petName, petAge, species, petGender, petClient, petAppointment);
    }

    @Override
    public String toString() {
        final StringBuilder builder = new StringBuilder();
        builder.append(" Pet Name: ")
                .append(getPetName())
                .append(" Pet Age: ")
                .append(getPetAge())
                .append(" Species: ")
                .append(getSpecies())
                .append(" Gender: ")
                .append(getPetGender())
                .append(" Pet Owner: ")
                .append(getPetClient())
                .append(" Appointment Date: ")
                .append(getPetAppointment());
        getBreedTags().forEach(builder::append);
        return builder.toString();
    }

}
