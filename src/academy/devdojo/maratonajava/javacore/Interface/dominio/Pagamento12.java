package academy.devdojo.maratonajava.javacore.Interface.dominio;

public interface Pagamento12 {
    boolean verificarSaldo(double valor);
    void processarPagamentos(double valor);
    void saldoDisponivel();
}
