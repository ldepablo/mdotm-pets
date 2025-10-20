package ai.mdotm.pets.infra.rest.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.PositiveOrZero;

public record UpdatePetRequest(
        @NotNull Long id,
        @NotBlank String name,
        @NotBlank String species,
        @PositiveOrZero Integer age,
        String ownerName
) {}