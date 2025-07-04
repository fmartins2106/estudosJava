package academy.devdojo.maratonajava.javacore.stream;

import academy.devdojo.maratonajava.javacore.Aintroducaoclasses.dominio.Produto19;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class Stream10 {

    private List<Produto19> produto19s;

    public Stream10(){
        this.produto19s = new ArrayList<>();
    }

    public void excluirProduto(String nome){
         boolean produtoEncontrado = produto19s.removeIf(produto19 -> produto19.getNome().equalsIgnoreCase(nome));
        if (!produtoEncontrado){
            System.out.println("Nenhum produto foi encontrado.");
            return;
        }
        System.out.println("Produto removido com sucesso.");
    }

    public void excluirProduto2(int codigo){
        produto19s.stream()
                .filter(produto19 -> produto19.getCodigo() ==  codigo).findFirst()
                .ifPresentOrElse(produto19 -> {
                    produto19s.remove(produto19);
                    System.out.println("Produto removido com sucesso");
                }, () -> System.out.println("Produto não encontrado"));
    }

    public void pesquisaPorNome(String nome){
        produto19s.stream().filter(produto19 -> produto19.getNome().equalsIgnoreCase(nome)).findFirst()
                .ifPresentOrElse(System.out::println, () -> System.out.println("Produto não encontrado."));
    }

    public void pesquisaPorNome2(String nome){
        produto19s.stream().filter(produto19 -> produto19.getNome().equalsIgnoreCase(nome))
                .forEach(System.out::println);
    }

    public void pesquisaEstoqueMais100(){
        produto19s.stream().filter(produto19 -> produto19.getQuantidade() > 100)
                .forEach(System.out::println);
    }

    public void pesquisaEstoqueMais1002(){
        List<Produto19> produtosEncontrados = produto19s.stream().filter(produto19 -> produto19.getQuantidade() > 100)
                .toList();
        if (produtosEncontrados.isEmpty()) {
            System.out.println("Produtos não encontrados.");
            return;
        }
        System.out.println(produtosEncontrados);


    }



}
