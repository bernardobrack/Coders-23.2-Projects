package brack.bernardo.catalogoimdb.view;

import brack.bernardo.catalogoimdb.modelo.Diretor;
import brack.bernardo.catalogoimdb.service.DiretorService;
import brack.bernardo.catalogoimdb.utils.DateValidate;

import java.time.LocalDate;
import java.util.Scanner;

public class CadastrarDiretorView {
    private DiretorService service;
    public CadastrarDiretorView(DiretorService service) {
        this.service = service;
    }
    public void show() {
        Scanner sc = ScannerSingleton.getInstance().getScanner();
        System.out.println("Nome do diretor: ");
        String nome = sc.nextLine();
        System.out.println("Data de nascimento (dd/mm/yyyy): ");
        String dateString = sc.nextLine();
        if(!DateValidate.isValidDate(dateString)) {
            System.err.println("Erro ao criar diretor: data invalida!");
            show();
            return;
        }

        LocalDate date = DateValidate.stringToDate(dateString);
        service.criar(new Diretor(nome, date));
    }
}
