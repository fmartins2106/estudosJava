package academy.devdojo.maratonajava.javacore.excessoes;

public class CategoriaProdutoInvalido11 extends IllegalArgumentException {
    public CategoriaProdutoInvalido11() {
        super("Campo categoria não pode ser vazio ou conter caracteres.");
    }
}
