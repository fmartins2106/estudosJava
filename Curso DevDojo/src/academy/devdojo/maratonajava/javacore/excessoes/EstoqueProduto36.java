package academy.devdojo.maratonajava.javacore.excessoes;

public class EstoqueProduto36 extends IllegalArgumentException {
    public static final int MENOR_ESTOQUE = 0;
    public EstoqueProduto36() {
        super(String.format("Estoque não pode ser menor que %d.",MENOR_ESTOQUE));
    }
}
