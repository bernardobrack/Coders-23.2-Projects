import bernardo.ada.locatecar.controller.ClientController;
import bernardo.ada.locatecar.controller.RentController;
import bernardo.ada.locatecar.controller.VehicleController;
import bernardo.ada.locatecar.infra.database.BancoDeDados;
import bernardo.ada.locatecar.infra.database.DefaultBancoDeDados;
import bernardo.ada.locatecar.infra.repository.ClientRepository;
import bernardo.ada.locatecar.infra.repository.VehicleRepository;
import bernardo.ada.locatecar.infra.repository.exception.RepositoryException;
import bernardo.ada.locatecar.model.client.Client;
import bernardo.ada.locatecar.model.vehicles.Vehicle;
import bernardo.ada.locatecar.views.menu.MainMenu;
import bernardo.ada.locatecar.views.scanner.ScannerSingleton;


import java.util.HashSet;

public class Main {
    public static void main(String[] args) {
        Runtime.getRuntime().addShutdownHook(new Thread(){
            public void run() {
                ScannerSingleton.getInstance().getScanner().close();
                System.out.println("Aplicacao finalizada!");
            }
        });
        VehicleRepository vehicleRepository = new VehicleRepository(new DefaultBancoDeDados<>(new HashSet<>()));
        ClientRepository clientRepository = new ClientRepository(new DefaultBancoDeDados<>(new HashSet<>()));
        VehicleController vehicleController = new VehicleController(vehicleRepository);
        ClientController clientController = new ClientController(clientRepository);
        RentController rentController = new RentController(clientRepository, vehicleRepository);
        new MainMenu(vehicleController, clientController, rentController).show();

    }
}
