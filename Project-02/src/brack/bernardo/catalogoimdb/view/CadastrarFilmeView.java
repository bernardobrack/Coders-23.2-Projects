package brack.bernardo.catalogoimdb.view;

import brack.bernardo.catalogoimdb.modelo.Diretor;
import brack.bernardo.catalogoimdb.modelo.Filme;
import brack.bernardo.catalogoimdb.service.AtorService;
import brack.bernardo.catalogoimdb.service.DiretorService;
import brack.bernardo.catalogoimdb.service.FilmeService;
import brack.bernardo.catalogoimdb.utils.DateValidate;

import java.time.LocalDate;
import java.util.Scanner;

public class CadastrarFilmeView {
    private FilmeService filmeService;
    private AtorService atorService;
    private DiretorService diretorService;
    public CadastrarFilmeView(FilmeService filmeService, AtorService atorService, DiretorService diretorService) {
        this.filmeService = filmeService;
        this.atorService = atorService;
        this.diretorService = diretorService;
    }
    public void show() {
        Scanner sc = ScannerSingleton.getInstance().getScanner();
        System.out.print("Titulo do filme: ");
        String titulo = sc.nextLine();
        System.out.print("Data de lancamento: ");
        String dateString = sc.nextLine();
        if(!DateValidate.isValidDate(dateString)) {
            System.err.println("Erro ao cadastrar filme: data de lancamento invalida!");
            show();
            return;
        }
        LocalDate date = DateValidate.stringToDate(dateString);
        System.out.println("Descricao do filme: ");
        String descricao = sc.nextLine();
        System.out.print("Nome do diretor: ");
        String nomeDiretor = sc.nextLine();
        Diretor diretor = diretorService.buscarPorNome(nomeDiretor);
        if(diretor == null) {
            System.err.println("Erro ao criar filme: diretor especificado nao encontrado!");
            return;
        }
        try {
            Filme filme = new Filme(titulo, date, descricao, diretor);
            filmeService.criar(filme);
            diretor.addFilme(filme);
            diretorService.atualizar(diretor);
        } catch (RuntimeException ex) {
            System.err.println(ex.getMessage());
        }

    }
}
