package academy.devdojo.maratonajava.javacore.threads.dominio;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.concurrent.BlockingQueue;

public class ProdutorDePedidos11 implements Runnable{
    public final BlockingQueue<Pedido11> filaPedido;
    public final List<String> clientes = Arrays.asList("Maria","Juliana","Marta","Fernando","José");
    public final Random random = new Random();

    public void run(){
        while (!Thread.currentThread().isInterrupted()){
            try {
                String cliente = clientes.get(random.nextInt(clientes.size()));
                double valorPedido = 50 + random.nextDouble(450);
                BigDecimal valor = BigDecimal.valueOf(valorPedido);
                
            }
        }
    }
}
