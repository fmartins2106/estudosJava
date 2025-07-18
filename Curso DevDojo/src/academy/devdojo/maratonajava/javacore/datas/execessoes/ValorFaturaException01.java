package academy.devdojo.maratonajava.javacore.datas.execessoes;

public class ValorFaturaException01 extends IllegalArgumentException {
  public static final double MENOR_VALOR_FATURA = 0;
    public ValorFaturaException01() {
        super(String.format("Valor da futura não pode ser menor que R$%.2f.",MENOR_VALOR_FATURA));
    }
}
