package bernardo.ada.locatecar.infra.repository;

import bernardo.ada.locatecar.infra.database.BancoDeDados;
import bernardo.ada.locatecar.model.client.Client;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;

public class ClientRepository extends DefaultRepository<Client> implements ClientRepositoryI{
    public ClientRepository(BancoDeDados<Client> db) {
        super(db);
    }
    public Client searchById(String id) {
        Collection<Client> clients = db.list();
        for(Client client : clients) {
            if(client.getId().equalsIgnoreCase(id)) return client;
        }
        return null;
    }

    public Collection<Client> searchByPartOfTheName(String name) {
        Collection<Client> clients = db.list();
        Collection<Client> found = new ArrayList<>();
        for(Client client : clients) {
            if(client.getName().toLowerCase().contains(name.toLowerCase())) {
                found.add(client);
            }
        }
        return Collections.unmodifiableCollection(found);
    }
    @Override
    public boolean contains(Client c) {
        Collection<Client> collection = this.db.list();
        for(Client curr : collection) {
            if(curr.getId().equalsIgnoreCase(c.getId())) return true;
        }
        return false;
    }
}
