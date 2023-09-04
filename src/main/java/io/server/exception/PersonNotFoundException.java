package io.server.exception;

public class PersonNotFoundException extends Throwable {
    public PersonNotFoundException(String message) {
        super(message);
    }
}
