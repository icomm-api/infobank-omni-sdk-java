package net.infobank.client.core.exception;

public class MethodFailedException extends ClientException {
    public MethodFailedException() {
        super();
    }

    public MethodFailedException(String message) {
        super(message);
    }

    public MethodFailedException(String message, Throwable cause) {
        super(message, cause);
    }

    public MethodFailedException(Throwable cause) {
        super(cause);
    }
}
