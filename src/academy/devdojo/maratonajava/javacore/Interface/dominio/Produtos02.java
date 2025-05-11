package academy.devdojo.maratonajava.javacore.Interface.dominio;

public interface Produtos02 {
    String getNome();
    double getPreco();
    int getQuantidade();
    int getEstoqueMinimo();
    double calcularValorTotal();
    void aumentarQuantidade(int quantidade);
    void diminuirQuantidade(int quantidade);
    void verificarEstoqueMinimo();
}
