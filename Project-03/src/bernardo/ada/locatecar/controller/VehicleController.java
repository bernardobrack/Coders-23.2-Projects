package bernardo.ada.locatecar.controller;

import bernardo.ada.locatecar.controller.interfaces.VehicleControllerI;
import bernardo.ada.locatecar.infra.repository.VehicleRepositoryI;
import bernardo.ada.locatecar.infra.repository.exception.RepositoryException;
import bernardo.ada.locatecar.model.factory.VehicleFactory;
import bernardo.ada.locatecar.model.factory.exception.VehicleFactoryException;
import bernardo.ada.locatecar.model.vehicles.Vehicle;

import java.util.Collection;
import java.util.List;


public class VehicleController implements VehicleControllerI {
    private VehicleRepositoryI repository;
    public VehicleController(VehicleRepositoryI repository) {
        this.repository = repository;
    }
    public Collection<Vehicle> list() {
        return this.repository.list();
    }
    public void createVehicle(String name, String tag, String type) {
        Vehicle vehicle;
        try {
            vehicle = VehicleFactory.createVehicle(name, tag, type);
        } catch (VehicleFactoryException ex) {
            System.err.println("Tipo de veículo invalido!");
            return;
        }
        if(!isValidName(name)) {
            System.err.println("Nome inválido!");
            return;
        }
        if(!isValidTag(tag)) {
            System.err.println("Placa inválida!");
            return;
        }
        try {
            this.repository.save(vehicle);
        } catch (RepositoryException e) {
            System.err.println("Veículo já existente!");
        }
    }
    public void updateVehicle(String name, String tag) {
        Vehicle found = this.repository.searchByTag(tag);
        if(found == null) {
            System.err.println("Veículo não encontrado!");
            return;
        }
        if(isValidName(name)) {
            found.setNome(name);
            try {
                this.repository.update(found);
            } catch (RepositoryException ex) {
                System.err.println("Veículo não encontrado!");
            }
        }
    }
    public List<Vehicle> searchByPartOfTheName(String name) {
        return this.repository.searchByPartOfTheName(name);
    }
    public Vehicle searchByTag(String tag) {
        return this.repository.searchByTag(tag);
    }
    private boolean isValidName(String name) {
        if(name == null) return false;
        if(name.trim().isEmpty()) return false;
        return true;
    }
    private boolean isValidTag(String name) {
        if(name == null) return false;
        if(name.trim().isEmpty()) return false;
        return true;
    }
}
