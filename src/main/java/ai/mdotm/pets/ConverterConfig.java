package ai.mdotm.pets;

import ai.mdotm.pets.domain.Pet;
import ai.mdotm.pets.infra.jpa.PetJpa;
import ai.mdotm.pets.infra.jpa.mapper.FromJpaPetConverter;
import ai.mdotm.pets.infra.jpa.mapper.ToJpaPetConverter;
import ai.mdotm.pets.infra.rest.CreatePetRequest;
import ai.mdotm.pets.infra.rest.PetResponse;
import ai.mdotm.pets.infra.rest.UpdatePetRequest;
import ai.mdotm.pets.infra.rest.mapper.FromRestCreatePetConverter;
import ai.mdotm.pets.infra.rest.mapper.FromRestUpdatePetConverter;
import ai.mdotm.pets.infra.rest.mapper.ToRestPetConverter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.convert.converter.Converter;

@Configuration
public class ConverterConfig {

    @Bean
    public Converter<PetJpa, Pet> toPetJpaConverter() {
        return new ToJpaPetConverter();
    }

    @Bean
    public Converter<Pet, PetJpa> fromPetJpaConverter() {
        return new FromJpaPetConverter();
    }

    @Bean
    public Converter<Pet, PetResponse> toRestConverter() {
        return new ToRestPetConverter();
    }

    @Bean
    public Converter<CreatePetRequest, Pet> fromRestCreateConverter() {
        return new FromRestCreatePetConverter();
    }

    @Bean
    public Converter<UpdatePetRequest, Pet> fromRestUpdateConverter() {
        return new FromRestUpdatePetConverter();
    }

}