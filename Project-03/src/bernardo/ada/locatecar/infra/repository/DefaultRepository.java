package bernardo.ada.locatecar.infra.repository;

import bernardo.ada.locatecar.infra.database.BancoDeDados;
import bernardo.ada.locatecar.infra.database.exception.DataBaseException;
import bernardo.ada.locatecar.infra.repository.exception.RepositoryException;

import javax.management.InstanceAlreadyExistsException;
import javax.xml.crypto.Data;
import java.util.Collection;

public class DefaultRepository<T> implements Repository<T>{
    BancoDeDados<T> db;
    public DefaultRepository(BancoDeDados<T> db) {
        this.db = db;
    }
    @Override
    public void save(T obj) throws RepositoryException {
        if(contains(obj)) {
            throw new RepositoryException("Veículo já existente!");
        }
        this.db.add(obj);
    }
    @Override
    public Collection<T> list() {
        return this.db.list();
    }

    @Override
    public void delete(T obj) throws RepositoryException {
        try {
            this.db.delete(obj);
        } catch (DataBaseException e) {
            throw new RepositoryException("Error deleting object!");
        }
    }

    @Override
    public void update(T obj) throws RepositoryException {
        if(contains(obj)) {
            this.db.update(obj);
            return;
        }
        throw new RepositoryException("Error updating object!");
    }

    @Override
    public boolean contains(T obj) {
        return false;
    }

}
