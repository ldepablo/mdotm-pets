package ai.mdotm.pets.infra.rest;

import ai.mdotm.pets.application.PetService;
import ai.mdotm.pets.domain.Pet;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.ConversionService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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

    public ResponseEntity<PetResponse> create(CreatePetRequest request) {
        Pet pet = mapper.convert(request, Pet.class);
        Pet createdPet = service.create(pet);
        PetResponse response = mapper.convert(createdPet, PetResponse.class);

        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(response);
    }

    public ResponseEntity<PetResponse> update(UpdatePetRequest request) {
        Pet pet = mapper.convert(request, Pet.class);
        Pet createdPet = service.update(pet);
        PetResponse response = mapper.convert(createdPet, PetResponse.class);

        return ResponseEntity
                .status(HttpStatus.OK)
                .body(response);
    }

    public ResponseEntity<Void> deleteById(long id) {
        service.deleteById(id);

        return ResponseEntity
                .status(HttpStatus.OK)
                .build();
    }
}
