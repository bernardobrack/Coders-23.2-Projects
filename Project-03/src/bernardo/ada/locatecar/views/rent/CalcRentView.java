package bernardo.ada.locatecar.views.rent;

import bernardo.ada.locatecar.controller.RentController;
import bernardo.ada.locatecar.controller.interfaces.RentControllerI;
import bernardo.ada.locatecar.infra.database.exception.ItemNotFoundException;
import bernardo.ada.locatecar.views.Showable;
import bernardo.ada.locatecar.views.scanner.ScannerSingleton;

import java.util.Scanner;

public class CalcRentView implements Showable {

    private RentControllerI rentController;

    public CalcRentView(RentControllerI rentController) {
        this.rentController = rentController;
    }

    @Override
    public void show() {
        Scanner sc = ScannerSingleton.getInstance().getScanner();
        System.out.println("Identificador do cliente (CPF ou CNPJ): ");
        String clientId = sc.nextLine();
        System.out.println("Placa do veículo: ");
        String tag = sc.nextLine();
        Double price;
        try {
            price = rentController.calculateRent(clientId, tag);
        } catch (Exception e) {
            System.err.println(e.getMessage());
            return;
        }
        System.out.printf("Preço do aluguel: R$ %.2f\n", price.floatValue());
    }
}
