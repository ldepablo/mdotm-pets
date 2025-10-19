package ai.mdotm.pets.infra.jpa;

import ai.mdotm.pets.domain.Pet;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class PetJpaRepoMockTest {


    @Mock
    IdGenerator idGenerator;

    @InjectMocks
    PetJpaRepoMock sut;

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

    @Test
    public void shouldReturnCreatedEntityWhenCreate() {
        long id = 2000L;
        when(idGenerator.generateId()).thenReturn(id);

        Pet input = Pet.builder()
                .name("Bella")
                .species("Cat")
                .age(14)
                .ownerName("Bob")
                .build();

        Pet result = sut.save(input);

        assertEquals(result, input.withId(result.getId()));
    }

    @Test
    public void shouldUpdatedEntityWhenUpdate() {
        Pet input = Pet.builder()
                .id(1010L)
                .name("Charlie")
                .species("Parrot")
                .age(2)
                .ownerName("Cynthia")
                .build();

        Pet result = sut.save(input);

        assertEquals(result, input);

    }
}
