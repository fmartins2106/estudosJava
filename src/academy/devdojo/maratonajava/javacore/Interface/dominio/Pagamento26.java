package academy.devdojo.maratonajava.javacore.Interface.dominio;

public interface Pagamento26 {
    boolean verificarSaldo(double valor);
    void processarPagamentos(double valor);
    void consultarSaldo();
}
