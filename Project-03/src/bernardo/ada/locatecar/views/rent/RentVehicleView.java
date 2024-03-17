package bernardo.ada.locatecar.views.rent;

import bernardo.ada.locatecar.controller.RentController;
import bernardo.ada.locatecar.controller.interfaces.RentControllerI;
import bernardo.ada.locatecar.infra.database.exception.ItemNotFoundException;
import bernardo.ada.locatecar.infra.repository.exception.RepositoryException;
import bernardo.ada.locatecar.views.Showable;
import bernardo.ada.locatecar.views.scanner.ScannerSingleton;

import java.util.Scanner;

public class RentVehicleView implements Showable {

    private RentControllerI rentController;
    public RentVehicleView(RentControllerI rentController) {
        this.rentController = rentController;
    }

    @Override
    public void show() {
        Scanner sc = ScannerSingleton.getInstance().getScanner();
        System.out.print("Identificador do cliente (CPF ou CNPJ): ");
        String clientId = sc.nextLine();
        System.out.println("Placa do veículo: ");
        String vehicleId = sc.nextLine();
        try {
            rentController.rent(clientId, vehicleId);
        } catch (ItemNotFoundException | RuntimeException | RepositoryException e) {
            System.err.println(e.getMessage());
            return;
        }


    }
}
