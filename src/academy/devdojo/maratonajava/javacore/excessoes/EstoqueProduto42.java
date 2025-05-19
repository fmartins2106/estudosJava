package academy.devdojo.maratonajava.javacore.excessoes;

public class EstoqueProduto42 extends IllegalArgumentException {
    public static final int MENOR_QUANTIDADE_ESTOQUE = 0;
    public EstoqueProduto42() {
        super(String.format("Quantidade em estoque não pode ser menor que %d.",MENOR_QUANTIDADE_ESTOQUE));
    }
}
