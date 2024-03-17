package bernardo.ada.locatecar.views.client;

import bernardo.ada.locatecar.controller.ClientController;
import bernardo.ada.locatecar.controller.interfaces.ClientControllerI;
import bernardo.ada.locatecar.views.Showable;
import bernardo.ada.locatecar.views.scanner.ScannerSingleton;

import java.util.Scanner;

public class CreateClientView implements Showable {
    private ClientControllerI clientController;
    public CreateClientView(ClientControllerI clientController) {
        this.clientController = clientController;
    }
    @Override
    public void show() {
        Scanner sc = ScannerSingleton.getInstance().getScanner();
        System.out.println("Tipo (CPF, CNPJ): ");
        String type = sc.nextLine();
        System.out.println("Nome do cliente: ");
        String name = sc.nextLine();
        System.out.println("Identificador (forneça o CPF ou CNPJ): ");
        String id = sc.nextLine();
        clientController.createClient(id, name, type);
    }
}
