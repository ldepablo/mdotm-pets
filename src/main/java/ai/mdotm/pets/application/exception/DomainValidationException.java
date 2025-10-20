package ai.mdotm.pets.application.exception;

public class DomainValidationException extends RuntimeException {
    public DomainValidationException(String message) { super(message); }
}
