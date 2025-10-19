package ai.mdotm.pets.infra.jpa;

import ai.mdotm.pets.domain.Pet;

import java.util.Optional;

public class PetJpaRepoMock {

    private final IdGenerator idGenerator;

    public PetJpaRepoMock(IdGenerator idGenerator) {
        this.idGenerator = idGenerator;
    }

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

    public Pet save(Pet input) {
        //Since there's no real DB and JPA would return created entity, we just need to return same Pet with newly
        // generated ID
        long generatedId = idGenerator.generateId();
        return input.withId(generatedId);
    }
}
