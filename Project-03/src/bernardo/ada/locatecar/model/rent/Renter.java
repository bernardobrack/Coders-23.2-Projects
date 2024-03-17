package bernardo.ada.locatecar.model.rent;

import java.util.Collection;

public interface Renter {
    void rent(Rentable toRent);
    void unRent(Rentable rented);
    Double calculateRent(Rentable rentable) throws Exception;
    Collection<Rentable> getRented();
    String getId();
}
