package bernardo.ada.locatecar.infra.repository;

import bernardo.ada.locatecar.model.vehicles.Vehicle;

import java.util.List;

public interface VehicleRepositoryI extends Repository<Vehicle>{
    List<Vehicle> searchByPartOfTheName(String name);
    Vehicle searchByTag(String tag);
}
