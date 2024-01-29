import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class App {
    public static final String PATHNAME = "agenda.txt";
    public static final Parser parser = new Parser();

    public enum MenuOptions {
        ADICIONAR("Adicionar Contato"), REMOVER("Remover Contato"), EDITAR("Editar Contato"), SAIR("Sair");
        private final String text;

        MenuOptions(String text) {
            this.text = text;
        }

        public String getText() {
            return this.text;
        }

    }

    public static void main(String[] args) {
        Agenda agenda;
        try {
            agenda = ManipuladorDeArquivo.lerAgenda(PATHNAME);
        } catch (IOException e) {
            System.out.println("ERRO AO LER OU CRIAR A AGENDA: " + e.getMessage());
            return;
        }

        run(agenda);
        close(agenda, PATHNAME);
    }

    public static void run(Agenda agenda) {
        Scanner scanner = new Scanner(System.in);
        MenuOptions[] menuOptionsValues = MenuOptions.values();
        String[] menuOptionsStrings = new String[menuOptionsValues.length];
        for (int i = 0; i < menuOptionsStrings.length; i++) {
            menuOptionsStrings[i] = menuOptionsValues[i].getText();
        }
        do {
            agenda.print();

            Menu.print("Menu", menuOptionsStrings);
            int option = scanner.nextInt();
            scanner.nextLine();
            switch (option) {
                case 1:
                    adicionarContato(agenda, scanner);
                    break;
                case 2:
                    removerContato(agenda, scanner);
                    break;
                case 3:
                    editarContato(agenda, scanner);
                    break;
                case 4: {
                    scanner.close();
                    return;
                }
                default:
                    break;
            }
        } while (true);

    }

    public static void close(Agenda agenda, String pathname) {
        try {
            ManipuladorDeArquivo.escreverAgenda(agenda, pathname);
        } catch (IOException e) {
            System.out.println("Erro ao escrever a agenda: " + e.getMessage());
        }
    }

    public static void adicionarContato(Agenda agenda, Scanner sc) {

        System.out.println("Nome completo do contato: ");
        String nomeCompletoString = sc.nextLine();
        if (!parser.parseNome(nomeCompletoString)) {
            System.out.println("ERRO! Formato do nome não identificado!");
            return;
        }
        String[] resposta = nomeCompletoString.split(" ");
        String nome = resposta[0];
        StringBuilder sobrenomeBuilder = new StringBuilder();
        for (int i = 1; i < resposta.length; i++) {
            sobrenomeBuilder.append(resposta[i]);
            if (i < resposta.length - 1) sobrenomeBuilder.append(" ");
        }
        String sobrenome = sobrenomeBuilder.toString();
        List<Telefone> telefones = new ArrayList<>();
        do {
            System.out.println("Informe o DDD (Digite SAIR caso não queira adicionar mais números ao contato): ");
            String ddd = sc.nextLine().toUpperCase();
            if (ddd.equals("SAIR")) {
                if (telefones.isEmpty()) {
                    System.out.println("Abortando operação: um contato deve ter, ao menos, um número!");
                    return;
                }
                break;
            }
            if (!parser.parseDDD(ddd)) {
                System.out.println("Formato de DDD não identificado!");
                return;
            }
            System.out.println("Informe o Número: ");
            long numero;
            try {
                numero = Long.parseLong(sc.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("Formato de número não identificado!");
                return;
            }
            telefones.add(new Telefone(ddd, numero));
        } while (true);
        try {
            agenda.addContato(new Contato(nome, sobrenome, telefones));
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }

    }

    public static void removerContato(Agenda agenda, Scanner sc) {
        do {
            System.out.println("Digite o ID do contato a ser excluído (Digite 0 para cancelar): ");
            Long id = Long.parseLong(sc.nextLine());
            if (id.equals(0L)) {

                return;
            }
            try {
                agenda.removeContato(id);
                break;
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        } while (true);
        System.out.println("Contato removido!");
    }

    public static void editarContato(Agenda agenda, Scanner sc) {
        do {
            System.out.println("Digite o ID do contato a ser editado (Digite 0 para cancelar): ");
            long id;
            try {
                id = Long.parseLong(sc.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("Abortando operação: formato de ID não identificado!");
                return;
            }

            if (id == 0L) {
                return;
            }
            System.out.println(">>>> Editar <<<<\n" +
                    "1 - Nome\n" +
                    "2 - Algum número");
            int option = 0;
            String optionString = sc.nextLine();
            try {
                option = Integer.parseInt(optionString);
            } catch (NumberFormatException e) {
                System.out.println("Abortando operação: formato de operação inválido!");
            }

            switch (option) {
                case 1:
                    editarNomeContato(agenda, id, sc);
                    break;
                case 2:
                    editarListaDeTelefonesDoContato(agenda, id, sc);
                    break;
                default:
                    System.out.println("Opção inválida!");
                    break;
            }
        } while (true);
    }

    public static void editarNomeContato(Agenda agenda, Long id, Scanner sc) {
        System.out.println("Digite o novo nome completo do contato: ");
        String nomeCompletoString = sc.nextLine();
        if (!parser.parseNome(nomeCompletoString)) {
            System.out.println("Formato de NOME não identificado!");
            return;
        }
        String[] nomeCompleto = nomeCompletoString.split(" ");
        String nome = nomeCompleto[0];
        StringBuilder sobrenomeBuilder = new StringBuilder();
        for (int i = 1; i < nomeCompleto.length; i++) {
            sobrenomeBuilder.append(nomeCompleto[i]);
            if (i < nomeCompleto.length - 1) sobrenomeBuilder.append(" ");
        }
        String sobrenome = sobrenomeBuilder.toString();
        try {
            agenda.editarNomeContato(id, nome, sobrenome);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return;
        }

    }

    public static void editarListaDeTelefonesDoContato(Agenda agenda, Long idContato, Scanner sc) {
        Contato contato;
        try {
            contato = agenda.getContactById(idContato);
        } catch (IllegalArgumentException e) {
            return;
        }
        contato.print();
        System.out.println("Digite o ID do número a ser alterado (0 para cancelar): ");
        Long idTelefone = 0L;
        try {
            idTelefone = Long.parseLong(sc.nextLine());
        } catch(NumberFormatException e) {
            System.out.println("Formato de ID não identificado!");
            return;
        }

        if (idTelefone.equals(0L)) return;
        System.out.println("Digite o novo número completo (DDD e número separados por espaço em branco): ");
        String dddENumeroString = sc.nextLine();
        if(!parser.parseNumeroCompleto(dddENumeroString)) {
            System.out.println("ERRO! Formato de número não identificado!");
            return;
        }
        String[] dddNumero = dddENumeroString.split(" ");
        String ddd = dddNumero[0];
        Long numero = Long.parseLong(dddNumero[1]);
        try {
            agenda.editarTelefoneContato(contato, idTelefone, ddd, numero);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return;
        }
        System.out.println("Contato alterado!");
    }
}
