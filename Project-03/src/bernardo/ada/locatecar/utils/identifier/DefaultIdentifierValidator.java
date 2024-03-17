package bernardo.ada.locatecar.utils.identifier;

import java.util.regex.Pattern;

public class DefaultIdentifierValidator implements IdentifierValidator{
    private final Pattern pattern;
    public DefaultIdentifierValidator() {
        this.pattern = Pattern.compile("^[A-Za-z0-9]+$");
    }
    public DefaultIdentifierValidator(String regex) {
        this.pattern = Pattern.compile(regex);
    }

    public boolean validate(String toValidate) {
        return pattern.matcher(toValidate).matches();
    }
}
