package academy.devdojo.maratonajava.javacore.excessoes;

public class PrecoProdutoBase31 extends IllegalArgumentException {
    public static final double MENOR_PRECO_PRODUTO = 0;
    public PrecoProdutoBase31() {
        super(String.format("Preço produto não pode ser menor que R$%.2f",MENOR_PRECO_PRODUTO));
    }
}
