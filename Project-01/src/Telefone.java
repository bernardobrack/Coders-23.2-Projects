public class Telefone {
    Telefone(String ddd, Long numero) {
        this.id = nextId++;
        this.ddd = ddd;
        this.numero = numero;
    }
    private static Long nextId = (long) 1;
    private Long id;
    private String ddd;
    private Long numero;

    public Long getId() {
        return this.id;
    }

    public Long getNumero() {
        return this.numero;
    }

    public String getDDD() {
        return this.ddd;
    }

    public void setDDD(String ddd) {
        this.ddd = ddd;
    }
    public void setNumero(Long numero) {
        this.numero = numero;
    }
}

