package academy.devdojo.maratonajava.javacore.navigableMap.exercicios;

import academy.devdojo.maratonajava.javacore.navigableMap.dominio.Consultavel01;

import java.time.LocalDateTime;
import java.util.Map;
import java.util.NavigableMap;
import java.util.TreeMap;

public class Exercicio03 {

    private final NavigableMap<LocalDateTime, Consultavel01> consultasAgendadas = new TreeMap<>();

    private void addConsultaSistema(Consultavel01 consultavel01){
        consultasAgendadas.put(consultavel01.getDataHora(),consultavel01);
        System.out.println("Consulta agendada com sucesso.");
    }

    private void excluirConsulta(LocalDateTime horario){
        if (consultasAgendadas.isEmpty()){
            System.out.println("Nenhuma consulta cadastrada.");
            return;
        }
        consultasAgendadas.remove(horario);
        System.out.println("Consulta removida do sistema.");
    }

    private void listarConsultas(){
        if (consultasAgendadas.isEmpty()){
            System.out.println("Nenhuma consulta cadastrada.");
            return;
        }
        consultasAgendadas.forEach((dateTime, consultavel01) -> System.out.println(consultavel01));
    }

    private boolean jaExiste(LocalDateTime horario){
        return consultasAgendadas.containsKey(horario);
    }

    private Map.Entry<LocalDateTime,Consultavel01> proximaConsulta(){
        return consultasAgendadas.higherEntry(LocalDateTime.now());
    }

    private void consultarAntes(LocalDateTime horario){
        consultasAgendadas.headMap(horario,false)
                .forEach((dateTime, consultavel01) -> System.out.println(consultavel01));
    }

    private void consultarDepois(LocalDateTime horario){
        consultasAgendadas.tailMap(horario,false)
                .forEach((dateTime, consultavel01) -> System.out.println(consultavel01));
    }

    public NavigableMap<LocalDateTime, Consultavel01> getConsultasAgendadas() {
        return consultasAgendadas;
    }
}