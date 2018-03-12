package seedu.address.testutil;

import java.util.Set;

import seedu.address.model.appointment.Appointment;
import seedu.address.model.client.Client;
import seedu.address.model.person.Address;
import seedu.address.model.person.Email;
import seedu.address.model.person.Name;
import seedu.address.model.person.Phone;
import seedu.address.model.pet.PetAge;
import seedu.address.model.pet.PetGender;
import seedu.address.model.pet.PetName;
import seedu.address.model.pet.Species;
import seedu.address.model.tag.Tag;
import seedu.address.model.util.SampleDataUtil;

/**
 * A util class to help build Pet objects
 */
public class PetBuilder {

    public static final String DEFAULT_PETNAME = "Garfield";
    public static final String DEFAULT_PETAGE = "5";
    public static final String DEFAULT_SPECIES = "Cat";
    public static final String DEFAULT_GENDER = "M";

    //Client
    public static final String DEFAULT_NAME = "Alice Pauline";
    public static final String DEFAULT_PHONE = "85355255";
    public static final String DEFAULT_EMAIL = "alice@gmail.com";
    public static final String DEFAULT_ADDRESS = "123, Jurong West Ave 6, #08-111";
    public static final String DEFAULT_TAGS = "friends";
    public static final int DEFAULT_ID = 1;

    //Vet technician
    public static final String DEFAULT_VNAME = "Bobby Bobz";
    public static final String DEFAULT_VPHONE = "92121232";
    public static final String DEFAULT_VEMAIL = "bobby@email.com";
    public static final String DEFAULT_VADRRESS = "123, Bedok Street 21, #03-33";
    public static final String DEFAULT_VTAG = "part-timer";

    public static final String DEFAULT_DATE = "01/02/2018";
    public static final String DEFAULT_TIME = "0230";

    private PetName petName;
    private PetAge petAge;
    private Species species;
    private PetGender petGender;

    private Client owner;
    private Name ownerName;
    private Phone ownerPhone;
    private Email ownerEmail;
    private Address ownerAddress;
    private Set<Tag> ownerTag;

    private Appointment appointment;

    public PetBuilder() {
        petName = new PetName(DEFAULT_PETNAME);
        petAge = new PetAge(DEFAULT_PETAGE);
        species = new Species(DEFAULT_SPECIES);
        petGender = new PetGender(DEFAULT_GENDER);

        ownerName = new Name(DEFAULT_NAME);
        ownerPhone = new Phone(DEFAULT_PHONE);
        ownerEmail = new Email(DEFAULT_EMAIL);
        ownerAddress = new Address(DEFAULT_ADDRESS);
        ownerTag = SampleDataUtil.getTagSet(DEFAULT_TAGS);
        owner = new Client(ownerName, ownerPhone, ownerEmail, ownerAddress, ownerTag, DEFAULT_ID);

    }
}
