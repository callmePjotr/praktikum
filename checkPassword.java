import java.text.Normalizer;
import java.util.regex.Pattern;

public class checkPassword {
    String checkmyPassword(String password){
        //als erstes gucken, ob das passwort mindestens einen Großbuchstaben, eine Zahl und ein Sonderzeichen besitzt
        String regexPattern = "[a-z]+[A-Z]+[0-9]+[!@#$%^&*]+.*";
        checkPassword.patternMatches(password, regexPattern);

        if(checkPassword.patternMatches(password, regexPattern)){
            return "valid";
        }
        else {
            return "invalid";
        }
    }

    private static boolean patternMatches(String password, String regexPattern) {
        return Pattern.compile(regexPattern).matcher(password).matches();
    }
}



