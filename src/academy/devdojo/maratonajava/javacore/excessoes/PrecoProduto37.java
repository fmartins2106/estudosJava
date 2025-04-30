package academy.devdojo.maratonajava.javacore.excessoes;

public class PrecoProduto37 extends IllegalArgumentException {
    public static final double MENOR_PRECO = 0;
    public PrecoProduto37() {
        super(String.format("Preço não pode ser menor que R$%.2f.",MENOR_PRECO));
    }
}
