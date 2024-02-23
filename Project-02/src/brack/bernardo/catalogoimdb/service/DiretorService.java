package brack.bernardo.catalogoimdb.service;

import brack.bernardo.catalogoimdb.infra.repositorio.DiretorRepositorio;
import brack.bernardo.catalogoimdb.modelo.Diretor;

import java.util.List;


public class DiretorService {
    private DiretorRepositorio repositorio;
    public DiretorService(DiretorRepositorio repositorio) {
        this.repositorio = repositorio;
    }
    public void criar(Diretor diretor) {
        if(diretor == null) {
            throw new RuntimeException("Erro ao criar diretor: diretor não pode ser nulo!");
        }
        if(diretor.getNome() == null) {
            throw new RuntimeException("Erro ao criar diretor: nome do diretor não pode ser nulo!");
        }
        if(diretor.getNome().trim().isEmpty()) {
            throw new RuntimeException("Erro ao criar diretor: nome do diretor não pode ser vazio!");
        }
        if(diretor.getDataDeNascimento() == null) {
            throw new RuntimeException("Erro ao criar diretor: data de nascimento não pode ser nula!");
        }
        repositorio.gravar(diretor);
    }
    public void excluir(String nome){
        if(nome == null) {
            throw new RuntimeException("Erro ao excluir diretor: nome não pode ser nulo!");
        }
        if(nome.trim().isEmpty()) {
            throw new RuntimeException("Erro ao excluir diretor: nome não pode ser vazio!");
        }
        Diretor encontrado = (Diretor) repositorio.buscarPorNomeExato(nome);
        if(encontrado == null) {
            throw new RuntimeException("Erro ao excluir diretor: diretor não encontrado!");
        }
        repositorio.excluir(encontrado);
    };
    public void atualizar(Diretor diretor) {
        if(diretor == null) {
            throw new RuntimeException("Erro ao atualizar diretor: diretor não pode ser nulo!");
        }
        if(diretor.getNome() == null) {
            throw new RuntimeException("Erro ao atualizar diretor: nome não pode ser nulo!");
        }
        if(diretor.getNome().trim().isEmpty()) {
            throw new RuntimeException("Erro ao atualizar diretor: nome não pode ser vazio!");
        }
        if(diretor.getDataDeNascimento() == null) {
            throw new RuntimeException("Erro ao atualizar diretor: data de nascimento não pode ser nula!");
        }
        Diretor encontrado = (Diretor) repositorio.buscarPorNomeExato(diretor.getNome());
        if(encontrado == null) {
            throw new RuntimeException("Erro ao atualizar diretor: diretor não encontrado!");
        }
        repositorio.gravar(diretor);
    }
    public Diretor buscarPorNome(String nome) {
        if(nome == null) {
            throw new RuntimeException("Erro ao buscar diretor: nome nao pode ser nulo!");
        }
        return (Diretor) repositorio.buscarPorNomeExato(nome);

    }
    public List<Diretor> listar() {
        return repositorio.listar();
    }
}
