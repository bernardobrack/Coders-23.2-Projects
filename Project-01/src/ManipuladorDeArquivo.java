import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ManipuladorDeArquivo {

    public static final String EXPECTED_LINE_REGEX = "^[A-Z][a-z]+( [A-Za-z][a-z]+)+:([1-9][0-9] [1-9][0-9]*( |$))+";

    public static Agenda lerAgenda(String pathname) throws IOException {
        Agenda agenda = new Agenda();
        File file = new File(pathname);
        file.createNewFile();
        FileReader fileReader;
        BufferedReader bufferedReader;

        fileReader = new FileReader(file);
        bufferedReader = new BufferedReader(fileReader);
        Pattern pattern = Pattern.compile(EXPECTED_LINE_REGEX);
        while (bufferedReader.ready()) {
            String linha = bufferedReader.readLine();
            Matcher matcher = pattern.matcher(linha);
            if (!matcher.matches()) continue;
            String[] informacoesDeContato = linha.split(":");
            String[] nomeCompleto = informacoesDeContato[0].split(" ");
            String nome = nomeCompleto[0];
            StringBuilder sb = new StringBuilder();
            for (int i = 1; i < nomeCompleto.length; i++) {
                sb.append(nomeCompleto[i]);
                if (i < nomeCompleto.length - 1) sb.append(" ");
            }
            String sobreNomes = sb.toString();
            String[] dddENumero = informacoesDeContato[1].split(" ");
            ArrayList<Telefone> telefones = new ArrayList<>();
            for (int i = 0; i < dddENumero.length; i += 2) {
                telefones.add(new Telefone(dddENumero[i], Long.parseLong(dddENumero[i + 1])));
            }
            Contato contato = new Contato(nome, sobreNomes, telefones);
            agenda.addContato(contato);
        }
        return agenda;
    }

    public static void escreverAgenda(Agenda agenda, String pathname) throws IOException {
        File file = new File(pathname);

        FileWriter fileWriter;
        BufferedWriter bufferedWriter;
        fileWriter = new FileWriter(file);
        bufferedWriter = new BufferedWriter(fileWriter);
        for (Contato contato : agenda.getContatos()) {
            String nomeCompleto = contato.getNome() + " " + contato.getSobreNome();
            StringBuilder dddENumeroBuilder = new StringBuilder();
            List<Telefone> telefones = contato.getTelefones();
            for (int i = 0; i < telefones.size(); i++) {
                dddENumeroBuilder.append(telefones.get(i).getDDD()).append(" ").append(telefones.get(i).getNumero());
                if (i < telefones.size() - 1) {
                    dddENumeroBuilder.append(" ");
                }
            }
            String dddENumero = dddENumeroBuilder.toString();
            bufferedWriter.append(String.format("%s:%s", nomeCompleto, dddENumero));
            bufferedWriter.newLine();
        }
        bufferedWriter.flush();
        bufferedWriter.close();
    }
}
