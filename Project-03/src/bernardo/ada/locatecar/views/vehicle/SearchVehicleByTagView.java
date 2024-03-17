package bernardo.ada.locatecar.views.vehicle;

import bernardo.ada.locatecar.controller.VehicleController;
import bernardo.ada.locatecar.controller.interfaces.VehicleControllerI;
import bernardo.ada.locatecar.model.vehicles.Vehicle;
import bernardo.ada.locatecar.views.Showable;
import bernardo.ada.locatecar.views.printer.Printer;
import bernardo.ada.locatecar.views.scanner.ScannerSingleton;

import java.util.List;
import java.util.Scanner;

public class SearchVehicleByTagView implements Showable {
    private VehicleControllerI vehicleController;
    private Printer<Vehicle> printer;
    public SearchVehicleByTagView(VehicleControllerI vehicleController, Printer<Vehicle> printer) {
        this.vehicleController = vehicleController;
        this.printer = printer;
    }
    @Override
    public void show() {
        Scanner sc = ScannerSingleton.getInstance().getScanner();
        System.out.println("Tag: ");
        String tag = sc.nextLine();
        Vehicle vehicle = vehicleController.searchByTag(tag);
        if(vehicle == null) {
            System.err.println("Nenhum veículo encontrado!");
            return;
        }
        System.out.println("PLACA - NOME - DATA DE ALUGUEL");
        printer.print(vehicle);

    }
}
