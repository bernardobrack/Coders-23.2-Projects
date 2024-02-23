package brack.bernardo.catalogoimdb.infra.repositorio;

import brack.bernardo.catalogoimdb.infra.banco.BancoDeDados;
import brack.bernardo.catalogoimdb.modelo.Ator;



public class AtorRepositorio extends PessoaRepositorio{
    public AtorRepositorio(BancoDeDados bd) {
        super(bd);
    }




    @Override
    protected Class classeModelo() {
        return Ator.class;
    }
}
