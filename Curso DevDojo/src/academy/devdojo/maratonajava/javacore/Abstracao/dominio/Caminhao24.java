package academy.devdojo.maratonajava.javacore.Abstracao.dominio;

public class Caminhao24 extends Veiculo24{
    public Caminhao24(String placa, int anoFabricacao, String cor, double valorMercado) {
        super(placa, anoFabricacao, cor, valorMercado);
    }

    @Override
    public double calcularIPVA(){
        double aliquota = getAliquota();
        return valorMercado * aliquota;
    }

    @Override
    public void exibirDetalhes(){
        super.exibirDetalhes();
        System.out.println("Tipo: Caminhão.");
    }
}
