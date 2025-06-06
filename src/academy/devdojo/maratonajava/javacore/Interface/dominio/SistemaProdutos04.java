package academy.devdojo.maratonajava.javacore.Interface.dominio;

import academy.devdojo.maratonajava.javacore.excessoes.DescricaoProdutoDadosProduto;
import academy.devdojo.maratonajava.javacore.excessoes.NomeDadosProduto;
import academy.devdojo.maratonajava.javacore.excessoes.PrecoDadosProduto;
import academy.devdojo.maratonajava.javacore.excessoes.QuantidadeDadosProduto;

import javax.swing.plaf.PanelUI;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.*;
import java.util.logging.FileHandler;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.logging.SimpleFormatter;

public class SistemaProdutos04 {
    private static final Scanner scanner = new Scanner(System.in);
    private static final Logger logger = ProdutosLogger04.getLogger(SistemaProdutos04.class);
    private final Map<String,DadosProduto04> dadosProdutos = new LinkedHashMap<>();

    public static String validandoNome(){
        while (true){
            try {
                System.out.println("Nome:");
                String nome = scanner.nextLine().trim();
                DadosProduto04.validacaoNome(nome);
                return nome;
            }catch (NomeDadosProduto e){
                System.out.println(e.getMessage());
                logger.log(Level.WARNING,"Nome inválido informado:"+e.getMessage());
            }
        }
    }

    public static double validandoPreco(){
        while (true){
            try {
                System.out.println("Preço:R$");
                double preco = Double.parseDouble(scanner.nextLine().trim());
                DadosProduto04.validacaoPreco(preco);
                return preco;
            }catch (PrecoDadosProduto e){
                System.out.println(e.getMessage());
                logger.log(Level.WARNING,"Preço inválido informado"+e.getMessage());
            }catch (NumberFormatException e){
                System.out.println("Erro. Digite um valor válido.");
                logger.log(Level.WARNING," Preço inválido."+e.getMessage());
            }
        }
    }

    public static int validandoQuantidade(){
        while (true){
            try {
                System.out.println("Quantidade:");
                int quantidade = Integer.parseInt(scanner.nextLine().trim());
                DadosProduto04.validacaoQuantidade(quantidade);
                return quantidade;
            }catch (QuantidadeDadosProduto e){
                System.out.println(e.getMessage());
                logger.log(Level.WARNING,"Quantidade inválida informada"+e.getMessage());
            }catch (NumberFormatException e){
                System.out.println("Erro. Quantidade inválida informada.");
                logger.log(Level.WARNING, "Quantidade inválida informada"+e.getMessage());
            }
        }
    }

    public static String validandoDescricao(){
        while (true){
            try {
                System.out.println("Descrição:");
                String descricao = scanner.nextLine().trim();
                DadosProduto04.validacaoDescricao(descricao);
                return descricao;
            }catch (DescricaoProdutoDadosProduto e){
                System.out.println(e.getMessage());
                logger.log(Level.WARNING,"Descrição informada inválida"+e.getMessage());
            }
        }
    }

    public boolean addProdutoSistema(DadosProduto04 dadosProduto04){
        return dadosProdutos.putIfAbsent(dadosProduto04.getNome(),dadosProduto04) == null;
    }

    public boolean atualizarProduto( String nome, double novoPreco, int novaQuantidade, String novaDescricao){
        return dadosProdutos.computeIfPresent(nome,(k,v) -> {
            v.setPreco(novoPreco);
            v.setQuantidade(novaQuantidade);
            v.setDescricao(novaDescricao);
            return v;
        }) != null;
    }

    public void listarProdutos(){
        if (dadosProdutos.isEmpty()){
            System.out.println("Nenhum produto foi cadastrado.");
            return;
        }
        dadosProdutos.forEach((nome,dadosProdutos) -> System.out.println(nome+" =>"+dadosProdutos));
    }

    public DadosProduto04 buscarProduto(String nome){
        return dadosProdutos.get(nome);
    }

    public boolean removerProduto(String nome){
        return dadosProdutos.remove(nome) == null;
    }


    public void gerarRelatorioEstoque(){
        dadosProdutos.entrySet().stream().sorted(Comparator.comparing(e -> e.getValue().getQuantidade()))
                .forEach(e -> System.out.println(e.getKey()
                +" Quantidada:"+e.getValue().getQuantidade()));
    }
    
    public double calcularValorTotalEstoque(){
        return dadosProdutos.values().stream()
                .mapToDouble(p -> p.getPreco() * p.getQuantidade()).sum();
    }






}
