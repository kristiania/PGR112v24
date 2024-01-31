package lectures._06.exception;

public class InputPhoneNotCorrectException extends Exception
{
    public InputPhoneNotCorrectException() {
        super("Telefonnummeret gitt er ikke riktig lengde!");
    }
}
