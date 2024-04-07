package brack.bernardo.projeto4.constants;

import java.util.regex.Pattern;

public class Constants {
    public static final Pattern pattern = Pattern.compile("^[áàâãéèêíïóôõöúçñA-ZÁÀÂÃÉÈÊÍÏÓÔÕÖÚÇÑ][áàâãéèêíïóôõöúçñÁÀÂÃÉÈÊÍÏÓÔÕÖÚÇÑA-Za-z\\-| ]*,[0-9]+,[áàâãéèêíïóôõöúçñÁÀÂÃÉÈÊÍÏÓÔÕÖÚÇÑA-Z][áàâãéèêíïóôõöúçñÁÀÂÃÉÈÊÍÏÓÔÕÖÚÇÑA-Za-z\\-| ]*,[0-9]+(\\.[0-9][0-9])$");
}
