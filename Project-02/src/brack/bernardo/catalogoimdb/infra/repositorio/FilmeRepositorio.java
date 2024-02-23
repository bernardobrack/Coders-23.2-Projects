package brack.bernardo.catalogoimdb.infra.repositorio;

import brack.bernardo.catalogoimdb.infra.banco.BancoDeDados;
import brack.bernardo.catalogoimdb.modelo.Filme;

import java.util.ArrayList;
import java.util.List;

public class FilmeRepositorio extends AbstractRepositorio{

    public FilmeRepositorio(BancoDeDados bd) {
        super(bd);

    }

    public List<Filme> buscarPorNomeLike(String nome) {
        List<Filme> filmesEncontrados = new ArrayList<>();
        List<Filme> todosOsFilmes = this.bd.buscarObjetosPorTipo(classeModelo());
        todosOsFilmes.forEach(filme -> {
            if(filme.getTitulo().toLowerCase().contains(nome.toLowerCase())) {
                filmesEncontrados.add(filme);
            }
        });
        return filmesEncontrados;

    }

    public Filme buscarPorNomeExato(String nome) {
        List<Filme> todosOsFilmes = this.bd.buscarObjetosPorTipo(classeModelo());
        for (Filme filme : todosOsFilmes) {
            if(filme.getTitulo().equalsIgnoreCase(nome)) {
                return filme;
            }
        }
        return null;
    }

    @Override
    protected Class<Filme> classeModelo() {
        return Filme.class;
    }

}
