package academy.devdojo.maratonajava.javacore.datas.dominio;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.time.format.DateTimeFormatter;
import java.util.List;

public class RelatorioEvento43 {
    //sdsdsd
    public void gerarRelatorio(List<EventoBase43> eventoBase43s){
        Path pastaEvento = Paths.get("relatorios");
        try {
            if (Files.notExists(pastaEvento)){
                Files.createDirectories(pastaEvento);
            }
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm");
            Path caminhoArquivo = pastaEvento.resolve("relatorio_evento43.csv");
            StringBuilder conteudo = new StringBuilder();
            conteudo.append("\"nome evento\",\"local evento\",\"data e hora\"\n");
            for (EventoBase43 eventoBase43 : eventoBase43s) {
                String linha = String.format("\"%s\",\"%s\",\"%s\"",
                        eventoBase43.getNomerEvento(),eventoBase43.getLocalEvento(),
                        eventoBase43.getDataHora().format(formatter));
                conteudo.append(linha).append("\n");
            }
            Files.writeString(caminhoArquivo,conteudo, StandardCharsets.UTF_8, StandardOpenOption.CREATE,
                    StandardOpenOption.TRUNCATE_EXISTING);
            System.out.println("Relatório gerado com sucesso:"+caminhoArquivo.toAbsolutePath());
        }catch (IOException e){
            e.printStackTrace();
        }
    }
}
