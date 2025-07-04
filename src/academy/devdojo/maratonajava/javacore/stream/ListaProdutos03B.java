package academy.devdojo.maratonajava.javacore.stream;

import java.util.*;
import java.util.function.BinaryOperator;
import java.util.function.Function;
import java.util.stream.Collectors;

public class ListaProdutos03B {
    private static List<ProdutoStream03> produtosLoja = new ArrayList<>(List.of(
            new ProdutoStream03("Chaleira Eletrica", 100, 120.23, Categoria03.ELETRONICO),
            new ProdutoStream03("Arroz branco 1kg", 222, 2.32, Categoria03.ALIMENTO),
            new ProdutoStream03("Feijão Carioca 1kg", 222, 5.32, Categoria03.ALIMENTO),
            new ProdutoStream03("Trigo 1kg", 222, 3.32, Categoria03.ALIMENTO),
            new ProdutoStream03("Iphone", 442, 3.455, Categoria03.ELETRONICO),
            new ProdutoStream03("Camisa branca basica", 522, 60.32, Categoria03.VESTUARIO),
            new ProdutoStream03("Calça Jeans Masculina", 2222, 90.32, Categoria03.VESTUARIO),
            new ProdutoStream03("Liquidificador", 322, 122.52, Categoria03.ELETRODOMESTICO),
            new ProdutoStream03("Macarrão 500gr", 222, 2.12, Categoria03.ALIMENTO)
    ));

    public static Promocao03 getPromocao(ProdutoStream03 produtoStream03){
        return produtoStream03.getPreco() < 5 ? Promocao03.PROMOCAO : Promocao03.PRECO_NORMAL;
    }

    public static Map<Promocao03,List<ProdutoStream03>> agruparPorPromocao(List<ProdutoStream03> produtos){
        return produtos.stream().collect(
                Collectors.groupingBy(produtoStream03 -> produtoStream03.getPreco() < 5 ?
                        Promocao03.PROMOCAO : Promocao03.PRECO_NORMAL));
    }


     public static Map<Categoria03,Map<Promocao03,List<ProdutoStream03>>> agruparPorCategoriaEPromocao(List<ProdutoStream03> produtos){
        return produtos.stream()
                .collect(Collectors.groupingBy(ProdutoStream03::getCategoria03,
                        Collectors.groupingBy(produtoStream03 -> produtoStream03.getPreco() < 6 ?
                                Promocao03.PROMOCAO : Promocao03.PRECO_NORMAL)));
     }

     public static Map<Categoria03,Long> contandoProdutosCategoria(List<ProdutoStream03> produtos){
        return produtos.stream().collect(Collectors.groupingBy(ProdutoStream03::getCategoria03,
                Collectors.counting()));
     }
//    ________________________________________________________________________________________________________________
     public static Map<Categoria03,List<ProdutoStream03>> agrupandoPorCategoria(){
        return produtosLoja.stream().collect(Collectors.groupingBy(
                ProdutoStream03::getCategoria03));
     }

     public static Map<Promocao03,List<ProdutoStream03>> agruparPorPromocao2(List<ProdutoStream03> produtos){
        return produtosLoja.stream().collect(Collectors.groupingBy(
                produtoStream03 -> produtoStream03.getPreco() < 6 ?
                        Promocao03.PROMOCAO : Promocao03.PRECO_NORMAL));
     }

     public static Map<Categoria03,Map<Promocao03,List<ProdutoStream03>>> agruparPorCategoriaPromocao(List<ProdutoStream03> produtos){
        return produtos.stream().collect(Collectors
                .groupingBy(ProdutoStream03::getCategoria03,
                        Collectors.groupingBy(produto
                                -> produto.getPreco() < 6 ? Promocao03.PROMOCAO : Promocao03.PRECO_NORMAL)));
     }

     public static Map<Categoria03,Long> contandoProdutosCategoria2(List<ProdutoStream03> produto){
        return produto.stream().collect(Collectors
                .groupingBy(ProdutoStream03::getCategoria03,Collectors.counting()));
     }

     public static Map<Categoria03,Optional<ProdutoStream03>> maiorPrecoCategoria3(List<ProdutoStream03> produto){
        return produto.stream().collect(Collectors.groupingBy(ProdutoStream03::getCategoria03,
                Collectors.maxBy(Comparator.comparing(ProdutoStream03::getPreco))));
     }

     public static Map<Categoria03,DoubleSummaryStatistics> estatisticasCategoria(List<ProdutoStream03> produtos){
        return produtos.stream().collect(Collectors
                .groupingBy(ProdutoStream03::getCategoria03,
                        Collectors.summarizingDouble(ProdutoStream03::getPreco)));
     }


