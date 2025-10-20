package ai.mdotm.pets.domain;

import ai.mdotm.pets.application.exception.DomainValidationException;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertThrows;


class PetTest {

    @Test
    public void shouldThrowExceptionWithEmptyName() {
        var builder = new Pet.Builder()
                .species("Cat")
                .age(2)
                .ownerName("Bob");

        assertThrows(DomainValidationException.class, builder::build);
    }

    @Test
    public void shouldThrowExceptionWithEmptySpecies() {
        var builder = new Pet.Builder()
                .name("Whiskers")
                .age(2)
                .ownerName("Bob");

        assertThrows(DomainValidationException.class, builder::build);
    }

    @Test
    public void shouldThrowExceptionWithNegativeAge() {
        var builder = new Pet.Builder()
                .name("Whiskers")
                .species("Cat")
                .age(-1)
                .ownerName("Bob");

        assertThrows(DomainValidationException.class, builder::build);
    }
}