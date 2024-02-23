package brack.bernardo.catalogoimdb.infra.repositorio;

import brack.bernardo.catalogoimdb.infra.banco.BancoDeDados;

import java.util.Collections;
import java.util.List;

public abstract class AbstractRepositorio {
    protected BancoDeDados bd;
    public AbstractRepositorio(BancoDeDados bd) {
        this.bd = bd;
    }

    public void gravar(Object object) {
        this.bd.inserirObjeto(object);
    }

    public List listar() {
        return Collections.unmodifiableList(this.bd.buscarObjetosPorTipo(classeModelo()));
    }
    public void excluir(Object object) {this.bd.excluirObjeto(object);};
    protected abstract Class classeModelo();
}
