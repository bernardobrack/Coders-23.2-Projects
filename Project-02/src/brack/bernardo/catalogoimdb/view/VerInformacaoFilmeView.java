package brack.bernardo.catalogoimdb.view;

import brack.bernardo.catalogoimdb.modelo.Ator;
import brack.bernardo.catalogoimdb.modelo.Diretor;
import brack.bernardo.catalogoimdb.modelo.Filme;
import brack.bernardo.catalogoimdb.service.FilmeService;

import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class VerInformacaoFilmeView {
    private FilmeService service;
    public VerInformacaoFilmeView(FilmeService service) {
        this.service = service;
    }
    public void show() {
        Scanner sc = ScannerSingleton.getInstance().getScanner();
        System.out.print("Nome do filme: ");
        try {
            Filme filme  = service.buscarTituloExato(sc.nextLine());
            System.out.println("FILME: " + filme.getTitulo() + " | DATA DE LANCAMENTO: " + filme.getDataDeLancamento().format(DateTimeFormatter.ofPattern("dd/MM/yyyy")));
            System.out.println("-----------------------------------------------------------------------------");
            System.out.println("DESCRICAO: ");
            System.out.println(filme.getDescricao());
            System.out.println("-----------------------------------------------------------------------------");
            Diretor diretor = filme.getDiretor();
            System.out.println("DIRETOR: " + diretor.getNome() + " | DATA DE NASCIMENTO: " + diretor.getDataDeNascimento().format(DateTimeFormatter.ofPattern("dd/MM/yyyy")));
            System.out.println("-----------------------------------------------------------------------------");
            System.out.println("ATORES: ");
            for(Ator ator : filme.getAtores()) {
                System.out.println(ator.getNome() + " | " + ator.getDataDeNascimento().format(DateTimeFormatter.ofPattern("dd/MM/yyyy")));
            }
        } catch(RuntimeException ex) {
            System.err.println(ex.getMessage());
        }
    }
}
