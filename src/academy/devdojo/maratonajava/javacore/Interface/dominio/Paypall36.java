package academy.devdojo.maratonajava.javacore.Interface.dominio;

import java.text.DecimalFormat;

public class Paypall36 implements Pagamento36{
    private double saldoPaypall;
    private static final DecimalFormat df = new DecimalFormat("0.00");

    public Paypall36(double saldoPaypall) {
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
            System.out.println("Pagamento autorizando no valor de R$"+df.format(valor));
            return;
        }
        System.out.println("Valor inválido. Tente novamente.");
    }

    @Override
    public void consultarSaldo() {
        System.out.println("Saldo disponível na conta Paypall R$"+df.format(saldoPaypall));
    }
}
