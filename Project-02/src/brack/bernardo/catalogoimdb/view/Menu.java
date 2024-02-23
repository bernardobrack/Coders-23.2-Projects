package brack.bernardo.catalogoimdb.view;

import brack.bernardo.catalogoimdb.service.AtorService;
import brack.bernardo.catalogoimdb.service.DiretorService;
import brack.bernardo.catalogoimdb.service.FilmeService;

public class Menu extends AbstractMenuView {

    private AtorService atorService;
    private DiretorService diretorService;
    private FilmeService filmeService;
    public Menu(AtorService atorService, DiretorService diretorService, FilmeService filmeService) {
        super(new String[]{

                "1 - Cadastrar filme",
                "2 - Cadastrar ator",
                "3 - Cadastrar diretor",
                "4 - Adicionar ator a filme",
                "5 - Listar filmes",
                "6 - Listar atores",
                "7 - Listar diretores",
                "8 - Ver Informacao de Ator/Diretor/Filme",
                "0 - SAIR"
        });
        this.atorService = atorService;
        this.diretorService = diretorService;
        this.filmeService = filmeService;
    }

    @Override
    public boolean isValidOption(int option) {
        return option >= 0 && option < this.options.length;
    }
    @Override
    public void executeOption(int option) {
        switch(option) {
            case 0: return;
            case 1: new CadastrarFilmeView(filmeService, atorService, diretorService).show(); break;
            case 2: new CadastrarAtorView(atorService).show(); break;
            case 3: new CadastrarDiretorView(diretorService).show(); break;
            case 4: new AdicionarAtorAFilmeView(atorService, filmeService).show(); break;
            case 5: new ListarFilmesView(filmeService).show(); break;
            case 6: new ListarAtoresView(atorService).show(); break;
            case 7: new ListarDiretoresView(diretorService).show(); break;
            case 8: new VerInformacaoView(atorService, filmeService, diretorService).show(); break;
            default: this.show(); break;
        }
        show();
    }
}
