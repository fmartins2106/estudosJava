package academy.devdojo.maratonajava.javacore.heranca.dominio;

public class Funcionario02 {
    private String nome;
    private String departamento;
    private int idade;

    public Funcionario02(String nome, String departamento, int idade) {
        setNome(nome);
        setDepartamento(departamento);
        setIdade(idade);
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        validandoString(nome);
        this.nome = formatoNome(nome);
    }

    public String getDepartamento() {
        return departamento;
    }

    public void setDepartamento(String departamento) {
        validandoString(departamento);
        this.departamento = formatoNome(departamento);
    }

    public int getIdade() {
        return idade;
    }

    private static final int IDADE_MINIMA =18;
    public void setIdade(int idade) {
        if (idade < IDADE_MINIMA){
            throw new IllegalArgumentException("idade não pode ser menor que 18.");
        }
        this.idade = idade;
    }

    public void validandoString(String palavra){
        if (palavra == null || palavra.isEmpty() || !palavra.matches("^[\\p{L}]+( [\\p{L}]+)+$")){
                throw new IllegalArgumentException("Campo "+palavra+" não pode ficar vazio ou conter caracteres.");
        }
    }

    public static String formatoNome(String nome){
        String[] palavras = nome.split("\\s+");
        StringBuilder formatarNome = new StringBuilder();
        for (String palavra : palavras){
            formatarNome.append(palavra.substring(0,1).toUpperCase())
                    .append(palavra.substring(1))
                    .append(" ");
        }
        return formatarNome.toString().trim();
    }

    @Override
    public String toString(){
        return String.format("Nome: %s |Departamento: %s |Idade: %d",nome,departamento,idade);
    }

}
