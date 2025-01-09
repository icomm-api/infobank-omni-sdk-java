package net.infobank.client.core.exception;

public class ResponseParseException extends UnexpectedException {
    public ResponseParseException(String message) {
        this(message, null);
    }

    public ResponseParseException(String message, Throwable t) {
        super(message, t);
    }
}
