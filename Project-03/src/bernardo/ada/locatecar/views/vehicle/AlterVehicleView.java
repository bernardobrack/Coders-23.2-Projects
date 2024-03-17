package bernardo.ada.locatecar.views.vehicle;

import bernardo.ada.locatecar.controller.VehicleController;
import bernardo.ada.locatecar.controller.interfaces.VehicleControllerI;
import bernardo.ada.locatecar.model.vehicles.Vehicle;
import bernardo.ada.locatecar.views.Showable;
import bernardo.ada.locatecar.views.scanner.ScannerSingleton;

import java.util.Scanner;

public class AlterVehicleView implements Showable {
    private VehicleControllerI vehicleController;
    public AlterVehicleView(VehicleControllerI vehicleController) {
        this.vehicleController = vehicleController;
    }

    @Override
    public void show() {
        Scanner sc = ScannerSingleton.getInstance().getScanner();
        System.out.println("Placa do veículo: ");
        String tag = sc.nextLine();
        Vehicle found = this.vehicleController.searchByTag(tag);
        if(found == null) {
            System.err.println("Veículo não encontrado!");
            return;
        }
        System.out.println("Alterar nome para: ");
        String newName = sc.nextLine();
        this.vehicleController.updateVehicle(newName, tag);
    }
}
