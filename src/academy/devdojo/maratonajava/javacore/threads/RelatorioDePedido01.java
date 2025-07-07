package academy.devdojo.maratonajava.javacore.threads;

import java.io.*;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class RelatorioDePedido01 {
    public synchronized void salvarRelatorio(Pedido01 pedido01,double imposto, double frete, double total){
        try {
            File pasta = new File("relatorios");
            if (!pasta.exists()){
                pasta.mkdirs();
            }
            File arquivo = new File(pasta,"pedido_relatorio.txt");
            String timestamp = LocalDateTime.now()
                    .format(DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss"));
            try (FileWriter fw = new FileWriter(arquivo,true);
                BufferedWriter bw = new BufferedWriter(fw);
                PrintWriter out = new PrintWriter(bw)){
                out.printf("[%s] Pedido #%d | cliente: %s | Valor:R$%.2f | Imposto:R$%.2f |Frete:R$%.2f | Total:R$%.2f%n",
                        timestamp,pedido01.getId(),pedido01.getCliente(),pedido01.getValor(),imposto,frete,total);
                }
            }catch (IOException e){
            System.out.println("Erro ao salvar relatório:"+e.getMessage());
        }
    }
}
