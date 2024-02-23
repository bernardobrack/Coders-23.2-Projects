package brack.bernardo.catalogoimdb.infra.repositorio;

import brack.bernardo.catalogoimdb.infra.banco.BancoDeDados;
import brack.bernardo.catalogoimdb.modelo.Diretor;

public class DiretorRepositorio extends PessoaRepositorio{


    public DiretorRepositorio(BancoDeDados bd) {
        super(bd);
    }



    @Override
    protected Class classeModelo() {
        return Diretor.class;
    }

}
