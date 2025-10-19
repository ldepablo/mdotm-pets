package ai.mdotm.pets.infra.jpa;

import org.springframework.stereotype.Component;

/**
 * A simple ID generator that generates unique IDs starting from 1000.
 */
@Component
public class IdGenerator {

    private long currentId = 1000L;

    public synchronized long generateId() {
        return currentId++;
    }
}
