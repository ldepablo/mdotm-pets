package ai.mdotm.pets.infra.rest;

import ai.mdotm.pets.application.PetService;
import ai.mdotm.pets.domain.Pet;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.ConversionService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;

import java.util.Optional;

@Controller
public class PetController {

    private final PetService service;
    private final ConversionService mapper;

    @Autowired
    public PetController(
            PetService service,
            ConversionService mapper) {
        this.service = service;
        this.mapper = mapper;
    }

    public ResponseEntity<PetResponse> findById(long id) {
        Optional<Pet> byId = service.findById(id);
        if (byId.isEmpty()) {
            return ResponseEntity
                    .status(HttpStatus.NOT_FOUND)
                    .build();
        }

        Pet pet = byId.get();
        PetResponse petResponse = mapper.convert(pet, PetResponse.class);
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(petResponse);
    }
}
