package bernardo.ada.locatecar.views.client;

import bernardo.ada.locatecar.controller.ClientController;
import bernardo.ada.locatecar.controller.interfaces.ClientControllerI;
import bernardo.ada.locatecar.views.Showable;
import bernardo.ada.locatecar.views.scanner.ScannerSingleton;

import java.util.Scanner;

public class AlterClientView implements Showable {
    private ClientControllerI clientController;
    public AlterClientView(ClientControllerI clientController) {
        this.clientController = clientController;
    }
    @Override
    public void show() {
        Scanner sc = ScannerSingleton.getInstance().getScanner();
        System.out.println("Identificador do cliente: ");
        String id = sc.nextLine();
        System.out.println("Novo nome: ");
        String name = sc.nextLine();
        this.clientController.updateClient(name, id);
    }
}
