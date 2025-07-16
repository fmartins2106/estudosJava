package academy.devdojo.maratonajava.javacore.designPatterns.dominio;

import java.time.LocalDateTime;
import java.util.Map;
import java.util.NavigableMap;
import java.util.TreeMap;

public class ConsultaRepositoryImpl02 implements ConsultaRepository02 {
    private final NavigableMap<LocalDateTime,Consultavel02> consultas = new TreeMap<>();

    @Override
    public void salvar(Consultavel02 consultavel02) {
        consultas.put(consultavel02.getDataHora(),consultavel02);
    }

    @Override
    public void remover(LocalDateTime horario) {
        consultas.remove(horario);

    }

    @Override
    public boolean existe(LocalDateTime horario) {
        return consultas.containsKey(horario);
    }

    @Override
    public Map.Entry<LocalDateTime, Consultavel02> proxima() {
        return consultas.higherEntry(LocalDateTime.now());
    }

    @Override
    public NavigableMap<LocalDateTime, Consultavel02> listarTodas() {
        return new TreeMap<>(consultas);
    }

    @Override
    public Consultavel02 buscarPorHorario(LocalDateTime horario) {
        return consultas.get(horario);
    }

    @Override
    public void atualizar(LocalDateTime horario, Consultavel02 novaConsulta) {
        if (consultas.containsKey(horario)){
            throw new IllegalArgumentException("Consulta não encontrada.");
        }
        consultas.put(horario,novaConsulta);
    }
}
