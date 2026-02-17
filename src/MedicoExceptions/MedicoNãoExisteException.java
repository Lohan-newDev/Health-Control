package MedicoExceptions;

public class MedicoNãoExisteException extends RuntimeException {
    public MedicoNãoExisteException(String message) {
        super(message);
    }
}
