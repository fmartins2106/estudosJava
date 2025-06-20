package academy.devdojo.maratonajava.javacore.stream;

import academy.devdojo.maratonajava.javacore.Aintroducaoclasses.dominio.Produto19;

import java.util.*;
import java.util.stream.Collectors;

public class Stream03 {
    private static final Scanner scanner = new Scanner(System.in);

    private List<Produto19> produto19s;

    public Stream03(){
        this.produto19s = new ArrayList<>();
    }

    private void excluirProdutoSistema(String nome){
        boolean produtoEncontrado = produto19s.removeIf(produto19 -> produto19.getNome().equalsIgnoreCase(nome));
        if (produtoEncontrado){
            System.out.println(produtoEncontrado);
            return;
        }
        System.out.println("Nenhum produto foi encontrado com nome"+nome);
    }

    private void listarProduto(){
        if (produto19s.isEmpty()){
            System.out.println("Nenhum produto foi encontrado.");
            return;
        }
        produto19s.forEach(System.out::println);
    }

    private void buscarPorCodigo(int codigo){
        List<Produto19> produtoEncontrado = produto19s.stream().filter(produto19 -> produto19.getCodigo() == codigo)
                .collect(Collectors.toList());
        if (produtoEncontrado.isEmpty()){
            System.out.println("Nenhum produto foi encontrado.");
            return;
        }
        System.out.println(produtoEncontrado);
    }

    private void buscarPorNome(String nome){
        if (produto19s.isEmpty()){
            System.out.println("Nenhum produto foi encontrado.");
            return;
        }
        Optional<Produto19> produtoEncontrado = produto19s.stream().filter(produto19 -> produto19.getNome().equalsIgnoreCase(nome)).findFirst();
        if (produtoEncontrado.isPresent()){
            System.out.println(produtoEncontrado);
            return;
        }
        System.out.println("Produto não encontrado com nome:"+nome);
    }

    private void listarSomenteNomes(){
        if (produto19s.isEmpty()){
            System.out.println("Nenhum produto foi encontrado.");
            return;
        }
        produto19s.stream().map(Produto19::getNome)
                .collect(Collectors.toList())
                .forEach(System.out::println);
    }

    private void listarPorOrdemAlfabetica(){
        if (produto19s.isEmpty()){
            System.out.println("Nenhum produto foi encontrado.");
            return;
        }
        produto19s.stream().sorted(Comparator.comparing(Produto19::getNome))
                .collect(Collectors.toList())
                .forEach(System.out::println);
    }

    private void produtosMaior100Unidade(){
        if (produto19s.isEmpty()){
            System.out.println("Nenhum produto foi encontrado.");
            return;
        }
        List<Produto19> produtoEncontrado = produto19s.stream().filter(produto19 -> produto19.getQuantidade() > 100)
                .collect(Collectors.toList());
        if (produtoEncontrado.isEmpty()){
            System.out.println("Nenhum produto foi encontrado");
            return;
        }
        System.out.println(produtoEncontrado);
    }
//__________________________________________________________________________________________________________________
//    Conteúdo novo

    private void listarPrecosMenores4(){
        List<String> produtoEncontrado = produto19s.stream()
                .sorted(Comparator.comparing(Produto19::getNome))
                .filter(produto19 -> produto19.getQuantidade() <= 100)
                .limit(99)
                .map(Produto19::getNome)
                .collect(Collectors.toList());
        System.out.println(produtoEncontrado);
    }

    private void contarElementos(){
        long contar = produto19s.stream()
                .distinct()
                .filter(produto19 -> produto19.getValor() <= 4)
                .count();
        System.out.println(contar);
    }

//    Pesquisa sobre flatMap
//    Pesquisar sobre reduce

    private void pesquisasPreco(){
        produto19s.stream().anyMatch(produto19 -> produto19.getValor() > 9);
        produto19s.stream().anyMatch(produto19 -> produto19.getValor() > 0);
        produto19s.stream().noneMatch(produto19 -> produto19.getValor() < 0);

        produto19s.stream().filter(produto19 -> produto19.getValor() > 3)
                .findFirst()
                .ifPresent(System.out::println);

        produto19s.stream().filter(produto19 -> produto19.getValor() > 3)
                .max(Comparator.comparing(Produto19::getValor))
                .ifPresent(System.out::println);
    }

    private void somarPrecos(){
        double somaValores = produto19s.stream()
                .mapToDouble(Produto19::getValor)
                .filter(valor -> valor < 3)
                .sum();
    }




}
