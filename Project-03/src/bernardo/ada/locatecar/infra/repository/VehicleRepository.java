package bernardo.ada.locatecar.infra.repository;

import bernardo.ada.locatecar.infra.database.BancoDeDados;
import bernardo.ada.locatecar.model.vehicles.Vehicle;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

public class VehicleRepository extends DefaultRepository<Vehicle> implements VehicleRepositoryI{
    public VehicleRepository(BancoDeDados<Vehicle> db) {
        super(db);
    }
    public List<Vehicle> searchByPartOfTheName(String name) {
        Collection<Vehicle> collection = this.db.list();
        List<Vehicle> found = new ArrayList<>();
        for (Vehicle curr : collection) {
            if(curr.getNome().toLowerCase().contains(name.toLowerCase())) {
                found.add(curr);
            }
        }
        return Collections.unmodifiableList(found);
    }

    public Vehicle searchByTag(String tag) {
        Collection<Vehicle> collection = this.db.list();
        for(Vehicle curr : collection) {
            if(curr.getPlaca().equalsIgnoreCase(tag)) return curr;
        }
        return null;
    }
    @Override
    public boolean contains(Vehicle v) {
        Collection<Vehicle> collection = this.db.list();
        for(Vehicle curr : collection) {
            if(curr.getPlaca().equalsIgnoreCase(v.getPlaca())) return true;
        }
        return false;
    }
}
