package bernardo.ada.locatecar.infra.database;

import bernardo.ada.locatecar.infra.database.exception.DataBaseException;

import javax.management.InstanceAlreadyExistsException;
import java.util.Collection;

public interface BancoDeDados<T> {
    void add(T obj);
    void delete(T obj) throws DataBaseException;
    void update(T obj);
    Collection<T> list();
}
