package ai.mdotm.pets.infra.jpa;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import java.util.Objects;


@Entity
@Table(name = "pets")
public class PetJpa {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private final Long id;

    @NotBlank
    @Column(nullable = false)
    private final String name;

    @NotBlank
    @Column(nullable = false)
    private final String species;

    @PositiveOrZero
    @Column
    private final Integer age;

    @Column
    private final String ownerName;

    private PetJpa(Builder builder) {

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

        public PetJpa build() {
            return new PetJpa(this);
        }
    }

    @Override
    public boolean equals(Object o) {
        if (!(o instanceof PetJpa pet)) return false;
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
