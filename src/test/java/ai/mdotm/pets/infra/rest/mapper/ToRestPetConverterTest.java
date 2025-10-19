package ai.mdotm.pets.infra.rest.mapper;

import ai.mdotm.pets.domain.Pet;
import ai.mdotm.pets.infra.rest.PetResponse;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ToRestPetConverterTest {

    public static final long ID = 1L;
    public static final String NAME = "Buddy";
    public static final String SPECIES = "Dog";
    public static final int AGE = 5;
    public static final String OWNER_NAME = "John Doe";

    ToRestPetConverter sut = new ToRestPetConverter();

    @Test
    public void shouldConvert() {
        Pet pet = new Pet.Builder()
                .id(ID)
                .name(NAME)
                .species(SPECIES)
                .age(AGE)
                .ownerName(OWNER_NAME)
                .build();

        PetResponse expectedResponse = new PetResponse(
                1L,
                "Buddy",
                "Dog",
                5,
                "John Doe"
        );

        var response = sut.convert(pet);
        assertEquals(expectedResponse, response);
    }
}
