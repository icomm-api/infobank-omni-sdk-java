package net.infobank.client.core.exception;

public class MissingFieldException extends ClientException {
    public MissingFieldException() {
        super();
    }
    public MissingFieldException(String message) {
        super(message);
    }
}