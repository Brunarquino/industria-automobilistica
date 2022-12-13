package br.com.gft.exceptions;

import java.io.Serial;

public class ColumnNotNullException extends IndustriaAutomobilisticaException{
    @Serial
    private static final long serialVersionUID = 7257854945384301817L;

    public ColumnNotNullException(String message) {
        super(message);
    }
}
