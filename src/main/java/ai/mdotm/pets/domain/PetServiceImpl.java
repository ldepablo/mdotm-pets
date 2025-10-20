package ai.mdotm.pets.domain;

import ai.mdotm.pets.application.PetRepo;
import ai.mdotm.pets.application.PetService;
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
        //FIXME If pet ID is NOT null, exception should be thrown.
        return repo.save(pet);
    }

    @Override
    public Pet update(Pet pet) {
        //FIXME If pet ID IS null, exception should be thrown.
        return repo.save(pet);
    }

    @Override
    public void deleteById(long id) {
        repo.deleteById(id);
    }
}
