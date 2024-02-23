package brack.bernardo.catalogoimdb.modelo;

import java.time.LocalDate;

public abstract class Pessoa {
    protected final String nome;
    protected final LocalDate dataDeNascimento;

    public Pessoa(String nome, LocalDate dataDeNascimento) {
        this.nome = nome;
        this.dataDeNascimento = dataDeNascimento;
    }

    public String getNome() {
        return this.nome;
    }
    public LocalDate getDataDeNascimento() {
        return this.dataDeNascimento;
    }


}
