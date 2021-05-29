package model.Exceptions.Equipa;

public class EquipaNaoExisteException extends Exception{
    public EquipaNaoExisteException() {
        super();
    }
    public EquipaNaoExisteException(String m) {
        super(m);
    }
}
