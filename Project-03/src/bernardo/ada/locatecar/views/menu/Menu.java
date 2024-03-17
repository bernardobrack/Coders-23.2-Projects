package bernardo.ada.locatecar.views.menu;

import bernardo.ada.locatecar.views.Showable;
import bernardo.ada.locatecar.views.scanner.ScannerSingleton;

import java.util.Scanner;


public abstract class Menu implements Showable {
    protected String[] options;
    protected Menu(String[] options) {
        this.options = options;
    }
    @Override
    public void show() {
        System.out.println("ESCOLHA UMA OPÇÃO ABAIXO: ");
        for(int i = 0; i < options.length; i++) {
            String curr = options[i];
            System.out.println(curr);
        }
        execute();
    }
    protected boolean isValidOption(int option) {
        return option >= 0 && option <= options.length;
    }
    private void execute() {
        Scanner sc = ScannerSingleton.getInstance().getScanner();
        try {
            int option = Integer.parseInt(sc.nextLine());
            if(isValidOption(option)) {
                executeOption(option);
            } else {
                System.err.println("Opção inválida!");
                show();
            }
        } catch (NumberFormatException ex) {
            System.err.println("Opção inválida!");
            show();
        }
    }
    protected abstract void executeOption(int option);
}
