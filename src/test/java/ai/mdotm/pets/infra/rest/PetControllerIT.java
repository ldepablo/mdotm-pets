package ai.mdotm.pets.infra.rest;

import ai.mdotm.pets.ConverterConfig;
import ai.mdotm.pets.application.PetService;
import ai.mdotm.pets.domain.Pet;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.context.annotation.Import;
import org.springframework.http.MediaType;
import org.springframework.test.context.bean.override.mockito.MockitoBean;
import org.springframework.test.web.servlet.MockMvc;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.patch;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(PetController.class)
@Import(ConverterConfig.class)
public class PetControllerIT {

    @Autowired
    private MockMvc mockMvc;

    @MockitoBean
    private PetService service;

    @Test
    void shouldUpdateWithCorrectRequest() throws Exception {

        Pet pet = new Pet.Builder()
                .id(1001L)
                .name("Archie")
                .species("Dog")
                .age(8)
                .ownerName("Arthur")
                .build();

        when(service.update(pet)).thenReturn(pet);

        String petAsJson = """
                {
                    "id": 1001,
                    "name": "Archie",
                    "species": "Dog",
                    "age": 8,
                    "ownerName": "Arthur"
                }
                """;
        this.mockMvc.perform(patch("/pets")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(petAsJson))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().json(petAsJson));
    }

    @Test
    void shouldReturn400WithNoIdWhenUpdatePetRequest() throws Exception {

        this.mockMvc.perform(patch("/pets")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content("""
                                {
                                    "name": "Archie",
                                    "species": "Dog",
                                    "age": 8,
                                    "ownerName": "Arthur"
                                }
                                """))
                .andDo(print())
                .andExpect(status().isBadRequest());
    }

}
