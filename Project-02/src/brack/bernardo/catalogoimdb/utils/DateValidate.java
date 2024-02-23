package brack.bernardo.catalogoimdb.utils;


import java.time.LocalDate;
import java.util.Arrays;
import java.util.regex.Pattern;

public class DateValidate {
    private static Pattern pattern = Pattern.compile("^(?:(?:31(\\/|-|\\.)(?:0?[13578]|1[02]))\\1|(?:(?:29|30)(\\/|-|\\.)(?:0?[13-9]|1[0-2])\\2))(?:(?:1[6-9]|[2-9]\\d)?\\d{2})$|^(?:29(\\/|-|\\.)0?2\\3(?:(?:(?:1[6-9]|[2-9]\\d)?(?:0[48]|[2468][048]|[13579][26])|(?:(?:16|[2468][048]|[3579][26])00))))$|^(?:0?[1-9]|1\\d|2[0-8])(\\/|-|\\.)(?:(?:0?[1-9])|(?:1[0-2]))\\4(?:(?:1[6-9]|[2-9]\\d)?\\d{2})$");
    public static boolean isValidDate(String possibleDate) {
        return pattern.matcher(possibleDate).matches();
    }
    public static LocalDate stringToDate(String date) {
        int[] separatedDate = Arrays.stream(date.split("/")).mapToInt(obj -> Integer.parseInt(obj)).toArray();
        return  LocalDate.of(separatedDate[2], separatedDate[1], separatedDate[0]);
    }
}
