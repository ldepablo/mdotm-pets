package ai.mdotm.pets.infra.jpa;

import ai.mdotm.pets.domain.Pet;

import java.util.Optional;

public class PetJpaRepoMock {

    public Optional<Pet> findById(long id) {

        if (id == 1234L) {
            // Mocks not found for ID 1234L
            return Optional.empty();
        }

        Pet pet = new Pet.Builder()
                .id(1001L)
                .name("Archie")
                .species("Dog")
                .age(8)
                .ownerName("Arthur")
                .build();
        return Optional.of(pet);
    }
}
