package brack.bernardo.catalogoimdb.view;

import brack.bernardo.catalogoimdb.modelo.Ator;
import brack.bernardo.catalogoimdb.modelo.Diretor;
import brack.bernardo.catalogoimdb.service.DiretorService;

import java.time.format.DateTimeFormatter;
import java.util.List;

public class ListarDiretoresView {
    private DiretorService service;
    public ListarDiretoresView(DiretorService service) {
        this.service = service;
    }
    public void show() {
        List<Diretor> diretores = service.listar();
        System.out.println("| NOME | DATA DE NASCIMENTO | SEXO?");
        for(Diretor diretor : diretores) {
            System.out.println("| " + diretor.getNome() + "| " + diretor.getDataDeNascimento().format(DateTimeFormatter.ofPattern("dd/MM/yyyy")));
        }
    }
}
