package academy.devdojo.maratonajava.javacore.Abstracao.dominio;

import academy.devdojo.maratonajava.javacore.excessoes.*;

import java.text.DecimalFormat;
import java.time.Year;
import java.util.*;

public abstract class Veiculo33 {
    protected String placa;
    protected int anoFabricacao;
    protected String cor;
    protected double valorMercado;
    protected List<Double> historicoIPVA = new ArrayList<>();

    public Veiculo33(String placa, int anoFabricacao, String cor, double valorMercado) {
        setPlaca(placa);
        setAnoFabricacao(anoFabricacao);
        setCor(cor);
        setValorMercado(valorMercado);
    }

    public static void validacaoPlaca(String placa){
        if (placa == null || placa.isEmpty() || !placa.matches("^[A-Z]{3}[0-9]{4}$|^[A-Z]{3}[0-9][A-Z][0-9]{2}$")){
            throw new PlacaInvalidaException33();
        }
    }

    public static Set<String> placasCadastradas = new HashSet<>();

    public static void validacaoPlacaDuplicada(String placa){
        if (placasCadastradas.contains(placa)){
            throw new PlacaDuplicadaException33();
        }
    }

    public static void validacaoAnoFabricacao(int anoFabricacao){
        if (anoFabricacao < AnoFabricacaoException33.MENOR_ANO || anoFabricacao > AnoFabricacaoException33.MAIOR_ANO){
            throw new AnoFabricacaoException33();
        }
    }

    public static void validacaoCor(String cor){
        if (cor == null || cor.isEmpty() || !cor.matches("^\\p{L}+( \\p{L}+)*$")){
            throw new CorInvalidaException33();
        }
    }

    public static String formatoString(String nome){
        String[] palavras = nome.toLowerCase().split("\\s+");
        StringBuilder nomeFormatado = new StringBuilder();
        for (String palavra : palavras) {
            nomeFormatado.append(palavra.substring(0,1).toUpperCase())
                    .append(palavra.substring(1))
                    .append(" ");
        }
        return nomeFormatado.toString().trim();
    }

    public static void validacaoValorMercado(double valorMercado){
        if (valorMercado < ValorMercadoInvalidoExcepiton33.VALOR_MERCADO){
            throw new ValorMercadoInvalidoExcepiton33();
        }
    }

    public void setPlaca(String placa) {
        validacaoPlaca(placa);
        this.placa = placa;
        placasCadastradas.add(placa);
    }

    public void setAnoFabricacao(int anoFabricacao) {
        validacaoAnoFabricacao(anoFabricacao);
        this.anoFabricacao = anoFabricacao;
    }

    public void setCor(String cor) {
        validacaoCor(cor);
        this.cor = formatoString(cor);
    }

    public void setValorMercado(double valorMercado) {
        validacaoValorMercado(valorMercado);
        this.valorMercado = valorMercado;
    }

    public static final NavigableMap<Integer,Double> ALIQUOTAS = new TreeMap<>(Collections.reverseOrder());
    static {
        ALIQUOTAS.put(2025,0.04);
        ALIQUOTAS.put(2020,0.035);
        ALIQUOTAS.put(2015,0.03);
        ALIQUOTAS.put(2010,0.025);
        ALIQUOTAS.put(2005,0.02);
    }

    public boolean temMais20Anos(){
        int anoAtual = Year.now().getValue();
        int idadeVeiculo = anoAtual - anoFabricacao;
        return idadeVeiculo > 20;
    }

    public double getAliquota(){
        if (temMais20Anos()){
            return 0.00;
        }
        Map.Entry<Integer,Double> entry = ALIQUOTAS.floorEntry(anoFabricacao);
        return (entry != null) ? entry.getValue() : 0.00;
    }

    public void exibirDetalhes(){
        System.out.println("Placa:"+placa);
        System.out.println("Ano fabricação:"+anoFabricacao);
        System.out.println("Cor:"+cor);
        System.out.println("Valor de mercado:R$"+valorMercado);
    }

    public static final DecimalFormat df = new DecimalFormat("0.00");

    public void mostrarHistoricoPagamentoIPVA(){
        if (historicoIPVA.isEmpty()){
            System.out.println("Nenhum pagamento foi registrado.");
            return;
        }
        System.out.println("Histórico pagamento IPVA:");
        for (Double valor : historicoIPVA) {
            System.out.println("Valor:R$"+df.format(valor));
        }
    }

    public void registrarPagamentoIPVA(){
        double ipva = calcularIPVA();
        historicoIPVA.add(ipva);
        System.out.println("Pagamento registrado no valor de R$"+df.format(ipva)+" para placa:"+placa);
    }

    public abstract double calcularIPVA();

    @Override
    public String toString(){
        return String.format("Placa: %s |Ano de fabricação: %d |Cor: %s |Valor de mercado:R$%.2f.",
                placa,anoFabricacao,cor,valorMercado);
    }
}
