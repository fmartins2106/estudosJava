package academy.devdojo.maratonajava.javacore.datas.dominio;

import java.util.Locale;
import java.util.ResourceBundle;

public class Mensagens14 {

    public static ResourceBundle carregar(String idiomas){
        Locale locale = idiomas.equalsIgnoreCase("en") ? new Locale("en","US") :
                new Locale("pt","BR");
        return ResourceBundle.getBundle("mensagensBundle.messages14",locale);
    }
}
