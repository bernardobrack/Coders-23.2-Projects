package bernardo.ada.locatecar.infra.repository;
import bernardo.ada.locatecar.infra.repository.exception.RepositoryException;

import java.util.Collection;

public interface Repository<T> {
    void save(T obj) throws RepositoryException;
    Collection<T> list();
    void delete(T obj) throws RepositoryException;
    void update(T obj) throws RepositoryException;
    boolean contains(T obj);
}
