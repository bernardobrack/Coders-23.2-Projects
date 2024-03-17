package bernardo.ada.locatecar.views.vehicle;

import bernardo.ada.locatecar.controller.VehicleController;
import bernardo.ada.locatecar.controller.interfaces.VehicleControllerI;
import bernardo.ada.locatecar.views.menu.Menu;
import bernardo.ada.locatecar.views.printer.VehiclePrinter;

public class SearchVehicleView extends Menu {
    private VehicleControllerI vehicleController;
    protected SearchVehicleView(VehicleControllerI vehicleController) {
        super(new String[] {
                "1 - Por nome",
                "2 - Por placa",
                "0 - Sair"
        });
        this.vehicleController = vehicleController;
    }

    @Override
    protected void executeOption(int option) {
        switch (option) {
            case 1: new SearchVehicleByNameView(vehicleController, new VehiclePrinter()).show(); break;
            case 2: new SearchVehicleByTagView(vehicleController, new VehiclePrinter()).show(); break;
            case 0: return;
            default: show();
        }
    }
}
