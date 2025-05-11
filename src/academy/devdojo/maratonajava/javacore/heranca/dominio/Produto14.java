package academy.devdojo.maratonajava.javacore.heranca.dominio;

public class Produto14 {
    private int codigo;
    private String nome;
    private String categoria;
    private int quantidade;
    private double precoCompra;
    private double precoVenda;
    private String fornecedor;

    public Produto14(int codigo, String nome, String categoria, int quantidade, double precoCompra, double precoVenda, String fornecedor) {
        setCodigo(codigo);
        setNome(nome);
        setCategoria(categoria);
        setQuantidade(quantidade);
        setPrecoCompra(precoCompra);
        setPrecoVenda(precoVenda);
        setFornecedor(fornecedor);
    }

    public static final int MENOR_CODIGO = 1;
    public static final String MENSAGEM_ERRO_CODIGO = "Código não pode ser menor que 1.";
    public static final String MENSAGEM_ERRO_NOME = "Campo nome não pode ser vazio ou conter caracteres.";
    public static final String MENSAGEM_ERRO_CATEGORIA="Campo categoria não pode ser vazio ou conter caracteres";
    public static final int MENOR_QUANTIDADE = 0;
    public static final String MENSAGEM_MENOR_QUANTIDADE = "Campo quantidade não pode ser menor que zero;";
    public static final double MENOR_PRECO_COMPRA = 0;
    public static final String MENSAGEM_ERRO_PRECO_COMPRA = "Preço de compra não pode ser menor que zero.";
    public static final String MENSAGEM_ERRO_PRECO_VENDA = "Preço de venda não pode ser menor que preço de compra.";
    public static final String MENSAGEM_ERRO_FORNECEDOR = "Campo fornecedor não pode ser vazio ou conter caracteres.";

    private void validacaoCodigo(int codigo){
        if (codigo < MENOR_CODIGO){
            throw new IllegalArgumentException(MENSAGEM_ERRO_CODIGO);
        }
    }

    private void validacaoNome(String nome){
        if (nome == null || nome.isEmpty() || !nome.matches("^[\\p{L}]+( [\\p{L}]+)+$")){
            throw new IllegalArgumentException(MENSAGEM_ERRO_NOME);
        }
    }

    private void validacaoCategoria(String categoria){
        if (categoria == null || categoria.isEmpty() || !categoria.matches("^[\\p{L}]+( [\\p{L}]+)*$")){
            throw new IllegalArgumentException(MENSAGEM_ERRO_CATEGORIA);
        }
    }

    private void validacaoQuantidade(int quantidade){
        if (quantidade <MENOR_QUANTIDADE){
            throw new IllegalArgumentException(MENSAGEM_MENOR_QUANTIDADE);
        }
    }

    private void validacaoPrecoCompra(double precoCompra){
        if (precoCompra <MENOR_PRECO_COMPRA){
            throw new IllegalArgumentException(MENSAGEM_ERRO_PRECO_COMPRA);
        }
    }

    private void validacaoPrecoVenda(double precoVenda){
        if (precoVenda < precoCompra){
            throw new IllegalArgumentException(MENSAGEM_ERRO_PRECO_VENDA);
        }
    }

    private void validacaoFornecedor(String fornecedor){
        if (fornecedor == null || fornecedor.isEmpty() || !fornecedor.matches("^[\\p{L}]+( [\\p{L}]+)+$")){
            throw new IllegalArgumentException(MENSAGEM_ERRO_FORNECEDOR);
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

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        validacaoCodigo(codigo);
        this.codigo = codigo;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        validacaoNome(nome);
        this.nome = formatoNome(nome);
    }

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        validacaoCategoria(categoria);
        this.categoria = formatoNome(categoria);
    }

    public int getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(int quantidade) {
        validacaoQuantidade(quantidade);
        this.quantidade = quantidade;
    }

    public double getPrecoCompra() {
        return precoCompra;
    }

    public void setPrecoCompra(double precoCompra) {
        validacaoPrecoCompra(precoCompra);
        this.precoCompra = precoCompra;
    }

    public double getPrecoVenda() {
        return precoVenda;
    }

    public void setPrecoVenda(double precoVenda) {
        validacaoPrecoVenda(precoVenda);
        this.precoVenda = precoVenda;
    }

    public String getFornecedor() {
        return fornecedor;
    }

    public void setFornecedor(String fornecedor) {
        validacaoFornecedor(fornecedor);
        this.fornecedor = formatoNome(fornecedor);
    }

    @Override
    public String toString(){
        return String.format("Código: %d |Nome: %s |Categoria: %s |Quantidade: %d |Preço compra:R$ %.2f |Preço venda:R$ %.2f |Fornecedor: %s",
                codigo,nome,categoria,quantidade,precoCompra,precoVenda,fornecedor);
    }
}
