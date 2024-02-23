package brack.bernardo.catalogoimdb.view;

import brack.bernardo.catalogoimdb.modelo.Diretor;
import brack.bernardo.catalogoimdb.modelo.Filme;
import brack.bernardo.catalogoimdb.service.FilmeService;

import java.time.format.DateTimeFormatter;
import java.util.List;

public class ListarFilmesView {
    private FilmeService service;
    public ListarFilmesView(FilmeService service) {
        this.service = service;
    }
    public void show() {
        List<Filme> filmes = service.listar();
        System.out.println("| TITULO | DATA DE LANCAMENTO | DIRETOR |");
        for(Filme filme : filmes) {
            System.out.println("| " + filme.getTitulo() + " | " + filme.getDataDeLancamento().format(DateTimeFormatter.ofPattern("dd/MM/yyyy")) + " | " + filme.getDiretor().getNome());
        }
    }
}
