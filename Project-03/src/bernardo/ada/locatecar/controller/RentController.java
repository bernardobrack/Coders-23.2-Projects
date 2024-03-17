package bernardo.ada.locatecar.controller;

import bernardo.ada.locatecar.controller.interfaces.RentControllerI;
import bernardo.ada.locatecar.infra.database.exception.ItemNotFoundException;
import bernardo.ada.locatecar.infra.repository.ClientRepository;
import bernardo.ada.locatecar.infra.repository.ClientRepositoryI;
import bernardo.ada.locatecar.infra.repository.VehicleRepository;
import bernardo.ada.locatecar.infra.repository.VehicleRepositoryI;
import bernardo.ada.locatecar.infra.repository.exception.RepositoryException;
import bernardo.ada.locatecar.model.client.Client;
import bernardo.ada.locatecar.model.rent.Renter;
import bernardo.ada.locatecar.model.vehicles.Vehicle;

public class RentController implements RentControllerI {

    private ClientRepositoryI clientRepository;
    private VehicleRepositoryI vehicleRepository;
    public RentController(ClientRepositoryI clientRepository, VehicleRepositoryI vehicleRepository) {
        this.clientRepository = clientRepository;
        this.vehicleRepository = vehicleRepository;
    }

    public void unrent(String tag) throws ItemNotFoundException, RepositoryException {
        Vehicle vehicleFound = this.vehicleRepository.searchByTag(tag);
        if(vehicleFound == null) {
            throw new ItemNotFoundException("Veículo não encontrado!");
        }
        if(!vehicleFound.isRented()) {
            throw new RuntimeException("Veículo não está alugado!");
        }
        Renter rentedBy = vehicleFound.rentedBy();
        rentedBy.unRent(vehicleFound);
        vehicleFound.unrent();
        this.vehicleRepository.update(vehicleFound);
        this.clientRepository.update((Client) rentedBy);

    }

    public void rent(String clientId, String vehicleId) throws ItemNotFoundException, RepositoryException {
        Client clientFound = this.clientRepository.searchById(clientId);
        Vehicle vehicleFound = this.vehicleRepository.searchByTag(vehicleId);
        if(clientFound == null) {
            throw new ItemNotFoundException("Cliente não encontrado!");
        }
        if(vehicleFound == null) {
            throw new ItemNotFoundException("Veículo não encontrado!");
        }
        if(vehicleFound.isRented()) {
            throw new RuntimeException("Veículo já está alugado!");
        }
        clientFound.rent(vehicleFound);
        vehicleFound.rent(clientFound);
        clientRepository.update(clientFound);
        vehicleRepository.update(vehicleFound);

    }

    public Double calculateRent(String clientId, String vehicleTag) throws ItemNotFoundException, Exception {
        Client clientFound = this.clientRepository.searchById(clientId);
        Vehicle vehicleFound = this.vehicleRepository.searchByTag(vehicleTag);
        if(clientFound == null) {
            throw new ItemNotFoundException("Cliente não encontrado!");
        }
        if(vehicleFound == null) {
            throw new ItemNotFoundException("Veículo não encontrado!");
        }

        return clientFound.calculateRent(vehicleFound);


    }

}
