import java.util.ArrayList;
import java.util.List;

public class Agenda {

    private List<Contato> contatos;

    Agenda() {this.contatos = new ArrayList<>();}

    Agenda(List<Contato> contatos) {
        this.contatos = contatos;
    }

    public void print() {
        System.out.println("##################");
        System.out.println("##### AGENDA #####");
        System.out.println("##################\n");
        System.out.println(">>>> Contatos <<<<\n" +
                "Id | Nome");
        for (Contato contato : this.contatos) {
            System.out.printf("%d  | %s %s\n", contato.getId(), contato.getNome(), contato.getSobreNome());
        }
        System.out.println();

    }
    public List<Contato> getContatos() {
        return this.contatos;
    }
    public void addContato(Contato novoContato) throws IllegalArgumentException {
        for (Contato contato : this.contatos) {
            for (Telefone existingTelefone : contato.getTelefones()) {
                for (Telefone newTelefone : novoContato.getTelefones()) {
                    if ((existingTelefone.getDDD() + existingTelefone.getNumero().toString()).equals(newTelefone.getDDD() + newTelefone.getNumero().toString())) {
                        throw new IllegalArgumentException("ERRO! Não foi possível adicionar o contato!");
                    }
                }
            }
        }
        this.contatos.add(novoContato);
    }

    public void removeContato(Long id) throws IllegalArgumentException {
        int indiceDoContato = this.getContactIndexById(id);
        this.contatos.remove(indiceDoContato);
    }

    public void editarNomeContato(Long id, String novoNome, String novoSobrenome) throws IllegalArgumentException {
        Contato contato = getContactById(id);
        contato.setNome(novoNome);
        contato.setSobreNome(novoSobrenome);

    }
    public void editarTelefoneContato(Contato novoContato, Long idTelefone ,String ddd, Long numero) throws IllegalArgumentException{
        Telefone telefone = novoContato.getTelefoneById(idTelefone);
        for(Contato contato : this.contatos) {
            for(Telefone existingTelefone : contato.getTelefones()) {
                if(existingTelefone.getDDD().equals(ddd) && existingTelefone.getNumero().equals(numero)) throw new IllegalArgumentException("Número existente!");
            }
        }
        telefone.setDDD(ddd);
        telefone.setNumero(numero);
    }
    public int getContactIndexById(Long id) throws IllegalArgumentException {
        for (int i = 0; i < this.contatos.size(); i++) {
            if (this.contatos.get(i).getId().equals(id)) {
                return i;
            }
        }
        throw new IllegalArgumentException("ERRO! ID NÃO ENCONTRADO!");
    }

    public Contato getContactById(Long id) throws IllegalArgumentException {
        for (int i = 0; i < this.contatos.size(); i++) {
            if (this.contatos.get(i).getId().equals(id)) {
                return this.contatos.get(i);
            }
        }
        throw new IllegalArgumentException("ERRO! ID NÃO ENCONTRADO!");
    }

}
