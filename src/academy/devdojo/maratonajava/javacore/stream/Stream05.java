package academy.devdojo.maratonajava.javacore.stream;

import academy.devdojo.maratonajava.javacore.Aintroducaoclasses.dominio.Produto19;

import javax.crypto.spec.PSource;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class Stream05 {

    private List<Produto19> produto19s;

    public Stream05(){
        this.produto19s = new ArrayList<>();
    }

    private void removerProdutoSistema(String nome){
        if (produto19s.isEmpty()){
            System.out.println("Nenhum produto foi encontrado.");
            return;
        }
        boolean produtoEncontrado = produto19s.removeIf(produto19 -> produto19.getNome().equalsIgnoreCase(nome));
        if (produtoEncontrado){
            System.out.println("Produto removido com sucesso.");
            return;
        }
        System.out.println("Nenhum produto foi encontrado.");
    }

    private void pesquisaPorNome(String nome){
        Optional<Produto19> produtoEncontrado = produto19s.stream().filter(produto19 -> produto19.getNome().equalsIgnoreCase(nome)).findFirst();
        if (produtoEncontrado.isPresent()){
            System.out.println(produtoEncontrado);
            return;
        }
        System.out.println("Nenhum produto foi encontrado.");
    }

    private void pesquisaPorNome2(String nome){
        Optional<Produto19> produtoEncontrado = produto19s.stream().
                filter(produto19 -> produto19.getNome().equalsIgnoreCase(nome)).findFirst();
        produtoEncontrado.ifPresentOrElse(produto19 -> System.out.println(produtoEncontrado),
                () -> System.out.println("Nenhum produto foi encontrado."));
    }

    private void produtoEstoqueMaior100(){
        if (produto19s.isEmpty()){
            System.out.println("Nenhum produto foi encontrado.");
            return;
        }
        List<Produto19> produtosEncontrados = produto19s.stream().filter(produto19 -> produto19.getQuantidade() > 100)
                .collect(Collectors.toList());
        if (produtosEncontrados.isEmpty()){
            System.out.println("Nenhum produto encontrado.");
            return;
        }
        System.out.println(produtosEncontrados);
    }

    private void listarSomenteNome(){
        if (produto19s.isEmpty()){
            System.out.println("Nenhum produto foi encontrado.");
            return;
        }
        produto19s.stream().sorted(Comparator.comparing(Produto19::getNome))
                .map(Produto19::getNome)
                .forEach(System.out::println);
    }

    private void listarPorOrdemAlfabeticaZA(){
        if (produto19s.isEmpty()){
            System.out.println("Nenhum produto foi encontrado.");
            return;
        }
        produto19s.stream().sorted(Comparator.comparing(Produto19::getNome).reversed())
                .forEach(System.out::println);
    }

    private void listarSomenteNomeValores(){
        if (produto19s.isEmpty()){
            System.out.println("Nenhum produto foi encontrado.");
            return;
        }
        List<String> produtoEncontrados = produto19s.stream()
                .sorted(Comparator.comparing(Produto19::getValor))
                .map(produto19 -> "Produto:"+produto19.getNome()
                        +" |Valor tatal em estoque:"+(produto19.getValor() * produto19.getQuantidade()))
                .toList();
        produtoEncontrados.forEach(System.out::println);
    }

    private void listarSomenteValores(){
        if (produto19s.isEmpty()){
            System.out.println("Nenhum produto foi encontrado.");
            return;
        }
        produto19s.stream().sorted(Comparator.comparing(Produto19::getNome))
                .forEach(produto19 -> {
                    double valorTotal = produto19.getValor() * produto19.getQuantidade();
                    System.out.println("Produto:"+produto19.getNome()+" Valor total em estoque:R$"+valorTotal);
                });
    }

    private void listarProdutosCadastrados(){
        if (produto19s.isEmpty()){
            System.out.println("Nenhum produto foi encontrado.");
            return;
        }
        produto19s.forEach(System.out::println);
    }

    private void produtosQuantidadeMenor100(){
        if (produto19s.isEmpty()){
            System.out.println("Nenhum produto foi encontrado.");
            return;
        }
        List<Produto19> produtoEncontrado = produto19s.stream().filter(produto19 -> produto19.getQuantidade() <= 100)
                .sorted(Comparator.comparing(Produto19::getNome).reversed())
                .collect(Collectors.toList());
        if (produtoEncontrado.isEmpty()){
            System.out.println("Nenhum produto foi encontrado.");
            return;
        }
        System.out.println(produtoEncontrado);
    }

    private void produtosQuantidadeMenor100p2(){
        if (produto19s.isEmpty()){
            System.out.println("Nenhum produto foi encontrado.");
            return;
        }
        produto19s.stream().sorted(Comparator.comparing(Produto19::getNome))
                .filter(produto19 -> produto19.getQuantidade() <= 100)
                .map(produto19 -> "Produto:"+produto19.getNome()+" |Quantidade:"+produto19.getQuantidade()
                        +" |Preço:R$"+produto19.getValor())
                .forEach(System.out::println);

    }

    private void produtosQuantidadeMenor100p3(){
        if (produto19s.isEmpty()){
            System.out.println("Nenhum produto foi encontrado.");
            return;
        }
        List<String> produtosEncontrados = produto19s.stream()
                .filter(produto19 -> produto19.getQuantidade() < 100)
                .sorted(Comparator.comparing(Produto19::getNome))
                .map(produto19 -> "Produto:"+produto19.getNome()+" |Quantidade:"+produto19.getQuantidade()+" |Preço:R$"+produto19.getValor())
                .collect(Collectors.toList());
        if (produtosEncontrados.isEmpty()){
            System.out.println("Nenhum produto foi encotrado.");
            return;
        }
        System.out.println(produtosEncontrados);
    }

    private void contarElementos(){
        if (produto19s.isEmpty()){
            System.out.println("Nenhum produto foi encontrado.");
            return;
        }
        long contar = produto19s.stream()
                .distinct()
                .filter(produto19 -> produto19.getValor() <=5)
                .count();
        System.out.println(contar);
    }

    private void pesquisaPorPreco(){
        boolean temMais9 = produto19s.stream().anyMatch(produto19 -> produto19.getValor() > 9);
        boolean temMaiorQueZero = produto19s.stream().anyMatch(produto19 -> produto19.getValor() > 0);
        boolean nenhumNumeroMenorZero = produto19s.stream().noneMatch(produto19 -> produto19.getValor() < 0);

    }

    private void maiorValorFiltro(){
        produto19s.stream().filter(produto19 -> produto19.getValor() > 3)
                .max(Comparator.comparing(Produto19::getValor)) // Busca o produto com o maior valor dentro do filtro
                .ifPresentOrElse(System.out::println, () ->
                        System.out.println("Nenhum produto foi encontrado."));

    }

    private void primeiroValorFiltro(){
        produto19s.stream().filter(produto19 -> produto19.getValor() < 3)
                .findFirst()
                .ifPresentOrElse( );
    }


















}
