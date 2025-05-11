<<<<<<< HEAD
package academy.devdojo.maratonajava.javacore.datas.dominio;

public class MultaFixadaPorDia33 implements CalculadoraMulta33{
    private double valorPorDia;

    public MultaFixadaPorDia33(double valorPorDia) {
        this.valorPorDia = valorPorDia;
    }

    @Override
    public double calcular(Fatura33 fatura33) {
        return fatura33.getDiasAtraso() * valorPorDia;
    }
}
=======
package academy.devdojo.maratonajava.javacore.datas.dominio;

public class MultaFixadaPorDia33 implements CalculadoraMulta33{
    private double valorPorDia;

    public MultaFixadaPorDia33(double valorPorDia) {
        this.valorPorDia = valorPorDia;
    }

    @Override
    public double calcular(Fatura33 fatura33) {
        return fatura33.getDiasAtraso() * valorPorDia;
    }
}
>>>>>>> a3d11752a9fc400590a7a4f4542f729c1f492e90
