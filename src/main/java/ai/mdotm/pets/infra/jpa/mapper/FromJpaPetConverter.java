package ai.mdotm.pets.infra.jpa.mapper;

import ai.mdotm.pets.domain.Pet;
import ai.mdotm.pets.infra.jpa.PetJpa;
import org.springframework.core.convert.converter.Converter;

public class FromJpaPetConverter implements Converter<Pet, PetJpa> {

    @Override
    public PetJpa convert(Pet jpa) {
        return new PetJpa.Builder()
                .id(jpa.getId())
                .name(jpa.getName())
                .species(jpa.getSpecies())
                .age(jpa.getAge())
                .ownerName(jpa.getOwnerName())
                .build();
    }

}
