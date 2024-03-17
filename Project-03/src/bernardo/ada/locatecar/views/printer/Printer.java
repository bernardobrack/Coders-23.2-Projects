package bernardo.ada.locatecar.views.printer;

import java.util.Collection;

public interface Printer<T> {
    void print(T obj);
    void print(Collection<T> objCollection);
}
