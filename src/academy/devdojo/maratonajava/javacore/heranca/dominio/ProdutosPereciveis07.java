package academy.devdojo.maratonajava.javacore.heranca.dominio;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.Scanner;

public class ProdutosPereciveis07 extends Produto07{
    private LocalDate dataValidade;

    public ProdutosPereciveis07(int codigo, String nome, String categoria, int quantidade, double precoCompra, double precoVenda, String fornecedor, LocalDate dataValidade) {
        super(codigo, nome, categoria, quantidade, precoCompra, precoVenda, fornecedor);
        setDataValidade(dataValidade);
    }

    public LocalDate getDataValidade() {
        return dataValidade;
    }

    public void setDataValidade(LocalDate dataValidade) {
        this.dataValidade = dataValidade;
    }

    public boolean isValido(){
        return LocalDate.now().isBefore(dataValidade);
    }

    public static ProdutosPereciveis07 validandoDataValidade(Scanner scanner, int codigo, String nome, String categoria, int quantidade, double precoCompra, double precoVenda, String fornecedor){
        LocalDate dataValidade = null;
        while (true){
            try {
                System.out.print("Data de válidade:");
                String inputData = scanner.nextLine().trim();
                dataValidade = LocalDate.parse(inputData, DateTimeFormatter.ISO_LOCAL_DATE);
                break;
            }catch (DateTimeParseException e){
                System.out.println("Digite uma data no formato AAAA-MM-DD");
            }
        }
        return new ProdutosPereciveis07(codigo,nome,categoria,quantidade,precoCompra,precoVenda,fornecedor,dataValidade);
    }

    @Override
    public String toString(){
        return super.toString()+String.format("|Válidade: "+dataValidade);
    }
}
