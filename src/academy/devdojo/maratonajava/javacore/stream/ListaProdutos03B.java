package academy.devdojo.maratonajava.javacore.stream;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class ListaProdutos03B {
    private static List<ProdutoStream03> produtosLoja = new ArrayList<>(List.of(
            new ProdutoStream03("Chaleira Eletrica",100,120.23,Categoria03.ELETRONICO),
            new ProdutoStream03("Arroz branco 1kg",222,2.32,Categoria03.ALIMENTO),
            new ProdutoStream03("Feijão Carioca 1kg",222,5.32,Categoria03.ALIMENTO),
            new ProdutoStream03("Trigo 1kg",222,3.32,Categoria03.ALIMENTO),
            new ProdutoStream03("Iphone",442,3.455, Categoria03.ELETRONICO),
            new ProdutoStream03("Camisa branca basica",522,60.32, Categoria03.VESTUARIO),
            new ProdutoStream03("Calça Jeans Masculina",2222,90.32,Categoria03.VESTUARIO),
            new ProdutoStream03("Liquidificador",322,122.52,Categoria03.ELETRODOMESTICO),
            new ProdutoStream03("Macarrão 500gr",222,2.12,Categoria03.ALIMENTO)
    ));
    public static Promocao03 getPromocao(ProdutoStream03 produtoStream03){
        return produtoStream03.getPreco() < 3 ? Promocao03.PROMOCAO : Promocao03.PRECO_NORMAL;
    }

    public static Map<Promocao03,List<ProdutoStream03>> agruparPorPromocao(List<ProdutoStream03> agrupados){
            return agrupados.stream()
                    .collect(Collectors.groupingBy(produtoStream03 -> produtoStream03.getPreco() < 5 ?
                            Promocao03.PROMOCAO : Promocao03.PRECO_NORMAL));
    }

    public static Map<Categoria03,Map<Promocao03,List<ProdutoStream03>>> agruparPorCategoriaEPromocao(List<ProdutoStream03> produtos){
        return produtos.stream()
                .collect(Collectors.groupingBy(ProdutoStream03::getCategoria03,
                        Collectors.groupingBy(produtoStream03 -> produtoStream03.getPreco() < 6 ?
                                Promocao03.PROMOCAO : Promocao03.PRECO_NORMAL)));
    }

}

