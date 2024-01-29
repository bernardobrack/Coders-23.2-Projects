import java.util.List;

public class Contato {

    Contato(String nome, String sobreNome, List<Telefone> telefones) {
        this.id = nextId++;
        this.nome = nome;
        this.sobreNome = sobreNome;
        this.telefones = telefones;
    }
    private static Long nextId = (long) 1;
    private Long id;
    private String nome;
    private String sobreNome;
    private List<Telefone> telefones;

    public Long getId() {
        return this.id;
    }

    public String getNome() {
        return this.nome;
    }

    public String getSobreNome() {
        return this.sobreNome;
    }

    public List<Telefone> getTelefones() {
        return this.telefones;
    }
    public Telefone getTelefoneById(Long id) throws IllegalArgumentException{
        for(Telefone telefone : this.telefones) {
            if(telefone.getId().equals(id)) return telefone;
        }
        throw new IllegalArgumentException("Telefone não encontrado!");
    }
    public void setNome(String novoNome) {
        this.nome = novoNome;
    }

    public void setSobreNome(String novoSobrenome) {
        this.sobreNome = novoSobrenome;
    }

    public void setTelefones(List<Telefone> telefones) {
        this.telefones = telefones;
    }

    public void print() {
        System.out.printf(">>>> Contato: %s <<<<\n", this.nome + " " + this.sobreNome);
        System.out.println("Id  | DDD  | Número");
        for(Telefone telefone : this.telefones) {
            System.out.println(telefone.getId() + "   | " + telefone.getDDD() + "   | " + telefone.getNumero());
        }
    }

}

