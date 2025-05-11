package academy.devdojo.maratonajava.javacore.heranca.dominio;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.Scanner;

public class ProdutosPereciveis05 extends Produto05{
    private LocalDate dataValidade;

    public ProdutosPereciveis05(int codigo, String nome, String categoria, int quantidade, double precoCompra, double precoVenda, String fornecedor, LocalDate dataValidade) {
        super(codigo, nome, categoria, quantidade, precoCompra, precoVenda, fornecedor);
        this.dataValidade = dataValidade;
    }

    public LocalDate getDataValidade() {
        return dataValidade;
    }

    public void setDataValidade(LocalDate dataValidade) {
        this.dataValidade = dataValidade;
    }

    public boolean isValido(){
        return (LocalDate.now().isBefore(dataValidade));
    }

    public static ProdutosPereciveis05 validandoProdutosPereciveis(Scanner scanner,int codigo, String nome, String categoria, int quantidade, double precoCompra, double precoVenda, String fornecedor ){
        LocalDate dataValidade = null;
        while (true){
            try {
                System.out.print("Data de vencimento(AAAA-MM-DD):");
                String inputDate = scanner.nextLine().trim();
                dataValidade = LocalDate.parse(inputDate, DateTimeFormatter.ISO_LOCAL_DATE);
                break;
            }catch (DateTimeParseException e){
                System.out.println("Digite data no formato válido(AAAA-MM-DD)");
            }
        }
        return new ProdutosPereciveis05(codigo,nome,categoria,quantidade,precoCompra,precoVenda,fornecedor,dataValidade);
    }
    @Override
    public String toString(){
        return super.toString()+ String.format(" |Validade: "+dataValidade);
    }

}
