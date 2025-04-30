package academy.devdojo.maratonajava.javacore.Interface.dominio;

import java.text.DecimalFormat;

public class Paypall21 implements Pagamento21{
    private double saldoPaypall;
    private static final DecimalFormat df = new DecimalFormat("0.00");

    public Paypall21(double saldoPaypall) {
        this.saldoPaypall = saldoPaypall;
    }

    @Override
    public boolean verificarSaldo(double valor){
        return valor <= saldoPaypall;
    }

    @Override
    public void processarPagamentos(double valor){
        if (verificarSaldo(valor)){
            saldoPaypall -= valor;
            System.out.println("Pagamento autorizado no valor de R$"+df.format(valor));
        }else {
            System.out.println("Valor inválido.");
        }
    }

    @Override
    public void consultaSaldo(){
        System.out.println("Saldo disponível na conta Paypall ->R$"+df.format(saldoPaypall));
    }
}
