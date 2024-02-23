package brack.bernardo.catalogoimdb.view;

import brack.bernardo.catalogoimdb.modelo.Diretor;
import brack.bernardo.catalogoimdb.modelo.Filme;
import brack.bernardo.catalogoimdb.service.DiretorService;

import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class VerInformacaoDiretorView {
    private DiretorService service;
    public VerInformacaoDiretorView(DiretorService service) {
        this.service = service;
    }
    public void show() {
        Scanner sc = ScannerSingleton.getInstance().getScanner();
        System.out.print("Nome do diretor: ");
        try {
            Diretor diretor = service.buscarPorNome(sc.nextLine());
            System.out.println("DIRETOR: " + diretor.getNome() + " | DATA DE NASCIMENTO: " + diretor.getDataDeNascimento().format(DateTimeFormatter.ofPattern("dd/MM/yyyy")));
            System.out.println("-----------------------------------------------------------------------------");
            for(Filme filme : diretor.getFilmes()) {
                System.out.println(filme.getTitulo() + " | " + filme.getDataDeLancamento().format(DateTimeFormatter.ofPattern("dd/MM/yyyy")));
                System.out.println("Descricao: " + filme.getDescricao());
                System.out.println("-----------------------------------------------------------------------------");
            }
        } catch(RuntimeException ex) {
            System.err.println(ex.getMessage());
        }
    }
}
