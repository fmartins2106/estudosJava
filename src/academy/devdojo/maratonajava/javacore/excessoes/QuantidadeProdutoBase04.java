package academy.devdojo.maratonajava.javacore.excessoes;

public class QuantidadeProdutoBase04 extends IllegalArgumentException {
    public static final int MENOR_ESTOQUE = 0;
    public QuantidadeProdutoBase04() {
        super(String.format("Estoque não pode ser menor que %d",MENOR_ESTOQUE));
    }
}
