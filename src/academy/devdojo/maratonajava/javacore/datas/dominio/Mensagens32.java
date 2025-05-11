<<<<<<< HEAD
package academy.devdojo.maratonajava.javacore.datas.dominio;

import java.util.Locale;
import java.util.ResourceBundle;

public class Mensagens32 {

    public static ResourceBundle carregar(String idiomas){
        Locale locale = idiomas.equalsIgnoreCase("en" ) ? new Locale("en","US") :
                new Locale("pt","BR");
        return ResourceBundle.getBundle("mensagensBundle.messages32",locale);
    }
}
=======
package academy.devdojo.maratonajava.javacore.datas.dominio;

import java.util.Locale;
import java.util.ResourceBundle;

public class Mensagens32 {

    public static ResourceBundle carregar(String idiomas){
        Locale locale = idiomas.equalsIgnoreCase("en" ) ? new Locale("en","US") :
                new Locale("pt","BR");
        return ResourceBundle.getBundle("mensagensBundle.messages32",locale);
    }
}
>>>>>>> a3d11752a9fc400590a7a4f4542f729c1f492e90