     public static Map<Categoria03,Optional<ProdutoStream03>> getMaiorPrecoCategoria(List<ProdutoStream03> produtos){
        return produtos.stream().collect(Collectors
                .groupingBy(ProdutoStream03::getCategoria03,
                        Collectors.maxBy(Comparator.comparing(ProdutoStream03::getPreco))));
     }



     //________________________________________________________________________________________________________
     public static Map<Categoria03, Optional<ProdutoStream03>> maisCaroPorCategoriaComOptional(List<ProdutoStream03> produtos){
        return produtos.stream().collect(Collectors.groupingBy(
                ProdutoStream03::getCategoria03
                ,Collectors.maxBy(Comparator.comparing(ProdutoStream03::getPreco))));
     }


    public static Map<Categoria03,ProdutoStream03> maisCaroPorCategoria(List<ProdutoStream03> produtos){
        return produtos.stream()
                .collect(Collectors.toMap(
                        ProdutoStream03::getCategoria03,
                        Function.identity(),
                        BinaryOperator.maxBy(Comparator.comparing(ProdutoStream03::getPreco))
                ));
    }

    public static Map<Categoria03,DoubleSummaryStatistics> estatisticasPorCategoria(List<ProdutoStream03> produtos){
        return produtos.stream()
                .collect(Collectors.groupingBy(ProdutoStream03::getCategoria03,
                        Collectors.summarizingDouble(ProdutoStream03::getPreco)));
    }

    public static Map<Categoria03,DoubleSummaryStatistics> estatisticasPorCategoria2(List<ProdutoStream03> produtos){
        return produtos.stream().collect(Collectors.groupingBy(ProdutoStream03::getCategoria03,
                Collectors.summarizingDouble(ProdutoStream03::getPreco)));
    }


    public static Map<Categoria03,DoubleSummaryStatistics> estatisticasPrecoProduto3(List<ProdutoStream03> produtos){
        return produtos.stream().collect(Collectors
                .groupingBy(ProdutoStream03::getCategoria03,
                        Collectors.summarizingDouble(ProdutoStream03::getPreco)));
    }


    public static void main(String[] args) {
        for (ProdutoStream03 produtoStream03 : produtosLoja) {
            System.out.println(getPromocao(produtoStream03));
        }

        System.out.println("______________________________________________________________");
        agruparPorPromocao(produtosLoja).forEach((promocao03, produto) -> {
            System.out.println("Preço:"+promocao03.toString());
            produto.forEach(p-> System.out.println(" -Nome:"+p.getNome()+" |R$:"+p.getPreco()));
        });
        System.out.println("_________________________________________________");

        agruparPorCategoriaEPromocao(produtosLoja).forEach((categoria03, mapaPromocao) -> {
            System.out.println("Categoria:"+categoria03); mapaPromocao.forEach((promocao03, produtos) -> {
                System.out.println("Preço:"+promocao03);
                produtos.forEach(p -> System.out.println(" -"+p.getNome()+" |R$"+p.getPreco()));
            });
        });

//        opção 1
        contandoProdutosCategoria(produtosLoja).forEach((categoria03, aLong) ->
            System.out.println("Categoria:"+categoria03+" |Quantidade:"+aLong)
        );

//        opção 2
        System.out.println("_________________________________________________");
        System.out.println("Agrupamento:"+contandoProdutosCategoria(produtosLoja));
        System.out.println("_________________________________________________");

        maisCaroPorCategoria(produtosLoja).forEach((categoria03, produtoStream03) ->
                System.out.println("Categoria:"+categoria03+" |Nome:"+produtoStream03.getNome()+ "|Preço:R$"+produtoStream03.getPreco()));

        System.out.println(contandoProdutosCategoria2(produtosLoja));

        System.out.println("_______________________________");
        System.out.println(maisCaroPorCategoriaComOptional(produtosLoja));
        System.out.println("++++++++++++++++++++++++++++++++++++++");
        System.out.println(maisCaroPorCategoria(produtosLoja));

        System.out.println("++++++++++++++++++++++++++++++++++++++");
        System.out.println(estatisticasPorCategoria(produtosLoja));

        estatisticasPorCategoria(produtosLoja).forEach((categoria03, doubleSummaryStatistics) -> {
            System.out.println("Produto:"+categoria03+" |Média:"+doubleSummaryStatistics.getAverage()) ;
        });
    }


}
