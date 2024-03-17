package bernardo.ada.locatecar.controller.interfaces;

import bernardo.ada.locatecar.infra.database.exception.ItemNotFoundException;
import bernardo.ada.locatecar.model.client.Client;
import bernardo.ada.locatecar.model.rent.Rentable;

import java.util.Collection;

public interface ClientControllerI {
    void createClient(String identifier, String name, String type);
    void updateClient(String name, String id);
    Client searchById(String id);
    Collection<Client> searchByName(String name);
    Collection<Client> list();
    Collection<Rentable> listRented(String clientId) throws ItemNotFoundException;
}
