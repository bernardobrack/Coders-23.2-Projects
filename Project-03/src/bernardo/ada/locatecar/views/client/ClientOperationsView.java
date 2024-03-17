package bernardo.ada.locatecar.views.client;

import bernardo.ada.locatecar.controller.ClientController;
import bernardo.ada.locatecar.controller.interfaces.ClientControllerI;
import bernardo.ada.locatecar.views.menu.Menu;
import bernardo.ada.locatecar.views.printer.ClientPrinter;
import bernardo.ada.locatecar.views.printer.RentablePrinter;

public class ClientOperationsView extends Menu {
    private ClientControllerI clientController;
    public ClientOperationsView(ClientControllerI clientController) {
        super(new String[] {
                "1 - Cadastrar cliente",
                "2 - Alterar cliente",
                "3 - Buscar cliente",
                "4 - Listar clientes",
                "5 - Ver aluguéis",
                "0 - Sair"
        });
        this.clientController = clientController;
    }

    @Override
    protected void executeOption(int option) {
        switch (option) {
            case 0: return;
            case 1: new CreateClientView(clientController).show(); break;
            case 2: new AlterClientView(clientController).show(); break;
            case 3: new SearchClientView(clientController).show(); break;
            case 4: new ListClientsView(clientController, new ClientPrinter()).show(); break;
            case 5: new ListClientRentView(clientController, new RentablePrinter()).show(); break;
            default: break;
        }
    }
}
