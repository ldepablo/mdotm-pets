package ai.mdotm.pets.infra.rest;

public record PetResponse(Long id, String name, String species, Integer age, String ownerName) { }
