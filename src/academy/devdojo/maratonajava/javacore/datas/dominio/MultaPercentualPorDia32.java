<<<<<<< HEAD
package academy.devdojo.maratonajava.javacore.datas.dominio;

public class MultaPercentualPorDia32 implements CalculadoraMulta32{
    private double percentual;

    public MultaPercentualPorDia32(double percentual) {
        this.percentual = percentual;
    }

    @Override
    public double calcular(Fatura32 fatura32) {
        return fatura32.getDiasAtraso() * ((percentual / 100) * fatura32.getValor());
    }
}
=======
package academy.devdojo.maratonajava.javacore.datas.dominio;

public class MultaPercentualPorDia32 implements CalculadoraMulta32{
    private double percentual;

    public MultaPercentualPorDia32(double percentual) {
        this.percentual = percentual;
    }

    @Override
    public double calcular(Fatura32 fatura32) {
        return fatura32.getDiasAtraso() * ((percentual / 100) * fatura32.getValor());
    }
}
>>>>>>> a3d11752a9fc400590a7a4f4542f729c1f492e90
