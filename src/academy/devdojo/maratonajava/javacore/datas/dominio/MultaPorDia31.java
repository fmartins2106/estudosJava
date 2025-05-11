<<<<<<< HEAD
package academy.devdojo.maratonajava.javacore.datas.dominio;

public class MultaPorDia31 implements CalculadoraMulta31 {
    private double valorPorDia;

    public MultaPorDia31(double valorPorDia) {
        this.valorPorDia = valorPorDia;
    }

    @Override
    public double calcular(Fatura31 fatura31) {
        return fatura31.getDiasAtraso() * valorPorDia;
    }
}
=======
package academy.devdojo.maratonajava.javacore.datas.dominio;

public class MultaPorDia31 implements CalculadoraMulta31 {
    private double valorPorDia;

    public MultaPorDia31(double valorPorDia) {
        this.valorPorDia = valorPorDia;
    }

    @Override
    public double calcular(Fatura31 fatura31) {
        return fatura31.getDiasAtraso() * valorPorDia;
    }
}
>>>>>>> a3d11752a9fc400590a7a4f4542f729c1f492e90
