package bernardo.ada.locatecar.views.vehicle;

import bernardo.ada.locatecar.controller.VehicleController;
import bernardo.ada.locatecar.controller.interfaces.VehicleControllerI;
import bernardo.ada.locatecar.model.vehicles.Vehicle;
import bernardo.ada.locatecar.views.Showable;
import bernardo.ada.locatecar.views.printer.Printer;

import java.util.Collection;

public class ListVehiclesView implements Showable {
    private VehicleControllerI vehicleController;
    private Printer<Vehicle> vehiclePrinter;
    public ListVehiclesView(VehicleControllerI vehicleController, Printer<Vehicle> vehiclePrinter) {
        this.vehicleController = vehicleController;
        this.vehiclePrinter = vehiclePrinter;
    }

    @Override
    public void show() {
        Collection<Vehicle> collection = vehicleController.list();
        System.out.println("PLACA - NOME - DATA DE ALUGUEL");
        for(Vehicle v : collection) {
            vehiclePrinter.print(v);
        }

    }
}
