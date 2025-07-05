package academy.devdojo.maratonajava.javacore.map;

import academy.devdojo.maratonajava.javacore.Interface.dominio.DadosProduto05;

import java.util.LinkedHashMap;
import java.util.Map;

public class SistemaProdutosComMap08 {
    private static Map<String, DadosProduto05> dadosCadastroProdutos = new LinkedHashMap<>();

    public boolean addProdutoSistema(DadosProduto05 dadosProduto05){
        return dadosCadastroProdutos.putIfAbsent(dadosProduto05.getNome(),dadosProduto05) == null;
    }

    public boolean addProdutoSistema2(DadosProduto05 dadosProduto05){
        if (dadosCadastroProdutos.containsKey(dadosProduto05.getNome())){
            System.out.println("Operação inválida, produto já cadastrado.");
            return false;
        }
        dadosCadastroProdutos.put(dadosProduto05.getNome(),dadosProduto05);
        System.out.println("Produto cadastrado com sucesso.");
        return true;
    }

    public boolean addProdutolsSistema3(DadosProduto05 dadosProduto05){
        DadosProduto05 dadosProduto6 = dadosCadastroProdutos
                .putIfAbsent(dadosProduto05.getNome(),dadosProduto05);
        if (dadosProduto6 != null){
            System.out.println("Produto já cadastrado.");
            return false;
        }
        System.out.println("Produto cadastrado com sucesso.");
        return true;
    }

    public void getRelatorioEstoque(){
        dadosCadastroProdutos.entrySet().stream()
                .map(produto -> "Produto:"+produto.getKey()+" |Estoque:"+produto.getValue().getQuantidade())
                .toList()
                .forEach(System.out::println);
    }

    public double getValorEstoque(){
        return dadosCadastroProdutos.values().stream()
                .mapToDouble(produto -> produto.getPreco() * produto.getQuantidade())
                .sum();
    }

}
