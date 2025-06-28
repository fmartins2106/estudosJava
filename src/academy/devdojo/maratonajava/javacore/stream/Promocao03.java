package academy.devdojo.maratonajava.javacore.stream;

public enum Promocao03 {
    PROMOCAO("Promoção"),
    PRECO_NORMAL("Preço normal");

    private final String descricao;

    Promocao03(String descricao) {
        this.descricao = descricao;
    }

    public String getDescricao() {
        return descricao;
    }



}
