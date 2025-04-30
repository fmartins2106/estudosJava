package academy.devdojo.maratonajava.javacore.datas.test;

import academy.devdojo.maratonajava.javacore.datas.dominio.*;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;
import java.util.Scanner;

public class SistemaFaturas07 {
    private static final Scanner scanner = new Scanner(System.in);
    private static final List<Fatura07> faturas = new ArrayList<>();
    private static ResourceBundle bundle;

    public static void main(String[] args) {
        System.out.print("Idiomas [pt|en]:");
        bundle = Mensagens07.carregar(scanner.nextLine());

        CalculadoraMulta07 calculadoraMulta07 = new MultaFixadaPorDia07(2.0);

        int opcao = 0;
        do {
            System.out.println("\n" + bundle.getString("menu.opcao"));
            System.out.println("1 - "+ bundle.getString("menu.1"));
            System.out.println("2 - "+ bundle.getString("menu.2"));
            System.out.println("3 - "+ bundle.getString("menu.3"));
            try {
                System.out.print("Digite uma das opções acima:");
                opcao = Integer.parseInt(scanner.nextLine().trim());
            }catch (NumberFormatException e){
                System.out.println("Erro. Digite um opção válida.");
            }
            switch (opcao){
                case 1:
                    cadastroFatura();
                    break;
                case 2:
                    listarFaturas(calculadoraMulta07);
                    break;
                case 3:
                    break;
                default:
                    System.out.println("Erro. Digite uma opção válida.");
            }
        }while (opcao != 3);
        System.out.println(">>>Finalizando sistema.");

    }

    private static void cadastroFatura(){
        String numero = ValidadorDeEntradasFatura07.validacaoNumeroFatura();
        double valor = ValidadorDeEntradasFatura07.validancaoValor();
        LocalDate vencimento = ValidadorDeEntradasFatura07.validandoDataVencimento();

        Fatura07 fatura07 = new Fatura07(numero,valor,vencimento);
        faturas.add(fatura07);

        System.out.println("Vencimento sugerido para próxima fatura:"+fatura07.sugerirNovoVencimento());
    }

    private static void listarFaturas(CalculadoraMulta07 calculadoraMulta07){
        if (faturas.isEmpty()){
            System.out.println("Nenhuma fatura encontrada.");
            return;
        }
        for (Fatura07 fatura : faturas) {
            double multa = calculadoraMulta07.calcular(fatura);
            fatura.exibirResumo(bundle,multa);
        }
    }

}
