package academy.devdojo.maratonajava.javacore.Interface.dominio;

import java.util.Arrays;
import java.util.stream.Collectors;

public class Produto12 implements Vendavel12{
    private String nome;
    private double preco;
    private int estoque;

    public Produto12(String nome, double preco, int estoque) {
        setNome(nome);
        setPreco(preco);
        setEstoque(estoque);
    }

    public static void validacaoNome(String nome){
        if (nome == null || nome.isEmpty() || !nome.matches("[\\p{L}0-9]+( [\\p{L}0-9]+)*$")){
            throw new IllegalArgumentException(MensagensValidacaoProduto12.NOME.getDescricao());
        }
    }

    public static String formatoNome(String nome){
        return Arrays.stream(nome.split("\\s+")).map(palavra -> palavra.substring(0,1).toUpperCase()
        +palavra.substring(1).toLowerCase()).collect(Collectors.joining(" "));
    }

    public static final double MENOR_PRECO = 0;

    public static void validacaoPreco(double preco){
        if (preco < MENOR_PRECO){
            throw new IllegalArgumentException(MensagensValidacaoProduto12.PRECO.getDescricaoFormatada(MENOR_PRECO));
        }
    }

    public static final int MENOR_ESTOQUE = 0;

    public static void validacaoEstoque(int estoque){
        if (estoque < MENOR_ESTOQUE){
            throw new IllegalArgumentException(MensagensValidacaoProduto12.ESTOQUE.getDescricaoFormatada(MENOR_ESTOQUE));
        }
    }

    @Override
    public void exibirInfo(){
        System.out.println("Produto:"+nome+" |Preço:R$"+preco+" |Quantidade em estoque:"+estoque);
    }

    @Override
    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        validacaoNome(nome);
        this.nome = formatoNome(nome);
    }

    @Override
    public double getPreco() {
        return preco;
    }

    public void setPreco(double preco) {
        validacaoPreco(preco);
        this.preco = preco;
    }

    public int getEstoque() {
        return estoque;
    }

    public void setEstoque(int estoque) {
        validacaoEstoque(estoque);
        this.estoque = estoque;
    }

    public boolean reduzirEstoque(int quantidade){
        if (quantidade > estoque){
            System.out.println("Quantidade inválida. Tente novamente.");
            return false;
        }
        estoque -= quantidade;
        return true;
    }

    public void devolverEstoque(int quantidade){
        estoque += quantidade;
    }

    public enum MensagensValidacaoProduto12{
        NOME("Campo nome não pode ser vazio ou conter caracteres."),
        PRECO("Preço não pode ser menor que R$%.2f"),
        ESTOQUE("Estoque não pode ser menor que %d.");

        private final String descricao;

        MensagensValidacaoProduto12(String descricao) {
            this.descricao = descricao;
        }

        public String getDescricao() {
            return descricao;
        }

        public String getDescricaoFormatada(int... valores){
            return String.format(descricao, Arrays.stream(valores).boxed().toArray());
        }

        public String getDescricaoFormatada(double... valores){
            return String.format(descricao,Arrays.stream(valores).boxed().toArray());
        }
    }
}
