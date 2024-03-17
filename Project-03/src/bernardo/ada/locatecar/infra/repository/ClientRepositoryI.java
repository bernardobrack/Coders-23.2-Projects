package bernardo.ada.locatecar.infra.repository;

import bernardo.ada.locatecar.model.client.Client;

import java.util.Collection;

public interface ClientRepositoryI extends Repository<Client>{
    Client searchById(String id);
    Collection<Client> searchByPartOfTheName(String name);

}
