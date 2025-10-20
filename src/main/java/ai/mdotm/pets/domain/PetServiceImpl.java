package ai.mdotm.pets.domain;

import ai.mdotm.pets.application.PetRepo;
import ai.mdotm.pets.application.PetService;
import ai.mdotm.pets.application.exception.DomainValidationException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class PetServiceImpl implements PetService {

    public final PetRepo repo;

    @Autowired
    public PetServiceImpl(PetRepo repo) {
        this.repo = repo;
    }

    @Override
    public Optional<Pet> findById(long id) {
        return repo.findById(id);
    }

    @Override
    public Pet create(Pet pet) {
        if (pet.getId() != null) {
            throw new DomainValidationException("New pet ID must be null when creating.");
        }
        return repo.save(pet);
    }

    @Override
    public Pet update(Pet pet) {
        if (pet.getId() == null) {
            throw new DomainValidationException("ID must be null when updating Pet.");
        }
        return repo.save(pet);
    }

    @Override
    public void deleteById(long id) {
        repo.deleteById(id);
    }
}
