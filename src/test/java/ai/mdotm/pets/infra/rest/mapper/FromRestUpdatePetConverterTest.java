package ai.mdotm.pets.infra.rest.mapper;

import ai.mdotm.pets.domain.Pet;
import ai.mdotm.pets.infra.rest.UpdatePetRequest;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class FromRestUpdatePetConverterTest {

    FromRestUpdatePetConverter sut = new FromRestUpdatePetConverter();

    @Test
    public void testMapper() {

        final long id = 1001L;
        final String name = "Archie";
        final String species = "Dog";
        final int age = 7;
        final String ownerName = "Alice";

        UpdatePetRequest input = new UpdatePetRequest(
                id,
                name,
                species,
                age,
                ownerName
        );

        Pet expected = new Pet.Builder()
                .id(id)
                .name(name)
                .species(species)
                .age(age)
                .ownerName(ownerName)
                .build();

        assertEquals(expected, sut.convert(input));

    }
}