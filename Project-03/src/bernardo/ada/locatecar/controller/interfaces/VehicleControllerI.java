package bernardo.ada.locatecar.controller.interfaces;

import bernardo.ada.locatecar.model.vehicles.Vehicle;

import java.util.Collection;
import java.util.List;

public interface VehicleControllerI {
    void createVehicle(String name, String tag, String type);
    void updateVehicle(String name, String tag);
    List<Vehicle> searchByPartOfTheName(String name);
    Vehicle searchByTag(String tag);
    Collection<Vehicle> list();
}
