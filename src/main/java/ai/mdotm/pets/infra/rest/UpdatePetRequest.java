package ai.mdotm.pets.infra.rest;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.PositiveOrZero;

public record UpdatePetRequest(
        long id,
        @NotBlank String name,
        @NotBlank String species,
        @PositiveOrZero Integer age,
        String ownerName
) {}