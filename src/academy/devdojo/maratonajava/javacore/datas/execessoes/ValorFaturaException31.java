
package academy.devdojo.maratonajava.javacore.datas.execessoes;

public class ValorFaturaException31 extends IllegalArgumentException {
    public static final double MENOR_VALOR_FATURA = 0;
    public ValorFaturaException31() {
        super(String.format("Valor da fatura não pode ser menor que R$%.2f.",MENOR_VALOR_FATURA));
    }
}

