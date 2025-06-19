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

}
