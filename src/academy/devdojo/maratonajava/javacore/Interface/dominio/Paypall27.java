package academy.devdojo.maratonajava.javacore.Interface.dominio;

import java.text.DecimalFormat;

public class Paypall27 implements Pagamento27{
    private double saldoPaypall;
    private static final DecimalFormat df = new DecimalFormat("0.00");

    public Paypall27(double saldoPaypall) {
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
        System.out.println("Operação negada. Valor não pode ser maior que saldo.");
    }

    @Override
    public void consultarSaldo(){
        System.out.println("Saldo disponível para pagamento R$"+df.format(saldoPaypall));
    }

}
