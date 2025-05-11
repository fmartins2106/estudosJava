<<<<<<< HEAD
package academy.devdojo.maratonajava.javacore.excessoes;

public class QuantidadeProdutoBase31 extends IllegalArgumentException {
    public static final int MENOR_QUANTIDADE_ESTOQUE = 0;
    public QuantidadeProdutoBase31() {
        super(String.format("Quantidade em estoque não pode ser menor que %d.",MENOR_QUANTIDADE_ESTOQUE));
    }
}
=======
package academy.devdojo.maratonajava.javacore.excessoes;

public class QuantidadeProdutoBase31 extends IllegalArgumentException {
    public static final int MENOR_QUANTIDADE_ESTOQUE = 0;
    public QuantidadeProdutoBase31() {
        super(String.format("Quantidade em estoque não pode ser menor que %d.",MENOR_QUANTIDADE_ESTOQUE));
    }
}
>>>>>>> a3d11752a9fc400590a7a4f4542f729c1f492e90
