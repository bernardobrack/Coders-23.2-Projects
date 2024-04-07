package brack.bernardo.projeto4.service;

import java.util.List;
import java.util.Optional;

public interface Service<T> {

    List<T> list();
    void save(T toSave);
    void update(T toUpdate);
    void delete(T toDelete);
    Optional<T> getById(Long id);
}
