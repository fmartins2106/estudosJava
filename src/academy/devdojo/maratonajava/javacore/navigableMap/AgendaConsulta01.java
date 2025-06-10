package academy.devdojo.maratonajava.javacore.navigableMap;

import academy.devdojo.maratonajava.javacore.navigableMap.excessoes.DataHoraCadastroConsulta;
import academy.devdojo.maratonajava.javacore.navigableMap.excessoes.EspecialidadeCadastroConsulta;
import academy.devdojo.maratonajava.javacore.navigableMap.excessoes.MedicoCadastroConsulta;
import academy.devdojo.maratonajava.javacore.navigableMap.excessoes.PacienteCadastroConsulta;

import java.time.DateTimeException;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.NavigableMap;
import java.util.Scanner;
import java.util.TreeMap;
import java.util.logging.Level;
import java.util.logging.Logger;

public class AgendaConsulta01 {
    private static final Scanner scanner = new Scanner(System.in);
    private static final Logger logger = ConsultaLogger01.getLogger(AgendaConsulta01.class);
    private final NavigableMap<LocalDateTime,Consultavel01> consultas = new TreeMap<>();

    public static String validandoPaciente(){
        while (true){
            try {
                System.out.println("Paciente:");
                String paciente = scanner.nextLine().trim();
                CadastroConsulta01.validacaoPaciente(paciente);
                return paciente;
            }catch (PacienteCadastroConsulta e){
                System.out.println(e.getMessage());
                logger.log(Level.WARNING,"Erro de regra de negocio"+e.getMessage());
            }
        }
    }

    public static String validandoMedico(){
        while (true){
            try {
                System.out.println("Médico:");
                String medico = scanner.nextLine().trim();
                CadastroConsulta01.validacaoMedico(medico);
                return medico;
            }catch (MedicoCadastroConsulta e){
                System.out.println(e.getMessage());
                logger.log(Level.WARNING,"Erro de regra de negocio:"+e.getMessage());
            }
        }
    }

    public static String validandoEspecialidade(){
        while (true){
            try {
                System.out.println("Especialidade:");
                String especialidade = scanner.nextLine().trim();
                CadastroConsulta01.validacaoEspecialidade(especialidade);
                return especialidade;
            }catch (EspecialidadeCadastroConsulta e){
                System.out.println(e.getMessage());
                logger.log(Level.WARNING,"Erro de regra de negócio:"+e.getMessage());
            }
        }
    }

    public static LocalDateTime validandoDataHora(){
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm");
        while (true){
            try {
                System.out.println("Data e hora (DD/MM/AAAA HH:mm):");
                String entrada = scanner.nextLine().trim();
                LocalDateTime dataHora = LocalDateTime.parse(entrada,formatter);
                CadastroConsulta01.validacaoDataHora(dataHora);
                return dataHora;
            }catch (DateTimeParseException e){
                System.out.println("Erro, Digite data e hora no formato:DD/MM/AAAA HH:mm");
                logger.log(Level.WARNING,"Erro no formato data ou hora:DD/MM/AAAA HH:mm"+e.getMessage());
            }catch (DataHoraCadastroConsulta e){
                System.out.println(e.getMessage());
                logger.log(Level.WARNING,"Erro na data ou hora conforme regra de negocio."+e.getMessage());
            }
        }
    }


}
