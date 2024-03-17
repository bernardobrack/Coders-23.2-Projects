package bernardo.ada.locatecar.views.client;

import bernardo.ada.locatecar.controller.ClientController;
import bernardo.ada.locatecar.controller.interfaces.ClientControllerI;
import bernardo.ada.locatecar.model.client.Client;
import bernardo.ada.locatecar.views.Showable;
import bernardo.ada.locatecar.views.printer.ClientPrinter;
import bernardo.ada.locatecar.views.printer.Printer;
import bernardo.ada.locatecar.views.scanner.ScannerSingleton;

import java.util.Scanner;

public class SearchClientByIdView implements Showable {
    private ClientControllerI clientController;
    private Printer<Client> printer;
    public SearchClientByIdView(ClientControllerI clientController, ClientPrinter printer) {
        this.clientController = clientController;
        this.printer = printer;
    }
    @Override
    public void show() {
        Scanner sc = ScannerSingleton.getInstance().getScanner();
        System.out.println("Identificador: ");
        String id = sc.nextLine();
        System.out.println("TIPO: IDENTIFICADOR - NOME");
        Client found = this.clientController.searchById(id);
        if(found == null) {
            System.err.println("Cliente não encontrado!");
            return;
        }
        printer.print(found);
    }
}
