package bernardo.ada.locatecar.views.rent;

import bernardo.ada.locatecar.controller.RentController;
import bernardo.ada.locatecar.controller.interfaces.RentControllerI;
import bernardo.ada.locatecar.views.menu.Menu;

public class RentOperationsView extends Menu {

    private RentControllerI rentController;
    public RentOperationsView(RentControllerI rentController) {
        super(new String[] {
                "1 - Alugar",
                "2 - Liberar veículo",
                "3 - Calcular aluguel",
                "0 - Sair"

        });
        this.rentController = rentController;
    }

    @Override
    protected void executeOption(int option) {
        switch(option) {
            case 1: new RentVehicleView(rentController).show(); break;
            case 2: new FreeVehicleView(rentController).show(); break;
            case 3: new CalcRentView(rentController).show(); break;
            case 0: break;
            default: break;
        }
    }
}
