package brack.bernardo.catalogoimdb.modelo;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Filme {
    private final String titulo;
    private final LocalDate dataDeLancamento;
    private final String descricao;
    private final List<Ator> atores;
    private final Diretor diretor;
    public Filme(String titulo, LocalDate dataDeLancamento, String descricao, Diretor diretor) {
        this.titulo = titulo;
        this.dataDeLancamento = dataDeLancamento;
        this.descricao = descricao;
        this.diretor = diretor;
        this.atores = new ArrayList<>();
    }
    public Filme(String titulo, LocalDate dataDeLancamento, String descricao) {
        this.titulo = titulo;
        this.dataDeLancamento = dataDeLancamento;
        this.descricao = descricao;
        this.atores = new ArrayList<>();
        this.diretor = null;
    }
    public Filme(String titulo, LocalDate dataDeLancamento, String descricao, Diretor diretor, List<Ator> atores) {
        this.titulo = titulo;
        this.dataDeLancamento = dataDeLancamento;
        this.descricao = descricao;
        this.diretor = diretor;
        this.atores = atores;
    }

    public String getTitulo() {
        return this.titulo;
    }

    public LocalDate getDataDeLancamento() {
        return this.dataDeLancamento;
    }

    public String getDescricao() {
        return this.descricao;
    }
    public List<Ator> getAtores() {
        return Collections.unmodifiableList(this.atores);
    }
    public Diretor getDiretor() {
        return this.diretor;
    }
    public void addAtor(Ator ator) {
        this.atores.add(ator);
    }
}
