package academy.devdojo.maratonajava.javacore.Interface.Test;

import academy.devdojo.maratonajava.javacore.Interface.dominio.DadosProduto01;
import academy.devdojo.maratonajava.javacore.Interface.dominio.SistemaProdutos;

import java.util.Scanner;

public class ProdutoApp01 {
    private static final Scanner scanner = new Scanner(System.in);
    private static final SistemaProdutos sistemaProdutos = new SistemaProdutos();

    public static void main(String[] args) {
        int opcao;
        do {
            exibirMenu();
            opcao = capturandoOpcao();
            switch (opcao){
                case 1:
                    adicionarProduto();
                    break;
                case 2:
                    atualizarProduto();
                    break;
                case 3:
                    removerProduto();
                    break;
                case 4:
                    buscarProduto();
                    break;
                case 5:
                    sistemaProdutos.listarProdutos();
                    break;
                case 6:
                    sistemaProdutos.gerarRelatorioEstoque();
                    break;
                case 7:
                    System.out.println("Total em estoque:R$"+sistemaProdutos.calcularValorTotalEstoque());
                case 8:
                    break;
                default:
                    System.out.println("Opção inválida.");

            }
        }while (opcao == 8);
        System.out.println(">>>>>Finalizando sistema.");
    }

    private static int capturandoOpcao(){
        while (true){
            try {
                System.out.println("Digite uma das opções acima:");
                return Integer.parseInt(scanner.nextLine().trim());
            }catch (NumberFormatException e){
                System.out.println("Erro. Digite uma opção válida.");
            }
        }
    }

    private static void exibirMenu(){
        System.out.println("[1] Adicionar produto.");
        System.out.println("[2] Atualizar produto.");
        System.out.println("[3] Remover produto.");
        System.out.println("[4] Buscar produto. ");
        System.out.println("[5] Listar produtos.");
        System.out.println("[6] Relatório de estoque.");
        System.out.println("[7] Valor total em estoque.");
        System.out.println("[8] Sair.");
        System.out.println("[9] Relatório de estoque.");
    }

    private static void adicionarProduto(){
        String nome = SistemaProdutos.validandoNome();
        double preco = SistemaProdutos.validandoPreco();
        int quantidade = SistemaProdutos.validandoQuantidade();
        String descricao = SistemaProdutos.validandoDescricao();

        DadosProduto01 produto01 = new DadosProduto01(nome,preco,quantidade,descricao);
        if (sistemaProdutos.addProduto(produto01)){
            System.out.println("Produto adicionado.");
            return;
        }
        System.out.println("Produto já existe.");
    }

    private static void atualizarProduto(){
        String nome = SistemaProdutos.validandoNome();
        double preoc = SistemaProdutos.validandoPreco();
        int quantidade = SistemaProdutos.validandoQuantidade();
        String descricao = SistemaProdutos.validandoDescricao();
        if (sistemaProdutos.altualzarProduto(nome,preoc,quantidade,descricao)){
            System.out.println("Produto atualizado.");
            return;
        }
        System.out.println("Produto não encontrado.");
    }

    private static void removerProduto(){
        String nome = SistemaProdutos.validandoNome();
        if (sistemaProdutos.removerProduto(nome)){
            System.out.println("Produto removido.");
            return;
        }
        System.out.println("Produto não encontrado.");
    }

    private static void buscarProduto(){
        String nome = SistemaProdutos.validandoNome();
        DadosProduto01 produto01 = sistemaProdutos.buscarProduto(nome);
        if (produto01 != null){
            System.out.println(produto01);
            return;
        }
        System.out.println("Produto não encontrado.");
    }
}
