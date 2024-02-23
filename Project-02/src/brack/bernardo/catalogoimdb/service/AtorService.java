package brack.bernardo.catalogoimdb.service;

import brack.bernardo.catalogoimdb.infra.repositorio.AtorRepositorio;
import brack.bernardo.catalogoimdb.modelo.Ator;

import java.util.List;

public class AtorService {
    private AtorRepositorio repositorio;
    public AtorService(AtorRepositorio repositorio) {
        this.repositorio = repositorio;
    }
    public void criar(Ator ator) {
        if(ator == null) {
            throw new RuntimeException("Erro ao criar ator: ator não pode ser nulo!");
        }
        if(ator.getNome() == null) {
            throw new RuntimeException("Erro ao criar ator: nome não pode ser nulo!");
        }
        if(ator.getNome().trim().isEmpty()) {
            throw new RuntimeException("Erro ao criar ator: nome inválido!");
        }
        if(ator.getDataDeNascimento() == null) {
            throw new RuntimeException("Erro ao criar ator: data de nascimento não pode ser nula!");
        }
        repositorio.gravar(ator);
    }
    public void excluir(String nome) {
        if(nome == null) {
            throw new RuntimeException("Erro ao excluir ator: nome não pode ser nulo!");
        }
        if(nome.trim().isEmpty()) {
            throw new RuntimeException("Erro ao excluir ator: nome não pode ser vazio!");
        }
        Ator encontrado = (Ator) repositorio.buscarPorNomeExato(nome);
        if(encontrado == null) {
            throw new RuntimeException("Erro ao excluir ator: ator não encontrado!");
        }
        repositorio.excluir(encontrado);
    }
    public void atualizar(Ator ator) {
        if(ator == null) {
            throw new RuntimeException("Erro ao atualizar ator: ator não pode ser nulo!");
        }
        if(ator.getNome() == null) {
            throw new RuntimeException("Erro ao atualizar ator: nome não pode ser nulo!");
        }
        if(ator.getDataDeNascimento() == null) {
            throw new RuntimeException("Erro ao atualizar ator: data de nascimento não pode ser nula!");
        }
        Ator encontrado = (Ator) repositorio.buscarPorNomeExato(ator.getNome());
        if(encontrado == null) {
            throw new RuntimeException("Erro ao atualizar ator: ator não encontrado!");
        }
        repositorio.gravar(ator);
    }
    public Ator buscarPorNomeExato(String nome) {
        if(nome == null) {
            throw new RuntimeException("Erro ao buscar ator: nome nao pode ser nulo!");
        }
        if(nome.trim().isEmpty()) {
            throw new RuntimeException("Erro ao buscar ator: nome nao pode ser vazio!");
        }
        Ator encontrado = (Ator) repositorio.buscarPorNomeExato(nome);
        if(encontrado == null) {
            throw new RuntimeException("Erro ao buscar ator: ator nao encontrado!");
        }
        return encontrado;
    }
    public List<Ator> listar() {
        return repositorio.listar();
    }

}
