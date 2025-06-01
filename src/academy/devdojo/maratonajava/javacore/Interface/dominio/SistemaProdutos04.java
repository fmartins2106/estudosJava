package academy.devdojo.maratonajava.javacore.Interface.dominio;

import academy.devdojo.maratonajava.javacore.excessoes.DescricaoProdutoDadosProduto;
import academy.devdojo.maratonajava.javacore.excessoes.NomeDadosProduto;
import academy.devdojo.maratonajava.javacore.excessoes.PrecoDadosProduto;
import academy.devdojo.maratonajava.javacore.excessoes.QuantidadeDadosProduto;

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
    private final Map<String,DadosProduto04> dadosProdutos = new LinkedHashMap<>();

    private static final Logger logger =
            Logger.getLogger(SistemaProdutos04.class.getName());

    static {
        configurarLogger();
    }

    private static void configurarLogger(){
        try {
            Path pastaLogs = Path.of("Logs");
            if (Files.notExists(pastaLogs)){
                Files.createDirectories(pastaLogs);
            }
            FileHandler fileHandler = new FileHandler("logs/logs_sistema_produtos.log",true);
            fileHandler.setLevel(Level.ALL);
            fileHandler.setFormatter(new SimpleFormatter());

            logger.addHandler(fileHandler);
            logger.setUseParentHandlers(false);
        }catch (IOException e){
            System.err.println("Erro ao configurar logger:"+e.getMessage());
            e.printStackTrace();
        }
    }

    public static String validandoNome(){
        while (true){
            try {
                System.out.print("Nome:");
                String nome = scanner.nextLine().trim();
                DadosProduto04.validacaoNome(nome);
                return nome;
            }catch (NomeDadosProduto e){
                System.out.println(e.getMessage());
                logger.log(Level.WARNING,"Nome inválido informado:"+e.getMessage(),e);
            }
        }
    }

    public static double validandoPreco(){
        while (true){
            try {
                System.out.print("Preço:R$");
                double preco = Double.parseDouble(scanner.nextLine().trim());
                DadosProduto04.validacaoPreco(preco);
                return preco;
            }catch (NumberFormatException e){
                System.out.println("Erro. Preço inválida. Tente novamente.");
                logger.log(Level.WARNING,"Preço inválido informado"+e.getMessage(),e);
            }catch (PrecoDadosProduto e){
                System.out.println(e.getMessage());
                logger.log(Level.WARNING,"Preço inválido informado"+e.getMessage(),e);
            }
        }
    }

    public static int validandoQuantidade(){
        while (true){
            try {
                System.out.print("Quantidade:");
                int quantidade = Integer.parseInt(scanner.nextLine().trim());
                DadosProduto04.validacaoQuantidade(quantidade);
                return quantidade;
            }catch (NumberFormatException e){
                System.out.println("Erro. Digite um valor válido para definir quantidade.");
                logger.log(Level.WARNING, "Quantidade informada inválida:"+e.getMessage(),e);
            }catch (QuantidadeDadosProduto e) {
                System.out.println(e.getMessage());
                logger.log(Level.WARNING, "Quantidade informada inválida:" + e.getMessage(), e);
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
                logger.log(Level.WARNING, "Descrição informada inválida:"+ e.getMessage(),e);
            }
        }
    }

    public boolean addProdutoSistema(DadosProduto04 dadosProduto04){
        return dadosProdutos.putIfAbsent(dadosProduto04.getNome(),dadosProduto04) == null;
    }

    public boolean atualizarProduto(String nome, double novPreco, int novaQuantidade, String novaDescricao){
        return dadosProdutos.computeIfPresent(nome,(k,v) ->{
            v.setPreco(novPreco);
            v.setQuantidade(novaQuantidade);
            v.setDescricao(novaDescricao);
            return v;
        }) != null;
    }

    public boolean removerProduto(String nome){
        return dadosProdutos.remove(nome) == null;
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

    public void gerarRelatorioEstoque(){
        dadosProdutos.entrySet().stream().sorted(Comparator.comparing
                        (e -> e.getValue().getQuantidade()))
                .forEach(e -> System.out.println(e.getKey()
                        +" Quantidade:"+e.getValue().getQuantidade()));
    }

    public double calcularValorTotalEstoque(){
        return dadosProdutos.values().stream()
                .mapToDouble(p -> p.getPreco() * p.getQuantidade()).sum();
    }








}
