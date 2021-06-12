package model.Exceptions;

public class JogadorNaoEstaPresenteException extends Exception {
    public JogadorNaoEstaPresenteException() {
        super();
    }
    JogadorNaoEstaPresenteException(String s) {
        super(s);
    }
}
