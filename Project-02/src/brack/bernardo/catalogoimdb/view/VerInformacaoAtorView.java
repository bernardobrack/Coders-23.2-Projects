package brack.bernardo.catalogoimdb.view;

import brack.bernardo.catalogoimdb.modelo.Ator;
import brack.bernardo.catalogoimdb.modelo.Filme;
import brack.bernardo.catalogoimdb.service.AtorService;
import brack.bernardo.catalogoimdb.utils.DateValidate;

import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class VerInformacaoAtorView {
    private AtorService atorService;
    public VerInformacaoAtorView(AtorService atorService) {
        this.atorService = atorService;
    }
    public void show() {
        Scanner sc = ScannerSingleton.getInstance().getScanner();
        System.out.println("Nome do ator: ");
        try {
            Ator ator = atorService.buscarPorNomeExato(sc.nextLine());
            System.out.println("ATOR: " + ator.getNome() + " | DATA DE NASCIMENTO: " + ator.getDataDeNascimento().format(DateTimeFormatter.ofPattern("dd/MM/yyyy")));
            System.out.println("-----------------------------------------------------------------------------");
            for(Filme filme : ator.getFilmes()) {
                System.out.println(filme.getTitulo() + " | " + filme.getDataDeLancamento().format(DateTimeFormatter.ofPattern("dd/MM/yyyy")));
                System.out.println("Descricao: " + filme.getDescricao());
                System.out.println("-----------------------------------------------------------------------------");
            }
        } catch (RuntimeException ex) {
            System.err.println(ex.getMessage());
        }


    }
}
