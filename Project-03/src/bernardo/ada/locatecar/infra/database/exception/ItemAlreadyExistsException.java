package bernardo.ada.locatecar.infra.database.exception;

public class ItemAlreadyExistsException extends DataBaseException{

    public ItemAlreadyExistsException(String message) {
        super(message);
    }
}
