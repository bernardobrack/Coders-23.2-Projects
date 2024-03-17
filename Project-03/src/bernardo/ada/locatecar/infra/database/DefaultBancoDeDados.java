package bernardo.ada.locatecar.infra.database;


import bernardo.ada.locatecar.infra.database.exception.ItemAlreadyExistsException;
import bernardo.ada.locatecar.infra.database.exception.ItemNotFoundException;

import java.util.Collection;
import java.util.Collections;
import java.util.Set;

public class DefaultBancoDeDados<T> implements BancoDeDados<T>{
    protected Set<T> data;

    public DefaultBancoDeDados(Set<T> storageStructure) {
        this.data = storageStructure;
    }
    @Override
    public void add(T obj) {
        this.data.add(obj);
    }

    @Override
    public void delete(T obj) throws ItemNotFoundException {
        boolean contains = this.data.remove(obj);
        if(!contains) throw new ItemNotFoundException("Item para deletar não encontrado!");
    }

    @Override
    public void update(T obj) {
        this.data.remove(obj);
        this.data.add(obj);
    }
    @Override
    public Collection<T> list() {
        return Collections.unmodifiableCollection(this.data);
    }
}
