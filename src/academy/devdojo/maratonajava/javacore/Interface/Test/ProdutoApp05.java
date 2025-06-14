package academy.devdojo.maratonajava.javacore.Interface.Test;

import academy.devdojo.maratonajava.javacore.Interface.dominio.DadosProduto05;
import academy.devdojo.maratonajava.javacore.Interface.dominio.ProdutosLogger05;
import academy.devdojo.maratonajava.javacore.Interface.dominio.SistemaProdutos05;

import java.util.Scanner;
import java.util.logging.Level;

public class ProdutoApp05 {
    private static final Scanner scanner = new Scanner(System.in);
    private static final SistemaProdutos05 sistemaProduto05 = new SistemaProdutos05();

    public static void main(String[] args) {
        int opcao = 0;
        do {
            exibirMenu();
            opcao = capturarOpcao();
            switch (opcao){
                case 1:
                    cadastroProduto();
                    break;
                case 2:
                    atualizarProduto();
                    break;
                case 3:
                    retirarProdutoSistema();
                    break;
                case 4:
                    pesquisaPorNome();
                    break;
                case 5:
                    sistemaProduto05.getQuantidadeTotalEstoque();
                    break;
                case 6:
                    sistemaProduto05.listarProdutosSistema();
                    break;
                case 7:
                    System.out.println("Total em estoque R$"+sistemaProduto05.getValorTotalEstoque());
                    break;
                case 8:
                    break;
                default:
                    System.out.println("Opção inválida.");
            }

        }while (opcao != 8);
        System.out.println("Finalizando sistema.");
    }

    private static void pesquisaPorNome(){
        String nome = SistemaProdutos05.validandoNome();
        sistemaProduto05.buscaPorNome(nome);
    }
    private static void retirarProdutoSistema(){
        if (sistemaProduto05.getProdutosCadastrados().isEmpty()){
            System.out.println("Nenhum produto cadastrado.");
            return;
        }
        String nome = SistemaProdutos05.validandoNome();
        sistemaProduto05.retirarProdutoSistema(nome);
    }

    private static void atualizarProduto(){
        if (sistemaProduto05.getProdutosCadastrados().isEmpty()){
            System.out.println("Nenhum produto cadastrado.");
            return;
        }
        String nome = SistemaProdutos05.validandoNome();
        double preco = SistemaProdutos05.validandoPreco();
        int quantidade = SistemaProdutos05.validandoQuantidade();
        String descricao = SistemaProdutos05.validandoDescricao();
        sistemaProduto05.alterarDadosProduto(nome,preco,quantidade,descricao);
        System.out.println("Produto atualizado com sucesso.");
    }

    public static void cadastroProduto(){
        String nome = SistemaProdutos05.validandoNome();
        double preco = SistemaProdutos05.validandoPreco();
        int quantidade = SistemaProdutos05.validandoQuantidade();
        String descricao = SistemaProdutos05.validandoDescricao();
        DadosProduto05 dadosProduto05 = new DadosProduto05(nome,preco,quantidade,descricao);
        sistemaProduto05.addProdutoSistema(dadosProduto05);
        System.out.println("Produto cadastrado com sucesso.");
    }

    private static void exibirMenu(){
        System.out.println("[1] Adicionar Produto.");
        System.out.println("[2] Atualizar Produto.");
        System.out.println("[3] Remover produto.");
        System.out.println("[4] Buscar produto.");
        System.out.println("[5] Listar Prodotuto.");
        System.out.println("[6] Relatório de estoque.");
        System.out.println("[7] Valor total em estoque.");
        System.out.println("[8] Sair.");
    }

    private static int capturarOpcao(){
        while (true){
            try {
                System.out.println("Digite uma das opções acima:");
                return Integer.parseInt(scanner.nextLine().trim());
            }catch (NumberFormatException e){
                System.out.println("Erro, Digite uma opção válida.");
                ProdutosLogger05.getLogger(ProdutosLogger05.class).log(Level.WARNING,"Erro na escolhada opção. Opção inválida."+e.getMessage());
            }
        }
    }


}
