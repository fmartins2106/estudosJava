package academy.devdojo.maratonajava.javacore.Interface.dominio;

import java.text.DecimalFormat;

public class Paypall43 implements Pagamento43{
    private double saldoPaypall;
    private static final DecimalFormat df = new DecimalFormat("0.00");

    public Paypall43(double saldoPaypall) {
        this.saldoPaypall = saldoPaypall;
    }

    @Override
    public boolean verificarSaldo(double valor) {
        return valor <= saldoPaypall;
    }

    @Override
    public void processarPagamentos(double valor) {
        if (verificarSaldo(valor)){
            saldoPaypall -= valor;
            System.out.println("Pagamento autorizado no valor de R$"+df.format(valor));
            return;
        }
        System.out.println("Operação negada. Valor inválido.");
    }

    @Override
    public void consultarSaldo() {
        System.out.println("Saldo disponível em conta:R$"+df.format(saldoPaypall));
    }
}
