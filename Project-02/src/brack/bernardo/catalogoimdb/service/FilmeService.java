package brack.bernardo.catalogoimdb.service;

import brack.bernardo.catalogoimdb.infra.repositorio.FilmeRepositorio;
import brack.bernardo.catalogoimdb.modelo.Filme;

import java.util.List;

public class FilmeService {
    private FilmeRepositorio repositorio;
    public FilmeService(FilmeRepositorio repositorio) {
        this.repositorio = repositorio;
    }

    public void criar(Filme filme) {
        if(filme == null) {
            throw new RuntimeException("Erro ao criar filme: filme não pode ser nulo!");
        }
        if(filme.getTitulo().trim().isEmpty()) {
            throw new RuntimeException("Erro ao criar filme: titulo do filme nao pode ser nulo!");
        }
        if(filme.getDiretor() == null) {
            throw new RuntimeException("Erro ao criar filme: um filme deve ter um diretor");
        }
        repositorio.gravar(filme);
    }
    public void atualizar(Filme filme) {
        if(filme == null) {
            throw new RuntimeException("Erro ao atualizar filme: filme não pode ser nulo!");
        }
        if(filme.getTitulo() == null) {
            throw new RuntimeException("Erro ao atualizar filme: o título não pode ser nulo!");
        }
        Filme existente = repositorio.buscarPorNomeExato(filme.getTitulo());
        if(existente == null) {
            throw new RuntimeException("Erro ao atualizar filme: filme não encontrado!");
        }
        repositorio.gravar(filme);
    }
    public void excluir(String nome) {
        Filme encontrado = repositorio.buscarPorNomeExato(nome);
        if(encontrado == null) {
            throw new RuntimeException("Erro ao excluir filme: filme não encontrado!");
        }
        repositorio.excluir(encontrado);
    }
    public Filme buscarTituloExato(String titulo) {
        if(titulo == null) {
            throw new RuntimeException("Erro ao buscar filme: titulo buscado nao pode ser nulo!");
        }
        if(titulo.trim().isEmpty()) {
            throw new RuntimeException("Erro ao buscar filme: titulo buscado nao pode ser vazio!");
        }
        Filme encontrado = repositorio.buscarPorNomeExato(titulo);
        if(encontrado == null) {
            throw new RuntimeException("Erro ao buscar filme: nao foi possivel encontrar o filme!");
        }
        return encontrado;
    }
    public List<Filme> listar() {
        return repositorio.listar();
    }

}
