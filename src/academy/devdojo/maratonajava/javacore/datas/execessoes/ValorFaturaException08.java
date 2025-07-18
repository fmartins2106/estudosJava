package academy.devdojo.maratonajava.javacore.datas.execessoes;

public class ValorFaturaException08 extends IllegalArgumentException {
    public static final double MENOR_VALOR_FATURA = 0;
    public ValorFaturaException08() {
        super(String.format("Valor não pode ser menor que R$%.2f.",MENOR_VALOR_FATURA));
    }
}
