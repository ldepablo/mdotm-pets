package ai.mdotm.pets.infra.rest;

import ai.mdotm.pets.application.PetService;
import ai.mdotm.pets.domain.Pet;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.core.convert.ConversionService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class PetControllerTest {

    @Mock
    PetService petService;

    @Mock
    ConversionService conversionService;

    @InjectMocks
    private PetController sut;

    @Test
    public void shouldReturn200WhenFindById() {

        Pet pet = mock(Pet.class);
        when(petService.findById(1001L)).thenReturn(Optional.of(pet));

        PetResponse petResponse = mock(PetResponse.class);
        when(conversionService.convert(pet, PetResponse.class)).thenReturn(petResponse);

        ResponseEntity<PetResponse> result = sut.findById(1001L);

        assertEquals(petResponse, result.getBody());
        assertEquals(HttpStatus.OK, result.getStatusCode());

    }

    @Test
    public void shouldReturn404WhenFindByIdAndDoesNotExist() {

        when(petService.findById(1001L)).thenReturn(Optional.empty());

        ResponseEntity<PetResponse> result = sut.findById(1001L);

        assertNull(result.getBody());
        assertEquals(HttpStatus.NOT_FOUND, result.getStatusCode());

    }

}
