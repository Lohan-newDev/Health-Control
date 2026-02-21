package MedicoExceptions;

public class MedicoNaoExisteException extends RuntimeException {
    public MedicoNaoExisteException(String message) {
        super(message);
    }
}
