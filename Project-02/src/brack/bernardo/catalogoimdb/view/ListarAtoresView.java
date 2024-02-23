package brack.bernardo.catalogoimdb.view;

import brack.bernardo.catalogoimdb.modelo.Ator;
import brack.bernardo.catalogoimdb.service.AtorService;

import java.time.format.DateTimeFormatter;
import java.util.List;

public class ListarAtoresView {
    private AtorService service;
    public ListarAtoresView(AtorService service) {
        this.service = service;
    }
    public void show() {
        List<Ator> atores = service.listar();
        System.out.println("| NOME | DATA DE NASCIMENTO | SEXO?");
        for(Ator ator : atores) {
            System.out.println("| " + ator.getNome() + "| " + ator.getDataDeNascimento().format(DateTimeFormatter.ofPattern("dd/MM/yyyy")));
        }
    }


}
