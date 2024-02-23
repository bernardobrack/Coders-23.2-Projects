import brack.bernardo.catalogoimdb.infra.banco.BancoDeDados;
import brack.bernardo.catalogoimdb.infra.repositorio.AtorRepositorio;
import brack.bernardo.catalogoimdb.infra.repositorio.DiretorRepositorio;
import brack.bernardo.catalogoimdb.infra.repositorio.FilmeRepositorio;
import brack.bernardo.catalogoimdb.service.AtorService;
import brack.bernardo.catalogoimdb.service.DiretorService;
import brack.bernardo.catalogoimdb.service.FilmeService;
import brack.bernardo.catalogoimdb.view.Menu;
import brack.bernardo.catalogoimdb.view.ScannerSingleton;

public class Main {
    public static void main(String[] args) {
        Runtime.getRuntime().addShutdownHook(new Thread(){
            public void run() {
                ScannerSingleton.getInstance().getScanner().close();
                System.out.println("Aplicacao finalizada!");
            }
        });
        BancoDeDados bd = new BancoDeDados();
        AtorRepositorio atorRep = new AtorRepositorio(bd);
        AtorService atorService = new AtorService(atorRep);
        DiretorRepositorio diretorRepositorio = new DiretorRepositorio(bd);
        DiretorService diretorService = new DiretorService(diretorRepositorio);
        FilmeRepositorio filmeRepositorio = new FilmeRepositorio(bd);
        FilmeService filmeService = new FilmeService(filmeRepositorio);
        Menu menu = new Menu(atorService, diretorService, filmeService);
        menu.show();
    }
}
