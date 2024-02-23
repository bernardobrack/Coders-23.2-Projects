package brack.bernardo.catalogoimdb.modelo;

import java.time.LocalDate;
import java.util.*;

public class Ator extends Pessoa{
    private final List<Filme> filmes;
    public Ator(String nome, LocalDate dataDeNascimento) {
        super(nome, dataDeNascimento);
        this.filmes = new ArrayList<>();
    }
    public Ator(String nome, LocalDate dataDeNascimento, List<Filme> filmes) {
        super(nome, dataDeNascimento);
        this.filmes = filmes;
    }
    public List<Filme> getFilmes() {
        return Collections.unmodifiableList(this.filmes);
    }

    public void addFilme(Filme filme) {
        this.filmes.add(filme);
    }

}
