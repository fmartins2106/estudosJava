package academy.devdojo.maratonajava.javacore.excessoes;

public class EstoqueMinimoProdutoBase13 extends IllegalArgumentException {
    public static final int MENOR_ESTOQUE_MINIMO = 0;
    public EstoqueMinimoProdutoBase13() {
        super(String.format("Estoque mínimo não pode ser menor que %d.",MENOR_ESTOQUE_MINIMO));
    }
}
