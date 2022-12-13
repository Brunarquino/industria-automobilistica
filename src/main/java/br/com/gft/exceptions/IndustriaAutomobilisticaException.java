package br.com.gft.exceptions;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.io.Serial;

@AllArgsConstructor
@Getter @Setter
public class IndustriaAutomobilisticaException extends RuntimeException{
    @Serial
    private static final long serialVersionUID = -7614094384596808709L;

    private String message;
}
