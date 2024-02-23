package brack.bernardo.catalogoimdb.view;

import java.util.Scanner;

public abstract class AbstractMenuView {
    protected String[] options;
    public AbstractMenuView(String[] options) {
        this.options = options;
    }
    public abstract void executeOption(int option);
    public abstract boolean isValidOption(int option);
    public void show() {
        System.out.println("ESCOLHA UMA DAS OPÇÕES A SEGUIR: ");
        for(int i = 0; i < options.length; i++) {
            System.out.printf("%s\n", options[i]);
        }
        Scanner sc = ScannerSingleton.getInstance().getScanner();
        int option;
        try {
            option = Integer.parseInt(sc.nextLine());
            if(isValidOption(option)) {
                executeOption(option);
            } else {
                show();
            }
        } catch(NumberFormatException ex) {
            System.err.println("ERRO! A opção escolhida deve ser um número!");
            show();
        }

    }
}
