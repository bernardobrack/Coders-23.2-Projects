package bernardo.ada.locatecar.views.client;

import bernardo.ada.locatecar.controller.ClientController;
import bernardo.ada.locatecar.controller.interfaces.ClientControllerI;
import bernardo.ada.locatecar.model.client.Client;
import bernardo.ada.locatecar.views.Showable;
import bernardo.ada.locatecar.views.printer.Printer;
import bernardo.ada.locatecar.views.scanner.ScannerSingleton;

import java.util.Collection;
import java.util.Scanner;

public class SearchClientByNameView implements Showable {

    private ClientControllerI clientController;
    private Printer<Client> printer;

    public SearchClientByNameView(ClientControllerI clientController, Printer<Client> printer) {
        this.clientController = clientController;
        this.printer = printer;
    }

    @Override
    public void show() {
        Scanner sc = ScannerSingleton.getInstance().getScanner();
        System.out.println("Nome: ");
        String name = sc.nextLine();
        Collection<Client> found = clientController.searchByName(name);
        if(found.isEmpty()){
            System.err.println("Nenhum cliente encontrado!");
            return;
        }
        System.out.println("TIPO: IDENTIFICADOR - NOME");
        printer.print(found);
    }
}
