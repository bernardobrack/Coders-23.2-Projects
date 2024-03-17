package bernardo.ada.locatecar.model.client;

import bernardo.ada.locatecar.model.rent.RentCalculable;
import bernardo.ada.locatecar.model.rent.Rentable;
import bernardo.ada.locatecar.model.rent.Renter;

import java.util.Collection;
import java.util.Set;

public abstract class Client implements Renter {
    private final String identificador;
    protected String name;
    protected Set<Rentable> rented;
    protected RentCalculable rentCalculator;


    protected Client(String identificador, String name, Set<Rentable> rented) throws InstantiationException {
        this.identificador = identificador;
        this.name = name;
        this.rented = rented;
        if(!validateId()) throw new InstantiationException("Invalid id!");
    }

    @Override
    public void rent(Rentable toRent) {
        this.rented.add(toRent);
    }

    @Override
    public void unRent(Rentable rented) {
        this.rented.remove(rented);
    }

    @Override
    public Collection<Rentable> getRented() {
        return this.rented;
    }
    public abstract boolean validateId();
    public String getId() {
        return this.identificador;
    }
    public String getName() {
        return this.name;
    }
    public abstract String getType();
    public void setName(String name) {
        this.name = name;
    }


}
