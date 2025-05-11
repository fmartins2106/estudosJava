package academy.devdojo.maratonajava.javacore.Interface.dominio;

import java.text.DecimalFormat;

public class Paypall17 implements Pagamento17{
    private double saldoPaypall;
    private static final DecimalFormat df = new DecimalFormat("0.00");

    public Paypall17(double saldoPaypall) {
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
            System.out.println("Pagamento de R$"+df.format(valor)+ "realizado com sucesso.");
        }else {
            System.out.println("Valor inválido.");
        }
    }

    @Override
    public void consultarSaldo(){
        System.out.println("Saldo disponível para pagamento R$"+df.format(saldoPaypall));
    }
}
