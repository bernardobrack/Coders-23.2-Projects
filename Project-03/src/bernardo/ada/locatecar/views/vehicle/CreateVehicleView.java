package bernardo.ada.locatecar.views.vehicle;

import bernardo.ada.locatecar.controller.VehicleController;
import bernardo.ada.locatecar.controller.interfaces.VehicleControllerI;
import bernardo.ada.locatecar.views.Showable;
import bernardo.ada.locatecar.views.scanner.ScannerSingleton;

import java.util.Scanner;


public class CreateVehicleView implements Showable {
    private VehicleControllerI vehicleController;
    public CreateVehicleView(VehicleControllerI vehicleController) {
        this.vehicleController = vehicleController;
    }
    @Override
    public void show() {
        Scanner sc = ScannerSingleton.getInstance().getScanner();
        System.out.println("Nome do veículo: ");
        String name = sc.nextLine();
        System.out.println("Placa do veículo: ");
        String tag = sc.nextLine();
        System.out.println("Tipo do veículo (P, M, SUV): ");
        String type = sc.nextLine();
        vehicleController.createVehicle(name, tag, type);
    }
}
