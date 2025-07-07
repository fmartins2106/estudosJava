package academy.devdojo.maratonajava.javacore.threads;

import java.util.concurrent.Callable;

public class CalcularFrete01 implements Callable<Double> {
    private final Double valor;

    public CalcularFrete01(Double valor) {
        this.valor = valor;
    }

    @Override
    public Double call() throws Exception {
        Thread.sleep(1000);
        return 20.00 + (valor * 0.05);
    }
}
