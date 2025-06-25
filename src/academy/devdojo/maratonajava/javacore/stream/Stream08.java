package academy.devdojo.maratonajava.javacore.stream;

import academy.devdojo.maratonajava.javacore.Aintroducaoclasses.dominio.Produto19;

import java.util.ArrayList;
import java.util.List;

public class Stream08 {
    private List<Produto19> produto19s;

    public Stream08(){
        this.produto19s = new ArrayList<>();
    }

    public void excluirDados(String nome){
        produto19s.stream()
                .filter(produto19 -> produto19.getNome().equalsIgnoreCase(nome))
                .findFirst()
                .ifPresentOrElse(produto19 -> System.out.println("Produto excluido com sucesso.")
                        , () -> System.out.println("Produt não encontrado."));
    }

    public void excluirProduto2(String nome){
        boolean produtoEncontrado = produto19s.removeIf(produto19 -> produto19.getNome().equalsIgnoreCase(nome));
        if (produtoEncontrado){
            System.out.println("Produto removido com sucesso.");
            return;
        }
        System.out.println("Produto não encontrado. Verifique.");
    }

    public void pesquisaPorNome(){
        if (produto19s.isEmpty()){
            System.out.println("Nenhum produto foi encontrado.");
            return;
        }
        produto19s.forEach(System.out::println);
    }

    public void pesquisaPorNome(String nome){
        produto19s.stream()
                .filter(produto19 -> produto19.getNome().equalsIgnoreCase(nome))
                .findFirst()
                .ifPresentOrElse(System.out::println, () -> System.out.println("Nome não encontrado."));
    }


}
