package ai.mdotm.pets.infra.rest.mapper;

import ai.mdotm.pets.domain.Pet;
import ai.mdotm.pets.infra.rest.UpdatePetRequest;

public class FromRestUpdatePetConverter {
    public Pet convert(UpdatePetRequest request) {

        return Pet.builder()
                .id(request.id())
                .name(request.name())
                .species(request.species())
                .age(request.age())
                .ownerName(request.ownerName())
                .build();
    }
}
