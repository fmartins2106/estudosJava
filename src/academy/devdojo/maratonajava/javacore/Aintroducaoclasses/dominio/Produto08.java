package academy.devdojo.maratonajava.javacore.Aintroducaoclasses.dominio;

import java.util.Scanner;

public class Produto08 implements Cloneable{
    private String nome;
    private double valor;
    private String categoria;

    public Produto08(String nome, double valor, String categoria){
        setNome(nome);
        setValor(valor);
        setCategoria(categoria);
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        if (nome == null || nome.isEmpty() || !nome.matches("^[\\p{L}]+( [\\p{L}]+)+$")){
            throw new IllegalArgumentException("ERRO. Campo nome não pode ser vazio, conter caracteres ou nome incompleto. Tente novamente.");
        }
        this.nome = formatoNome(nome);
    }

    public double getValor() {
        return valor;
    }

    public void setValor(double valor) {
        if ( valor<0 || valor>10000){
            throw new IllegalArgumentException("ERRO. Valor precisa ser maior que zero e menor que R$10.000,00");
        }
        this.valor = valor;
    }

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        if (categoria == null || categoria.isEmpty() || !categoria.matches("^[\\p{L}]+([\\p{L}]+)*$")){
            throw new IllegalArgumentException("ERRO. campo categoria não pode ser vazio ou nome conter caracteres. Tente novamente.");
        }
        this.categoria = formatoNome(categoria);
    }

    private static String formatoNome(String nome){
        String[] palavras = nome.toLowerCase().split("\\as+");
        StringBuilder nomeFormatado = new StringBuilder();
        for (String palavra : palavras){
            nomeFormatado.append(palavra.substring(0,1).toUpperCase()).append(palavra.substring(1)).append(" ");
        }
        return nomeFormatado.toString().trim();
    }
    public static String validandoNome(Scanner scanner){
        while (true){
            System.out.print("Nome:");
            String nome = scanner.nextLine().trim();
            if (nome.isEmpty()){
                System.out.println("Campo nome não pode ser vazio. Tente novamente.");
            }else {
                if (!nome.matches("^[\\p{L}]+( [\\p{L}]+)+$")){
                    System.out.println("Digite nome completo sem caracteres.");
                }else{
                    return formatoNome(nome);
                }
            }
        }
    }
    public static double validandoValor(Scanner scanner){
        while (true){
            try {
                System.out.print("Valor:R$");
                double valor = Double.parseDouble(scanner.nextLine());
                if (valor<0 || valor>10000){
                    System.out.println("Valor precisa ser maior que zero e menor que R$10.000,00");
                }else {
                    return valor;
                }
            }catch (NumberFormatException erro){
                System.out.println("Erro. Digite um valor válido. Tente novamente.");
            }
        }
    }
    public static String validandoCategoria(Scanner scanner){
        while (true){
            System.out.print("Categoria:");
            String categoria = scanner.nextLine().trim();
            if (categoria.isEmpty()){
                System.out.println("Campo categoria não pode ficar vazio. Tente novamente.");
            }else {
                if (!categoria.matches("^[\\p{L}]+( [\\p{L}]+)*$")){
                    System.out.println("ERRO. Campo categoria não pode conter caracteres. Tente novamente.");
                }else {
                    return categoria;
                }
            }
        }
    }
    public void exibindoRelatorio(int index, int produto08s){
        if (index==0){
            for (int n = 0; n < 65; n++) {
                System.out.print("");
            }
            System.out.println();
            System.out.printf("%-4s %-25s %-15s %-25s\n","No","Nome","Valor","Categoria");
            for (int n = 0; n < 65; n++) {
                System.out.print("=");
            }
            System.out.println();
        }
        System.out.printf("%-4d %-25s R$%-15.2f %-25s\n",index,getNome(),getValor(),getCategoria());
        if (index==produto08s-1){
            for (int n = 0; n < 65; n++) {
                System.out.print("=");
            }
            System.out.println();
        }

    }

    @Override
    public Produto08 clone(){
        try {
            return (Produto08) super.clone();
        }catch (CloneNotSupportedException e){
            throw new AssertionError("Clonagem não suportada.");
        }
    }

}
