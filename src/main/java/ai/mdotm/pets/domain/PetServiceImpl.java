package ai.mdotm.pets.domain;

import ai.mdotm.pets.application.PetRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class PetServiceImpl {

    public final PetRepo repo;

    @Autowired
    public PetServiceImpl(PetRepo repo) {
        this.repo = repo;
    }

    public Optional<Pet> findById(long id) {
        return repo.findById(id);
    }

    public Pet create(Pet pet) {
        //FIXME If pet ID is NOT null, exception should be thrown.
        return repo.save(pet);
    }

    public Pet update(Pet pet) {
        //FIXME If pet ID IS null, exception should be thrown.
        return repo.save(pet);
    }

    public void deleteById(long id) {

        repo.deleteById(id);
        System.out.println("check");
    }
}
