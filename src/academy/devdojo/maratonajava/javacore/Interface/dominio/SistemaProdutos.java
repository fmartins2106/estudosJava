package academy.devdojo.maratonajava.javacore.Interface.dominio;

import academy.devdojo.maratonajava.javacore.excessoes.DescricaoProdutoDadosProduto;
import academy.devdojo.maratonajava.javacore.excessoes.NomeDadosProduto;
import academy.devdojo.maratonajava.javacore.excessoes.PrecoDadosProduto;
import academy.devdojo.maratonajava.javacore.excessoes.QuantidadeDadosProduto;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class SistemaProdutos {
    private static final Scanner scanner = new Scanner(System.in);
    private final Map<String,DadosProduto01> produtos = new HashMap<>();

    public static String validandoNome(){
        while (true){
            try {
                System.out.print("Nome:");
                String nome = scanner.nextLine().trim();
                DadosProduto01.validacaoNome(nome);
                return nome;
            }catch (NomeDadosProduto e){
                System.out.println(e.getMessage());
            }
        }
    }

    public static double validandoPreco(){
        while (true){
            try {
                System.out.print("Preço:R$");
                double preco = Double.parseDouble(scanner.nextLine().trim());
                DadosProduto01.validacaoPreco(preco);
                return preco;
            }catch (PrecoDadosProduto e){
                System.out.println(e.getMessage());
            }
        }
    }

    public static int validandoQuantidade(){
        while (true){
            try {
                System.out.print("Quantidade:");
                int quantidade = Integer.parseInt(scanner.nextLine().trim());
                DadosProduto01.validacaoQuantidade(quantidade);
                return quantidade;
            }catch (QuantidadeDadosProduto e){
                System.out.println(e.getMessage());
            }
        }
    }

    public static String validandoDescricao(){
        while (true){
            try {
                System.out.println("Descrição:");
                String descricao = scanner.nextLine().trim();
                DadosProduto01.validacaoDescricao(descricao);
                return descricao;
            }catch (DescricaoProdutoDadosProduto e){
                System.out.println(e.getMessage());
            }
        }
    }

    public void addProdutos(DadosProduto01 dadosProduto01){
        produtos.put(dadosProduto01.getNome(),dadosProduto01);
    }

    public void listarProdutos(){
        if (produtos.isEmpty()){
            System.out.println("Nenhum produto foi cadastrado.");
            return;
        }
        produtos.forEach(produtos -> System.out.println(produtos));
    }

    public void removerProduto(String nome){
        if (produtos.isEmpty()){
            System.out.println("Nenhum produto cadastrado.");
            return;
        }
        DadosProduto01 removido = produtos.remove(nome);
        if (removido != null) {
            System.out.println("Produto removido com sucesso.");
            return;
        }
        System.out.println("Produto não encontrado.");
    }

    public void buscarProduto(String nome){
        if (produtos.isEmpty()){
            System.out.println("Nenhum produto cadastrado.");
            return;
        }
        DadosProduto01 produto01 = produtos.get(nome);

        if (produto01 != null){
            System.out.println("Produto encontrado."+nome);
            return;
        }
        System.out.println("Produto não encontrado.");
    }



}
