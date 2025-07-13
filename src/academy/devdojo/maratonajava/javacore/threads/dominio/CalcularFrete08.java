package academy.devdojo.maratonajava.javacore.threads.dominio;

import java.util.concurrent.Callable;

public class CalcularFrete08 implements Callable<Double> {
    public final double valor;

    public CalcularFrete08(double valor) {
        this.valor = valor;
    }

    @Override
    public Double call() throws Exception {
        Thread.sleep(2000);
        return 20 + (valor * 0.05);
    }
}
