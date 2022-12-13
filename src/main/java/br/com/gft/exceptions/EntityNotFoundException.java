package br.com.gft.exceptions;

import java.io.Serial;

public class EntityNotFoundException extends IndustriaAutomobilisticaException {
    @Serial
    private static final long serialVersionUID = 7257854945384301817L;

    public EntityNotFoundException(String message) {
        super(message);
    }
}
