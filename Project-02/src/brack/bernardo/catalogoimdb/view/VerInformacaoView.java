package brack.bernardo.catalogoimdb.view;

import brack.bernardo.catalogoimdb.service.AtorService;
import brack.bernardo.catalogoimdb.service.DiretorService;
import brack.bernardo.catalogoimdb.service.FilmeService;

import java.util.Scanner;

public class VerInformacaoView extends AbstractMenuView{
    private AtorService atorService;
    private FilmeService filmeService;
    private DiretorService diretorService;
    public VerInformacaoView(AtorService atorService, FilmeService filmeService, DiretorService diretorService) {
        super(new String[]{
                "1 - Ator",
                "2 - Diretor",
                "3 - Filme",
                "0 - VOLTAR"
        });
        this.atorService = atorService;
        this.filmeService = filmeService;
        this.diretorService = diretorService;
    }


    @Override
    public void executeOption(int option) {
        switch (option) {
            case 1: new VerInformacaoAtorView(atorService).show(); break;
            case 2: new VerInformacaoDiretorView(diretorService).show(); break;
            case 3: new VerInformacaoFilmeView(filmeService).show(); break;
            default: return;
        }
    }

    @Override
    public boolean isValidOption(int option) {
        return option >= 0 && option < this.options.length;
    }
}
