package academy.devdojo.maratonajava.javacore.heranca.dominio;

import academy.devdojo.maratonajava.javacore.Abstracao.dominio.Cliente28;

import java.util.Arrays;

public class Pessoa27 {
    private String nome;
    private String cpf;
    private int idade;

    public Pessoa27(String nome, String cpf, int idade) {
        setNome(nome);
        setCpf(cpf);
        setIdade(idade);
    }

    public static void validacaoNome(String nome){
        if (nome == null || nome.isEmpty() || !nome.matches("\\p{L}+( \\p{L}+)+$")){
            throw new IllegalArgumentException(Cliente28.MensagensValidacaoCliente28.NOME.getDescricao());
        }
    }


    public static String formatoNome(String nome){
        String[] palavras = nome.toLowerCase().split("\\s+");
        StringBuilder nomeFormatado = new StringBuilder();
        for (String palavra : palavras) {
            nomeFormatado.append(palavra.substring(0,1).toUpperCase())
                    .append(palavra.substring(1))
                    .append(" ");
        }
        return nomeFormatado.toString().trim();
    }

    public static void validacaoCpf(String cpf){
        if (cpf == null || cpf.length() != 11 || !cpf.matches("\\d{11}") || !isCpfValido(cpf)){
            throw new IllegalArgumentException(MensagensValidacaoPessoa27.CPF.getDescricao());
        }
    }

    public static boolean isCpfValido(String cpf){
        if (cpf.chars().distinct().count() == 1){
            return false;
        }
        int soma = 0;
        for (int i = 0; i < 9; i++) {
            soma+=(cpf.charAt(i)  - '0') * (10 - i);
        }
        int digito1 = 11 - (soma % 11);
        digito1 = (digito1 >= 10) ? 0: digito1;

        soma = 0;
        for (int i = 0; i < 10; i++) {
            soma+=(cpf.charAt(i) - '0') * (11 - i);
        }
        int digito2 = 11 - (soma % 11);
        digito2 = (digito2 >= 10) ? 0: digito2;

        return (cpf.charAt(9) - '0') == digito1 && (cpf.charAt(10) - '0') == digito2;
    }

    private static final int IDADE_MINIMA = 6;

    public static void validacaoIdade(int idade){
        if (idade < IDADE_MINIMA){
            throw new IllegalArgumentException(MensagensValidacaoPessoa27.IDADE.getDescricaoFormatada(IDADE_MINIMA));
        }
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        validacaoNome(nome);
        this.nome = formatoNome(nome);
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        validacaoCpf(cpf);
        this.cpf = cpf;
    }

    public int getIdade() {
        return idade;
    }

    public void setIdade(int idade) {
        validacaoIdade(idade);
        this.idade = idade;
    }

    public enum MensagensValidacaoPessoa27{
        NOME("Digite nome completo. Campo nome não pode ser vazio ou conter caracteres."),
        IDADE("Idada não pode ser menor que %d."),
        CPF("CPF inválido.");

        private final String descricao;

        MensagensValidacaoPessoa27(String descricao){
            this.descricao = descricao;
        }

        public String getDescricao(){
            return descricao;
        }

        public String getDescricaoFormatada(double... valores){
            return String.format(descricao, Arrays.stream(valores).boxed().toArray());
        }

        public String getDescricaoFormatada(int... valores){
            return String.format(descricao, Arrays.stream(valores).boxed().toArray());
        }

    }

    @Override
    public String toString(){
        return String.format("Nome: %s |CPF: %s |Idade: %s",nome,cpf,idade);
    }
}
