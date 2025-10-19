package ai.mdotm.pets.application;

import ai.mdotm.pets.domain.Pet;

import java.util.Optional;

public interface PetService {

    Optional<Pet> findById(long id);

    Pet create(Pet pet);

    Pet update(Pet pet);

    void deleteById(long id);
}
