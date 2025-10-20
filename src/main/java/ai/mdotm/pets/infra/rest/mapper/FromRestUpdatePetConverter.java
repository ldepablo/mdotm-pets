package ai.mdotm.pets.infra.rest.mapper;

import ai.mdotm.pets.domain.Pet;
import ai.mdotm.pets.infra.rest.dto.UpdatePetRequest;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component
public class FromRestUpdatePetConverter implements Converter<UpdatePetRequest, Pet> {

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
