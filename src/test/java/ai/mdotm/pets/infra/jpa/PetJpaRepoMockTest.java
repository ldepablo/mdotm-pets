package ai.mdotm.pets.infra.jpa;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class PetJpaRepoMockTest {

    PetJpaRepoMock sut = new PetJpaRepoMock();

    @Test
    public void shouldReturnValidPetWhenFindByIdDifferentThan1234() {

        var result = sut.findById(1001L);
        assertTrue(result.isPresent());

        var pet = result.get();
        assertEquals(1001L, pet.getId());
        assertEquals("Archie", pet.getName());
        assertEquals("Dog", pet.getSpecies());
        assertEquals(8, pet.getAge());
        assertEquals("Arthur", pet.getOwnerName());

    }

    @Test
    public void shouldReturnEmptyWhenFindById1234() {
        var pet = sut.findById(1234L);
        assertTrue(pet.isEmpty());
    }
}
