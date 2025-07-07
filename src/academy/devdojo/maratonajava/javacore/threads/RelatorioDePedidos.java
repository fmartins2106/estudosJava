package academy.devdojo.maratonajava.javacore.threads;

import java.io.BufferedWriter;
import java.io.File;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.concurrent.SynchronousQueue;

public class RelatorioDePedidos {
    public SynchronousQueue void salvarRelatorio(Pedido01 pedido01, double imposto, double frete, double total){
        try {
            Path pasta = Paths.get("relatorio");
            Files.notExists(pasta){
                Files.createDirectories(pasta);
            }
            Path arquivo = pasta.resolve("relatorio_pedido.txt");
            String timeStamp = LocalDateTime.now().format(DateTimeFormatter
                    .ofPattern("dd/MM/yyyy HH:mm:ss"));
            try (BufferedWriter writer = Files.newBufferedWriter(arquivo,StandardOpenOption.CREATE,
                    StandardOpenOption.APPEND);PrintWriter out = new PrintWriter(writer)){
                
            }

        }
    }




}
