package ai.mdotm.pets.infra.rest.mapper;

import ai.mdotm.pets.domain.Pet;
import ai.mdotm.pets.infra.rest.CreatePetRequest;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component
public class FromRestCreatePetConverter implements Converter<CreatePetRequest, Pet> {

    @Override
    public Pet convert(CreatePetRequest request) {

        return Pet.builder()
                .name(request.name())
                .species(request.species())
                .age(request.age())
                .ownerName(request.ownerName())
                .build();

    }

}
