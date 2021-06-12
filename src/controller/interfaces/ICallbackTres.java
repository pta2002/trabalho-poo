package controller.interfaces;

import model.Exceptions.JogadoresInvalidosException;

public interface ICallbackTres<T, U, J> {
    public void run(T um, U dois, J tres);
}
