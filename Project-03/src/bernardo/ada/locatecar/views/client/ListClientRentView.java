package bernardo.ada.locatecar.views.client;

import bernardo.ada.locatecar.controller.interfaces.ClientControllerI;
import bernardo.ada.locatecar.infra.database.exception.ItemNotFoundException;
import bernardo.ada.locatecar.model.rent.Rentable;
import bernardo.ada.locatecar.views.Showable;
import bernardo.ada.locatecar.views.printer.Printer;
import bernardo.ada.locatecar.views.scanner.ScannerSingleton;

import java.util.Collection;
import java.util.Scanner;

public class ListClientRentView implements Showable {

    private ClientControllerI clientController;
    private Printer<Rentable> printer;
    public ListClientRentView(ClientControllerI clientController, Printer<Rentable> printer) {
        this.clientController = clientController;
        this.printer = printer;
    }

    @Override
    public void show() {
        Scanner sc = ScannerSingleton.getInstance().getScanner();
        System.out.print("Identificador do cliente (informe o CPF ou CNPJ): ");
        String id = sc.nextLine();
        Collection<Rentable> collection;
        try {
            collection = clientController.listRented(id);
        } catch (ItemNotFoundException e) {
            System.err.println(e.getMessage());
            return;
        }
        System.out.println();
        printer.print(collection);

    }
}
