package ai.mdotm.pets.application;

import ai.mdotm.pets.domain.Pet;

import java.util.Optional;

public interface PetRepo {

    Optional<Pet> findById(long id);

    Pet save(Pet input);

    void deleteById(long id);

}
