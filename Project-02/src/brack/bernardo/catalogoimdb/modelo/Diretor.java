package brack.bernardo.catalogoimdb.modelo;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Diretor extends Pessoa{
    private final List<Filme> filmes;

    public Diretor(String nome, LocalDate dataDeNascimento) {
        super(nome, dataDeNascimento);
        this.filmes = new ArrayList<>();
    }
    public Diretor(String nome, LocalDate dataDeNascimento, List<Filme> filmes) {
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
