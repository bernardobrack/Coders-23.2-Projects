package brack.bernardo.catalogoimdb.view;

import brack.bernardo.catalogoimdb.modelo.Ator;
import brack.bernardo.catalogoimdb.modelo.Filme;
import brack.bernardo.catalogoimdb.service.AtorService;
import brack.bernardo.catalogoimdb.service.FilmeService;

import java.util.Scanner;

public class AdicionarAtorAFilmeView {
    private AtorService atorService;
    private FilmeService filmeService;
    public AdicionarAtorAFilmeView(AtorService atorService, FilmeService filmeService) {
        this.atorService = atorService;
        this.filmeService = filmeService;
    }
    public void show() {
        Scanner sc = ScannerSingleton.getInstance().getScanner();
        System.out.print("Nome do filme: ");
        String nomeFilme = sc.nextLine();
        try {
            Filme filme = filmeService.buscarTituloExato(nomeFilme);
            System.out.print("Nome do ator: ");
            Ator ator = atorService.buscarPorNomeExato(sc.nextLine());
            filme.addAtor(ator);
            ator.addFilme(filme);
            filmeService.atualizar(filme);
            atorService.atualizar(ator);
        } catch (RuntimeException ex) {
            System.err.println(ex.getMessage());
        }



    }
}
