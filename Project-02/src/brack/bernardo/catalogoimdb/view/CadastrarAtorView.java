package brack.bernardo.catalogoimdb.view;

import brack.bernardo.catalogoimdb.modelo.Ator;
import brack.bernardo.catalogoimdb.service.AtorService;
import brack.bernardo.catalogoimdb.utils.DateValidate;

import java.time.LocalDate;
import java.util.Scanner;

public class CadastrarAtorView {
    private AtorService service;
    public CadastrarAtorView(AtorService service) {
        this.service = service;
    }
    public void show() {
        Scanner sc = ScannerSingleton.getInstance().getScanner();
        System.out.print("Nome do autor: ");
        String nome = sc.nextLine();
        System.out.print("Data de nascimento (dd/mm/yyyy): ");
        String data = sc.nextLine();
        if(!DateValidate.isValidDate(data)) {
            System.err.println("Erro: data mal formatada, deve estar no formato dd/mm/yyyy");
            show();
            return;
        }
        LocalDate date = DateValidate.stringToDate(data);
        try {
            service.criar(new Ator(nome, date));
        } catch (RuntimeException ex) {
            System.err.println(ex.getMessage());
        }
    }
}
