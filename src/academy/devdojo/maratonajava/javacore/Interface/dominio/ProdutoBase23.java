package academy.devdojo.maratonajava.javacore.Interface.dominio;

import academy.devdojo.maratonajava.javacore.excessoes.EstoqueMinimoProdutoBase23;
import academy.devdojo.maratonajava.javacore.excessoes.NomeProdutoBase23;
import academy.devdojo.maratonajava.javacore.excessoes.PrecoProdutoBase23;
import academy.devdojo.maratonajava.javacore.excessoes.QuantidadeProdutoBase23;

import java.util.Arrays;
import java.util.stream.Collectors;

public abstract class ProdutoBase23 implements Produtos23{
    protected String nome;
    protected double preco;
    protected int quantidade;
    protected int estoqueMinimo;

    public ProdutoBase23(String nome, double preco, int quantidade, int estoqueMinimo) {
        setNome(nome);
        setPreco(preco);
        setQuantidade(quantidade);
        setEstoqueMinimo(estoqueMinimo);
    }

    public static void validacaoNome(String nome){
        if (nome == null || nome.isEmpty() || !nome.matches("^[\\p{L}0-9]+( [\\p{L}0-9]+)*$")){
            throw new NomeProdutoBase23();
        }
    }

    public static String formatoString(String nome){
        return Arrays.stream(nome.split("\\s+")).map(palavra -> palavra.substring(0,1).toUpperCase()
        +palavra.substring(1).toLowerCase()).collect(Collectors.joining(" "));
    }

    public static void validacaoPreco(double preco){
        if (preco < PrecoProdutoBase23.MENOR_PRECO_PRODUTO){
            throw new PrecoProdutoBase23();
        }
    }

    public static void validacaoQuantidade(int quantidade){
        if (quantidade < QuantidadeProdutoBase23.MENOR_QUANTIDADE_ESTOQUE){
            throw new QuantidadeProdutoBase23();
        }
    }

    public static void validacaoEstoqueMinimo(int estoqueMinimo){
        if (estoqueMinimo < EstoqueMinimoProdutoBase23.MENOR_ESTOQUE_MINIMO){
            throw new EstoqueMinimoProdutoBase23();
        }
    }

    @Override
    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        validacaoNome(nome);
        this.nome = formatoString(nome);
    }

    @Override
    public double getPreco() {
        return preco;
    }

    public void setPreco(double preco) {
        validacaoPreco(preco);
        this.preco = preco;
    }

    @Override
    public int getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(int quantidade) {
        validacaoQuantidade(quantidade);
        this.quantidade = quantidade;
    }

    @Override
    public int getEstoqueMinimo() {
        return estoqueMinimo;
    }

    public void setEstoqueMinimo(int estoqueMinimo) {
        validacaoEstoqueMinimo(estoqueMinimo);
        this.estoqueMinimo = estoqueMinimo;
    }

    @Override
    public void verificarEstoqueMinimo() {
        if (estoqueMinimo > quantidade){
            System.out.println("Alerta. Quantidade em estoque menor que estoque mínimo recomendado.");
        }
    }

}
