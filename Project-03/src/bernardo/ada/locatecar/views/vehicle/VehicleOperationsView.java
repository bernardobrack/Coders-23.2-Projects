package bernardo.ada.locatecar.views.vehicle;

import bernardo.ada.locatecar.controller.VehicleController;
import bernardo.ada.locatecar.controller.interfaces.VehicleControllerI;
import bernardo.ada.locatecar.views.menu.Menu;
import bernardo.ada.locatecar.views.printer.VehiclePrinter;

public class VehicleOperationsView extends Menu {

    private VehicleControllerI vehicleController;
    public VehicleOperationsView(VehicleControllerI vehicleController) {
        super(new String[] {
                "1 - Cadastrar veículo",
                "2 - Alterar veículo",
                "3 - Buscar veículo",
                "4 - Listar veículos",
                "0 - Sair"
        });
        this.vehicleController = vehicleController;
    }

    @Override
    public void executeOption(int option) {
        switch (option) {
            case 0: return;
            case 1: new CreateVehicleView(vehicleController).show(); break;
            case 2: new AlterVehicleView(vehicleController).show(); break;
            case 3: new SearchVehicleView(vehicleController).show(); break;
            case 4: new ListVehiclesView(vehicleController, new VehiclePrinter()).show(); break;
            default: break;
        }
    }
}
