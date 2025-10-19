package ai.mdotm.pets.infra.jpa.mapper;

import ai.mdotm.pets.domain.Pet;
import ai.mdotm.pets.infra.jpa.PetJpa;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

class ToJpaPetConverterTest {

    private ToJpaPetConverter sut = new ToJpaPetConverter();

    @Test
    public void shouldConvertFromDomainToJpa() {
        long id = 1L;
        String name = "Max";
        String species = "Dog";
        int age = 5;
        String ownerName = "John";

        PetJpa petJpa = PetJpa.builder()
                .id(id)
                .name(name)
                .species(species)
                .age(age)
                .ownerName(ownerName)
                .build();

        Pet pet = sut.convert(petJpa);
        assertEquals(id, pet.getId());
        assertEquals(name, pet.getName());
        assertEquals(species, pet.getSpecies());
        assertEquals(age, pet.getAge());
        assertEquals(ownerName, pet.getOwnerName());
    }

    @Test
    public void shouldConvertFromDomainToJpaWithoutId() {
        String name = "Max";
        String species = "Dog";
        int age = 5;
        String ownerName = "John";

        PetJpa petJpa = PetJpa.builder()
                .name(name)
                .species(species)
                .age(age)
                .ownerName(ownerName)
                .build();

        Pet pet = sut.convert(petJpa);
        assertNull(pet.getId());
        assertEquals(name, pet.getName());
        assertEquals(species, pet.getSpecies());
        assertEquals(age, pet.getAge());
        assertEquals(ownerName, pet.getOwnerName());
    }
}