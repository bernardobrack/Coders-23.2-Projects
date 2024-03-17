package bernardo.ada.locatecar.controller;

import bernardo.ada.locatecar.controller.interfaces.ClientControllerI;
import bernardo.ada.locatecar.infra.database.exception.ItemNotFoundException;
import bernardo.ada.locatecar.infra.repository.ClientRepository;
import bernardo.ada.locatecar.infra.repository.ClientRepositoryI;
import bernardo.ada.locatecar.infra.repository.exception.RepositoryException;
import bernardo.ada.locatecar.model.client.Client;
import bernardo.ada.locatecar.model.factory.ClientFactory;
import bernardo.ada.locatecar.model.factory.exception.ClientFactoryException;
import bernardo.ada.locatecar.model.rent.Rentable;

import java.util.Collection;

public class ClientController implements ClientControllerI {
    private ClientRepositoryI repository;
    public ClientController(ClientRepositoryI repository) {
        this.repository = repository;
    }
    public Collection<Client> list() {
        return repository.list();
    }
    public void createClient(String identifier, String name, String type) {
        Client client;
        try {
            client = ClientFactory.createClient(identifier, name, type);
        } catch (ClientFactoryException | InstantiationException ex) {
            System.err.println("Tipo de cliente invalido!");
            return;
        }
        if(!isValidName(name)) {
            System.err.println("Nome inválido!");
            return;
        }
        if(!isValidId(identifier)) {
            System.err.println("Placa inválida!");
            return;
        }
        try {
            this.repository.save(client);
        } catch (RepositoryException e) {
            System.err.println("Cliente já existente!");
        }
    }
    public void updateClient(String name, String id) {
        Client found = this.repository.searchById(id);
        if(found == null) {
            System.err.println("Cliente não encontrado!");
            return;
        }
        if(isValidName(name)) {
            found.setName(name);
            try {
                this.repository.update(found);
            } catch (RepositoryException ex) {
                System.err.println("Cliente não encontrado!");
            }
        }
    }
    public Client searchById(String id) {
        return this.repository.searchById(id);
    }
    public Collection<Client> searchByName(String name) {
        return this.repository.searchByPartOfTheName(name);
    }

    public Collection<Rentable> listRented(String clientId) throws ItemNotFoundException {
        Client client = this.repository.searchById(clientId);
        if(client == null) throw new ItemNotFoundException("Cliente não encontrado!");
        return client.getRented();
    }
    private boolean isValidName(String name) {
        if(name == null) return false;
        if(name.trim().isEmpty()) return false;
        return true;
    }
    private boolean isValidId(String tag) {
        if(tag == null) return false;
        if(tag.trim().isEmpty()) return false;
        return true;
    }

}
