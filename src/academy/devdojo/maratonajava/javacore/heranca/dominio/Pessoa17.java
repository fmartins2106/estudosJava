package academy.devdojo.maratonajava.javacore.heranca.dominio;

public class Pessoa17 {
    private String nome;
    private String cpf;
    private int idade;

    public Pessoa17(String nome, String cpf, int idade) {
        setNome(nome);
        setCpf(cpf);
        setIdade(idade);
    }

    public static final int IDADE_MINIMA =6;

    private void validacaoNome(String nome){
        if (nome == null || nome.isEmpty() || !nome.matches("^[\\p{L}]+( [\\p{L}]+)+$")){
            throw new IllegalArgumentException(MensagensErroPessoa17.ERRO_NOME.getDescricao());
        }
    }

    public static String formatoNome(String nome){
        String[] palavras = nome.toLowerCase().split("\\s+");
        StringBuilder nomeFormatado = new StringBuilder();
        for (String palavra : palavras){
            nomeFormatado.append(palavra.substring(0,1).toUpperCase())
                    .append(palavra.substring(1))
                    .append(" ");
        }
        return nomeFormatado.toString().trim();
    }

    private void validacaoCpf(String cpf){
        if (cpf == null || cpf.length() !=11 || !cpf.matches("\\d{11}") || !isCpfValido(cpf)){
            throw new IllegalArgumentException(MensagensErroPessoa17.ERRO_CPF.getDescricao());
        }
    }

    private boolean isCpfValido(String cpf){
        if (cpf.chars().distinct().count() == 11){
            return false;
        }
        int soma = 0;
        for (int i = 0; i < 9; i++) {
            soma+=(cpf.charAt(i) - '0') * (10 - i);
        }
        int digito1 = 11 - (soma % 11);
        digito1 = (digito1 >= 10) ? 0: digito1;

        soma =0;
        for (int i = 0; i < 10; i++) {
            soma+=(cpf.charAt(i) - '0') * (11 - i);
        }
        int digito2 = 11 - (soma % 11);
        digito2 = (digito2 >= 10) ? 0: digito2;

        return (cpf.charAt(9) - '0') == digito1 && (cpf.charAt(10) - '0') == digito2;
    }

    public void validacaoIdade(int idade){
        if (idade < IDADE_MINIMA){
            System.out.println(MensagensErroPessoa17.ERRO_IDADE.getDescricao());
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

    public enum MensagensErroPessoa17{
        ERRO_NOME("Campo nome não pode ser vazio ou conter caracteres."),
        ERRO_CPF("CPF inválido."),
        ERRO_DISCIPLINA("Campo disciplina não pode ser vazio ou conter caracteres."),
        ERRO_SALARIO("Salário de professor não pode ser menor que R$3.500"),
        ERRO_MATRICULA("Matricula não pode ser menor que 1."),
        ERRO_NOTAS("Nota não pode ser menor que 0 ou maior que 10."),
        ERRO_IDADE("Idade não pode ser menor que 6.");

        private final String descricao;

        MensagensErroPessoa17(String descricao){
            this.descricao = descricao;
        }

        public String getDescricao(){
            return descricao;
        }

    }

    @Override
    public String toString(){
        return String.format("Nome: %s |CPF: %s |Idade: %s ",nome,cpf,idade);
    }

}
