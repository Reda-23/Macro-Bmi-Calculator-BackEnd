package io.server.exception;

public class AccountIsMissingException extends Throwable {
    public AccountIsMissingException(String message) {
        super(message);
    }
}
