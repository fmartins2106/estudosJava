package academy.devdojo.maratonajava.javacore.stream;

import academy.devdojo.maratonajava.javacore.Aintroducaoclasses.dominio.Produto19;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class Stream07 {
    private List<Produto19> produto19s;

    public Stream07(){
        this.produto19s = new ArrayList<>();
    }

    public void addProdutoSistema(Produto19 produto19){
        produto19s.add(produto19);
        System.out.println("Produto cadastrado com sucesso.");
    }

    public void removerProdutoSistema(String nome){
        if (produto19s.isEmpty()){
            System.out.println("Nenhum produto foi cadastrado.");
            return;
        }
        boolean produtoEncontrado = produto19s.removeIf(produto19 -> produto19.getNome().equalsIgnoreCase(nome));
        if (produtoEncontrado){
            System.out.println("Produto removido com sucesso.");
            return;
        }
        System.out.println("Produto não encontrado. Verifique.");
    }

    public void buscaPorNome(String nome){
        if (produto19s.isEmpty()){
            System.out.println("Nenhum produto foi cadastrado.");
            return;
        }
        produto19s.stream()
                .filter(produto19 -> produto19.getNome().equalsIgnoreCase(nome))
                .findFirst()
                .ifPresentOrElse(System.out::println
                ,() -> System.out.println("Produto não encontrado."));
    }

    public void pesquisaPorEstoqueMaior100(){
        if (produto19s.isEmpty()){
            System.out.println("Nenhum produto foi cadastrado.");
            return;
        }
        List<Produto19> produtosMais100 = produto19s
                .stream().sorted(Comparator.comparing(Produto19::getNome).reversed())
                .filter(produto19 -> produto19.getQuantidade() > 100)
                .collect(Collectors.toList());
        if (produtosMais100.isEmpty()){
            System.out.println("Nenhum produto foi encontrado.");
            return;
        }
        System.out.println(produtosMais100);
    }

    public void listarDadosLista(){
        if (produto19s.isEmpty()){
            System.out.println("Nenhum produto foi encontrado.");
            return;
        }
        produto19s.forEach(System.out::println);
    }

    public void listarSomenteNomes(){
        if (produto19s.isEmpty()){
            System.out.println("Nenhum produto foi encontrado.");
            return;
        }
        List<String> somenteNomes = produto19s.stream()
                .sorted(Comparator.comparing(Produto19::getNome))
                .map(Produto19::getNome)
                .collect(Collectors.toList());
        if (somenteNomes.isEmpty()){
            System.out.println("Nenhum nome cadastrado.");
            return;
        }
        System.out.println(somenteNomes);
    }

    public void listarSomenteNome2(){
        if (produto19s.isEmpty()){
            System.out.println("Nenhum produto foi cadastrado.");
            return;
        }
        produto19s.stream()
                .sorted(Comparator.comparing(Produto19::getNome).reversed())
                .map(Produto19::getNome)
                .forEach(System.out::println);
    }

    public void listarSomenteNomeOrdemAlfabetica(){
        if (produto19s.isEmpty()){
            System.out.println("Nenhum produto foi cadastrado.");
            return;
        }
        produto19s.stream()
                .sorted(Comparator.comparing(Produto19::getNome))
                .map(Produto19::getNome)
                .forEach(System.out::println);
    }


    public void listarSomenteNomeValoresTotaisEstoque(){
        if (produto19s.isEmpty()){
            System.out.println("Nenhum produto foi cadastrado.");
            return;
        }
        produto19s.stream()
                .map(value -> "Produto:"+value.getNome()+" |Valor total:R$"+ (value.getValor() * value.getQuantidade()))
                .forEach(System.out::println);
    }

    public void listarSomenteValoresParte2(){
        if (produto19s.isEmpty()){
            System.out.println("Nenhum produto foi cadastrado.");
            return;
        }
        produto19s.stream()
                .sorted(Comparator.comparing(Produto19::getNome))
                .forEach(produto19 -> { double total = produto19.getValor() * produto19.getQuantidade();
                    System.out.println("Produto:"+produto19.getNome()+" |Valor total em estoque:R$"+ produto19.getValor());
                });
    }

    public void quantidadeMenor100(){
        if (produto19s.isEmpty()){
            System.out.println("Nenhum produto foi cadastrado.");
            return;
        }
        List<Produto19> produtosEncontrados = produto19s.stream()
                .filter(produto19 -> produto19.getQuantidade() < 100)
                .toList();
        if (produtosEncontrados.isEmpty()){
            System.out.println("Nenhum produto foi encontrado.");
            return;
        }
        System.out.println(produtosEncontrados);
    }

    public void faixaPreco(){
        if (produto19s.isEmpty()){
            System.out.println("Nenhum produto foi cadastrado.");
            return;
        }
        List<Produto19> produtosFaixaPreco = produto19s.stream()
                .filter(produto19 -> produto19.getValor() >= 5 && produto19.getValor() <= 10)
                .toList();
        if (produtosFaixaPreco.isEmpty()){
            System.out.println("Nenhum produto foi encontrado.");
            return;
        }
        System.out.println(produtosFaixaPreco);
    }

    public void contarElementos(){
        if (produto19s.isEmpty()){
            System.out.println("Nenhum produto foi cadastrado.");
            return;
        }
        long contar = produto19s.stream()
                .distinct()
                .filter(produto19 -> produto19.getValor() < 5)
                .count();
        System.out.println(contar);
    }

    private void pesquisaPorQuantidade(){
        if (produto19s.isEmpty()){
            System.out.println("Nenhum produto foi cadastrado.");
            return;
        }
        
    }



    public static void main(String[] args) {
        Stream07 stream07 = new Stream07();

        Produto19 produto1 = new Produto19(1,"Nome um","comida q",3.33,90,100);
        Produto19 produto2 = new Produto19(1,"Nome dois","comida a",5.33,200,300);
        Produto19 produto3 = new Produto19(1,"Nome tres","comida v",11.33,300,144);

        stream07.addProdutoSistema(produto1);
        stream07.addProdutoSistema(produto2);
        stream07.addProdutoSistema(produto3);

        stream07.listarSomenteNomeValoresTotaisEstoque();
        stream07.listarSomenteNomeOrdemAlfabetica();
        stream07.quantidadeMenor100();
        stream07.faixaPreco();
    }

}
