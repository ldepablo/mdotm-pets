package ai.mdotm.pets.infra.jpa.mapper;

import ai.mdotm.pets.domain.Pet;
import ai.mdotm.pets.infra.jpa.PetJpa;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class FromJpaPetConverterTest {

    private FromJpaPetConverter sut = new FromJpaPetConverter();

    @Test
    public void testFromJpaToDomain() {
        long id = 1L;
        String name = "Max";
        String species = "Dog";
        int age = 5;
        String ownerName = "John";

        Pet pet = Pet.builder()
                .id(id)
                .name(name)
                .species(species)
                .age(age)
                .ownerName(ownerName)
                .build();

        PetJpa result = sut.convert(pet);
        assertEquals(id, result.getId());
        assertEquals(name, result.getName());
        assertEquals(species, result.getSpecies());
        assertEquals(age, result.getAge());
        assertEquals(ownerName, result.getOwnerName());


    }
}