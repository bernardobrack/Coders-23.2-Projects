import java.util.regex.Pattern;

public class Parser {
    public static final String NOME_REGEX = "^[A-Z][a-z]+( ([A-Za-z][a-z]+))+$";
    public static final String DDD_REGEX = "[1-9][0-9]";

    public static final String DDD_E_NUMERO_REGEX = "^[1-9][0-9] [1-9][0-9]*$";
    private final Pattern namePattern;
    private final Pattern dddPattern;

    private final Pattern dddENumeroPattern;
    Parser() {
        this.namePattern = Pattern.compile(NOME_REGEX);
        this.dddPattern = Pattern.compile(DDD_REGEX);
        this.dddENumeroPattern = Pattern.compile(DDD_E_NUMERO_REGEX);
    }
    public boolean parseNome(String name) {
        return this.namePattern.matcher(name).matches();
    }

    public boolean parseDDD(String ddd) {
        return this.dddPattern.matcher(ddd).matches();
    }

    public boolean parseNumeroCompleto(String numero) {
        return this.dddENumeroPattern.matcher(numero).matches();
    }
}
