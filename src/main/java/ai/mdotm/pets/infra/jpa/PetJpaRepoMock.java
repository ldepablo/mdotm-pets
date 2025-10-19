package ai.mdotm.pets.infra.jpa;

import ai.mdotm.pets.application.PetRepo;
import ai.mdotm.pets.domain.Pet;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class PetJpaRepoMock implements PetRepo {

    private final IdGenerator idGenerator;

    public PetJpaRepoMock(IdGenerator idGenerator) {
        this.idGenerator = idGenerator;
    }

    @Override
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

    @Override
    public Pet save(Pet input) {
        // Mock CREATE on save if ID is not present
        if (input.getId() == null) {
            long generatedId = idGenerator.generateId();
            return input.withId(generatedId);
        }

        // Mock UPDATE on save if ID is present
        return input;
    }

    @Override
    public void deleteById(long id) {
        // No-op for mock
        // Actually, when there's entity corresponding with the id, JPA silently ignores it.
    }
}
