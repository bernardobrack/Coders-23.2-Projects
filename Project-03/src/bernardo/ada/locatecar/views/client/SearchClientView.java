package bernardo.ada.locatecar.views.client;

import bernardo.ada.locatecar.controller.ClientController;
import bernardo.ada.locatecar.controller.interfaces.ClientControllerI;
import bernardo.ada.locatecar.views.menu.Menu;
import bernardo.ada.locatecar.views.printer.ClientPrinter;

public class SearchClientView extends Menu {

    private ClientControllerI clientController;
    public SearchClientView(ClientControllerI clientController) {
        super(new String[]{
                "1 - Por identificador",
                "2 - Por nome",
                "0 - Sair"
        });
        this.clientController = clientController;
    }

    @Override
    protected void executeOption(int option) {
        switch (option) {
            case 1: new SearchClientByIdView(clientController, new ClientPrinter()).show(); break;
            case 2: new SearchClientByNameView(clientController, new ClientPrinter()).show(); break;
            case 0: break;
        }
    }
}
