package brack.bernardo.catalogoimdb.infra.repositorio;

import brack.bernardo.catalogoimdb.infra.banco.BancoDeDados;
import brack.bernardo.catalogoimdb.modelo.Pessoa;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public abstract class PessoaRepositorio extends AbstractRepositorio{
    public PessoaRepositorio(BancoDeDados bd) {
        super(bd);
    }
    public List<Pessoa> buscarPorNomeLike(String nome) {
        List<Pessoa> todasAsPessoas = this.bd.buscarObjetosPorTipo(classeModelo());
        List<Pessoa> resposta = new ArrayList<>();
        for (Pessoa pessoa : todasAsPessoas) {
            if(pessoa.getNome().toLowerCase().contains(nome.toLowerCase())) {
                resposta.add(pessoa);
            }
        }
        return Collections.unmodifiableList(resposta);
    }

    public Pessoa buscarPorNomeExato(String nome) {
        List<Pessoa> todasAsPessoas = this.bd.buscarObjetosPorTipo(classeModelo());
        for (Pessoa pessoa : todasAsPessoas) {
            if(pessoa.getNome().equalsIgnoreCase(nome)) {
                return pessoa;
            }
        }
        return null;
    }
}
