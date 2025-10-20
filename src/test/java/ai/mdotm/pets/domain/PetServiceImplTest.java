package ai.mdotm.pets.domain;

import ai.mdotm.pets.application.PetRepo;
import ai.mdotm.pets.application.exception.DomainValidationException;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

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
    public void shouldFindByIdWhenNotExisting() {
        long id = 1234L;

        when(repo.findById(id)).thenReturn(Optional.empty());

        var result = sut.findById(id);

        assertTrue(result.isEmpty());
    }

    @Test
    public void shouldCreatePetWithNullId() {

        Pet inputPet = new Pet.Builder()
                .name("Whiskers")
                .species("Cat")
                .age(2)
                .ownerName("Bob")
                .build();
        Pet outputPet = mock(Pet.class);
        when(repo.save(inputPet)).thenReturn(outputPet);

        var result = sut.create(inputPet);

        assertEquals(outputPet, result);
    }

    @Test
    public void shouldThrowDomainValidationExceptionWhenCreatingAndIdIsNotNull() {

        Pet inputPet = new Pet.Builder()
                .id(100L)
                .name("Whiskers")
                .species("Cat")
                .age(2)
                .ownerName("Bob")
                .build();

        assertThrows(DomainValidationException.class, () -> sut.create(inputPet));
    }

    @Test
    public void shouldUpdatePetWithId() {

        Pet inputPet = mock(Pet.class);
        Pet outputPet = mock(Pet.class);
        when(repo.save(inputPet)).thenReturn(outputPet);

        var result = sut.update(inputPet);

        assertEquals(outputPet, result);
    }

    @Test
    public void shouldDeleteById() {
        long id = 1234L;
        sut.deleteById(id);

        verify(repo).deleteById(id);
    }
}
