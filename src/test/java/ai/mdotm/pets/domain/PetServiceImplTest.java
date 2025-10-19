package ai.mdotm.pets.domain;

import ai.mdotm.pets.application.PetRepo;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class PetServiceImplTest {

    @Mock
    PetRepo repo;

    @InjectMocks
    PetServiceImpl sut;

    @Test
    public void shouldFindById() {
        final long id = 1001L;
        Pet expectedPet = new Pet.Builder()
                .id(id)
                .name("Buddy")
                .species("Dog")
                .age(3)
                .ownerName("Alice")
                .build();

        when(repo.findById(id)).thenReturn(Optional.of(expectedPet));

        var result = sut.findById(id);

        assertTrue(result.isPresent());
        Pet pet = result.get();
        assertEquals(expectedPet, pet);
    }

    @Test
    public void testFindsByIdWhenNotExisting() {
        long id = 1234L;

        when(repo.findById(id)).thenReturn(Optional.empty());

        var result = sut.findById(id);

        assertTrue(result.isEmpty());
    }
}
