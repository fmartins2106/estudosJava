package academy.devdojo.maratonajava.javacore.Interface.dominio;

import academy.devdojo.maratonajava.javacore.excessoes.CategoriaProdutoInvalido32;
import academy.devdojo.maratonajava.javacore.excessoes.MesesGarantia32;

public class ProdutosNaoPereciveis32 extends ProdutoBase32 {
    private int mesesGarantia;
    private String categoria;

  public ProdutosNaoPereciveis32(String nome, double preco, int quantidade, int estoqueMinimo, int mesesGarantia, String categoria) {
    super(nome, preco, quantidade, estoqueMinimo);
    setMesesGarantia(mesesGarantia);
    setCategoria(categoria);
  }

  public static void validacaoGarantia(int mesesGarantia){
    if (mesesGarantia < MesesGarantia32.GARANTIA_MINIMA){
      throw new MesesGarantia32();
    }
  }

  public static void validacaoCategoria(String categoria){
    if (categoria == null || categoria.isEmpty() || !categoria.matches("^\\p{L}+( \\p{L}+)*$")){
      throw new CategoriaProdutoInvalido32();
    }
  }

  public int getMesesGarantia() {
    return mesesGarantia;
  }

  public void setMesesGarantia(int mesesGarantia) {
    validacaoGarantia(mesesGarantia);
    this.mesesGarantia = mesesGarantia;
  }

  public String getCategoria() {
    return categoria;
  }

  public void setCategoria(String categoria) {
    validacaoCategoria(categoria);
    this.categoria = categoria;
  }

  @Override
  public String toString() {
    return super.toString()+String.format(" |Meses garantia: %d |Categoria: %s",getMesesGarantia(),getCategoria());
  }
}
