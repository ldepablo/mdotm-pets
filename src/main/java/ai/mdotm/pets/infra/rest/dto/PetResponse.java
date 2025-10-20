package ai.mdotm.pets.infra.rest.dto;

public record PetResponse(Long id, String name, String species, Integer age, String ownerName) { }
