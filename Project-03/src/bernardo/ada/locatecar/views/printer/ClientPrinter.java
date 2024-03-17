package bernardo.ada.locatecar.views.printer;

import bernardo.ada.locatecar.model.client.Client;

import java.util.Collection;

public class ClientPrinter implements Printer<Client>{
    @Override
    public void print(Client obj) {
        System.out.println(obj.getType().toUpperCase() + ": " + obj.getId() + " - " + obj.getName());
    }

    @Override
    public void print(Collection<Client> objCollection) {
        for(Client c : objCollection) {
            print(c);
        }
    }
}
