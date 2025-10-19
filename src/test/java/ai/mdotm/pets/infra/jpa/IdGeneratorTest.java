package ai.mdotm.pets.infra.jpa;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class IdGeneratorTest {

    @Test
    public void whenGenerateIdMultipleTimesThenReturnsUniqueIds() {
        IdGenerator sut = new IdGenerator();

        long id1 = sut.generateId();
        long id2 = sut.generateId();
        long id3 = sut.generateId();

        assertEquals(1000, id1);
        assertEquals(1001, id2);
        assertEquals(1002, id3);

    }
}