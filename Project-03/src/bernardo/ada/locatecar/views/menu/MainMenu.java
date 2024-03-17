package bernardo.ada.locatecar.views.menu;


import bernardo.ada.locatecar.controller.ClientController;
import bernardo.ada.locatecar.controller.RentController;
import bernardo.ada.locatecar.controller.VehicleController;
import bernardo.ada.locatecar.controller.interfaces.ClientControllerI;
import bernardo.ada.locatecar.controller.interfaces.RentControllerI;
import bernardo.ada.locatecar.controller.interfaces.VehicleControllerI;
import bernardo.ada.locatecar.views.client.ClientOperationsView;
import bernardo.ada.locatecar.views.rent.RentOperationsView;
import bernardo.ada.locatecar.views.vehicle.VehicleOperationsView;

public class MainMenu extends Menu{
    private VehicleControllerI vehicleController;
    private ClientControllerI clientController;
    private RentControllerI rentController;
    public MainMenu(VehicleControllerI vehicleController, ClientControllerI clientController, RentControllerI rentController) {
        super(new String[]{
                "1 - Operacoes com veiculo",
                "2 - Operacoes com clientes",
                "3 - Operações com aluguel",
                "0 - Sair"
        });
        this.vehicleController = vehicleController;
        this.clientController = clientController;
        this.rentController = rentController;
    }

    @Override
    protected void executeOption(int option) {
        switch(option) {
            case 0: return;
            case 1: new VehicleOperationsView(vehicleController).show(); break;
            case 2: new ClientOperationsView(clientController).show(); break;
            case 3: new RentOperationsView(rentController).show(); break;
            default: break;
        }
        show();
    }
}
