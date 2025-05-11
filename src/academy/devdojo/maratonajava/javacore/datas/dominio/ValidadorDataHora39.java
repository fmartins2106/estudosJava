<<<<<<< HEAD
package academy.devdojo.maratonajava.javacore.datas.dominio;

import java.time.DateTimeException;
import java.time.LocalDateTime;
import java.util.Optional;

public class ValidadorDataHora39 {

    public static Optional<LocalDateTime> validacaoDataHora(int ano, int mes, int dia, int hora, int minuto){
        try {
            return Optional.of(LocalDateTime.of(ano,mes,dia,hora,minuto));
        }catch (DateTimeException e){
            System.err.println("Erro. Digite uma data válida."+e.getMessage());
            return Optional.empty();
        }
    }
}
=======
package academy.devdojo.maratonajava.javacore.datas.dominio;

import java.time.DateTimeException;
import java.time.LocalDateTime;
import java.util.Optional;

public class ValidadorDataHora39 {

    public static Optional<LocalDateTime> validacaoDataHora(int ano, int mes, int dia, int hora, int minuto){
        try {
            return Optional.of(LocalDateTime.of(ano,mes,dia,hora,minuto));
        }catch (DateTimeException e){
            System.err.println("Erro. Digite uma data válida."+e.getMessage());
            return Optional.empty();
        }
    }
}
>>>>>>> a3d11752a9fc400590a7a4f4542f729c1f492e90
