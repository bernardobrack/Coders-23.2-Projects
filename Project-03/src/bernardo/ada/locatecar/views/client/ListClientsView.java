package bernardo.ada.locatecar.views.client;

import bernardo.ada.locatecar.controller.ClientController;
import bernardo.ada.locatecar.controller.interfaces.ClientControllerI;
import bernardo.ada.locatecar.model.client.Client;
import bernardo.ada.locatecar.views.Showable;
import bernardo.ada.locatecar.views.printer.Printer;

import java.util.Collection;

public class ListClientsView implements Showable {

    private ClientControllerI clientController;
    private Printer<Client> printer;
    public ListClientsView(ClientControllerI clientController, Printer<Client> printer) {
        this.clientController = clientController;
        this.printer = printer;
    }

    @Override
    public void show() {
        Collection<Client> collection =  clientController.list();
        System.out.println("TIPO: IDENTIFICADOR - NOME");
        printer.print(collection);
    }
}
