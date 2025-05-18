package academy.devdojo.maratonajava.javacore.excessoes;

public class QuantidadeProdutoBase33 extends IllegalArgumentException {
    public static final int MENOR_QUANTIDADE_ESTOQUE = 0;
    public QuantidadeProdutoBase33() {
        super(String.format("Quantidade em estoque não pode ser menor que %d.",MENOR_QUANTIDADE_ESTOQUE));
    }
}
