package bernardo.ada.locatecar.infra.database.exception;

public class ItemNotFoundException extends DataBaseException{
    public ItemNotFoundException(String message) {
        super(message);
    }
}
