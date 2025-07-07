package academy.devdojo.maratonajava.javacore.threads;

import java.util.concurrent.Callable;

public class CalcularFrete01 implements Callable<Double> {
    private final double valor;

    public CalcularFrete01(double valor) {
        this.valor = valor;
    }

    @Override
    public Double call() throws Exception {
        Thread.sleep(1000); // simula cáculo do frete.
        return 20.0 + (valor * 0.05); // Frete fixo + 5% do valor.
    }


}
