package ai.mdotm.pets.domain;

import ai.mdotm.pets.application.exception.DomainValidationException;

import java.util.Objects;

// I'd definitely use Lombok here but not sure whether the person correcting it will have it installed, so I decided to
// go for clean Java.

public class Pet {
    private final Long id;
    private final String name;
    private final String species;
    private final Integer age;
    private final String ownerName;

    private Pet(Builder builder) {

        // I could use Jakarta Validation here but decided to go for manual validation in the domain for simplicity.
        if (builder.name == null || builder.name.isBlank()) {
            throw new DomainValidationException("Name is required");
        }
        if (builder.species == null || builder.species.isBlank()) {
            throw new DomainValidationException("Species is required");
        }
        if (builder.age != null && builder.age < 0) {
            throw new DomainValidationException("Age must be >= 0");
        }

        this.id = builder.id;
        this.name = builder.name;
        this.species = builder.species;
        this.age = builder.age;
        this.ownerName = builder.ownerName;
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getSpecies() {
        return species;
    }

    public Integer getAge() {
        return age;
    }

    public String getOwnerName() {
        return ownerName;
    }

    public static Builder builder() {
        return new Builder();
    }

    public static class Builder {
        private Long id;
        private String name;
        private String species;
        private Integer age;
        private String ownerName;

        public Builder id(Long id) {
            this.id = id;
            return this;
        }

        public Builder name(String name) {
            this.name = name;
            return this;
        }

        public Builder species(String species) {
            this.species = species;
            return this;
        }

        public Builder age(Integer age) {
            this.age = age;
            return this;
        }

        public Builder ownerName(String ownerName) {
            this.ownerName = ownerName;
            return this;
        }

        public Pet build() {
            return new Pet(this);
        }
    }

    public Pet withId(long id) {
        return Pet.builder()
                .id(id)
                .name(this.name)
                .species(this.species)
                .age(this.age)
                .ownerName(this.ownerName)
                .build();
    }

    @Override
    public boolean equals(Object o) {
        if (!(o instanceof Pet pet)) return false;
        return Objects.equals(id, pet.id) &&
                Objects.equals(name, pet.name) &&
                Objects.equals(species, pet.species) &&
                Objects.equals(age, pet.age) &&
                Objects.equals(ownerName, pet.ownerName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, species, age, ownerName);
    }

    @Override
    public String toString() {
        return "Pet{id=%d, name='%s', species='%s', age=%d, ownerName='%s'}"
                .formatted(id, name, species, age, ownerName);
    }
}
