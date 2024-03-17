package bernardo.ada.locatecar.views.rent;

import bernardo.ada.locatecar.controller.RentController;
import bernardo.ada.locatecar.controller.interfaces.RentControllerI;
import bernardo.ada.locatecar.infra.database.exception.ItemNotFoundException;
import bernardo.ada.locatecar.infra.repository.exception.RepositoryException;
import bernardo.ada.locatecar.views.Showable;
import bernardo.ada.locatecar.views.scanner.ScannerSingleton;

import java.util.Scanner;

public class FreeVehicleView implements Showable {

    private RentControllerI rentController;


    public FreeVehicleView(RentControllerI rentController) {
        this.rentController = rentController;
    }

    @Override
    public void show() {
        Scanner sc = ScannerSingleton.getInstance().getScanner();
        System.out.println("Placa do veículo a ser liberado: ");
        String tag = sc.nextLine();
        try {
            this.rentController.unrent(tag);
        } catch (ItemNotFoundException | RepositoryException e) {
            System.err.println(e.getMessage());
            return;
        }
    }
}
