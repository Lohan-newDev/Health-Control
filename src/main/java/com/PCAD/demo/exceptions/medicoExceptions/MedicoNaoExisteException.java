package com.PCAD.demo.exceptions.medicoExceptions;

public class MedicoNaoExisteException extends RuntimeException {
    public MedicoNaoExisteException(String message) {
        super(message);
    }
}
