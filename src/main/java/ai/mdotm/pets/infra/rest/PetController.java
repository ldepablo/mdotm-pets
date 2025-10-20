package ai.mdotm.pets.infra.rest;

import ai.mdotm.pets.application.PetService;
import ai.mdotm.pets.domain.Pet;
import ai.mdotm.pets.infra.rest.dto.CreatePetRequest;
import ai.mdotm.pets.infra.rest.dto.PetResponse;
import ai.mdotm.pets.infra.rest.dto.UpdatePetRequest;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.ConversionService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/pets")
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

    @GetMapping("/{id}")
    public ResponseEntity<PetResponse> findById(@PathVariable long id) {
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

    @PostMapping
    public ResponseEntity<PetResponse> create(@Valid @RequestBody CreatePetRequest request) {
        Pet pet = mapper.convert(request, Pet.class);
        Pet createdPet = service.create(pet);
        PetResponse response = mapper.convert(createdPet, PetResponse.class);

        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(response);
    }

    @PatchMapping
    public ResponseEntity<PetResponse> update(@Valid @RequestBody UpdatePetRequest request) {
        Pet pet = mapper.convert(request, Pet.class);
        Pet createdPet = service.update(pet);
        PetResponse response = mapper.convert(createdPet, PetResponse.class);

        return ResponseEntity
                .status(HttpStatus.OK)
                .body(response);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteById(@PathVariable long id) {
        service.deleteById(id);

        return ResponseEntity
                .status(HttpStatus.OK)
                .build();
    }
}
