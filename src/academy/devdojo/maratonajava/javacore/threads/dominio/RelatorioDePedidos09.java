package academy.devdojo.maratonajava.javacore.threads.dominio;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class RelatorioDePedidos09 {

    public synchronized void gerarRelatorio(Pedido09 pedido09, double imposto, double frete, double total){
        try {
            Path pasta = Paths.get("relatorio");
            if (Files.notExists(pasta)){
                Files.createDirectories(pasta);
            }
            Path arquivo = pasta.resolve("relatorio_pedido.txt");
            String dataHora = LocalDateTime.now().format(DateTimeFormatter
                    .ofPattern("dd/MM/yyyy HH:mm:ss"));
            try (BufferedWriter writer = Files.newBufferedWriter(arquivo, StandardCharsets.UTF_8, StandardOpenOption.CREATE,
                    StandardOpenOption.APPEND); PrintWriter out = new PrintWriter(writer)){
                out.printf("[%s] -> #ID:%d |Cliente:%s |Valor:R$%.2f |Imposto:R$%.2f |Frete:R$%.2f |Total:R$%.2f\n"
                        ,dataHora,pedido09.getId(),pedido09.getCliente(),pedido09.getValor(),imposto,frete,total);
            }
        }catch (IOException e){
            System.out.println("Erro ao gerar relatório:"+e.getMessage());
        }
    }
}
