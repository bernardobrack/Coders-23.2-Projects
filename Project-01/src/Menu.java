import java.util.List;

public class Menu {
    public static void print(String titulo, String[] opcoes) {
        System.out.printf(">>>> %s <<<<\n", titulo);
        for (int i = 0; i < opcoes.length; i++) {
            System.out.printf("%d - %s\n", i + 1, opcoes[i]);
        }
        System.out.println();


    }
}
