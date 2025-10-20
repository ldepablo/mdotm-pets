package ai.mdotm.pets.infra.rest.mapper;

import ai.mdotm.pets.domain.Pet;
import ai.mdotm.pets.infra.rest.CreatePetRequest;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class FromRestCreatePetConverterTest {

    FromRestCreatePetConverter sut = new FromRestCreatePetConverter();

    @Test
    public void testMapper() {

        String name = "Archie";
        String species = "Dog";
        int age = 7;
        String ownerName = "Alice";

        CreatePetRequest input = new CreatePetRequest(
                name,
                species,
                age,
                ownerName
        );

        Pet expected = new Pet.Builder()
                .name(name)
                .species(species)
                .age(age)
                .ownerName(ownerName)
                .build();

        assertEquals(expected, sut.convert(input));

    }
}