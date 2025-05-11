<<<<<<< HEAD
package academy.devdojo.maratonajava.javacore.datas.dominio;

public class MultaFixadaPorDia32 implements CalculadoraMulta32{
    private double valorPorDia;

    public MultaFixadaPorDia32(double valorPorDia) {
        this.valorPorDia = valorPorDia;
    }

    @Override
    public double calcular(Fatura32 fatura32) {
        return fatura32.getDiasAtraso() * valorPorDia;
    }
}
=======
package academy.devdojo.maratonajava.javacore.datas.dominio;

public class MultaFixadaPorDia32 implements CalculadoraMulta32{
    private double valorPorDia;

    public MultaFixadaPorDia32(double valorPorDia) {
        this.valorPorDia = valorPorDia;
    }

    @Override
    public double calcular(Fatura32 fatura32) {
        return fatura32.getDiasAtraso() * valorPorDia;
    }
}
>>>>>>> a3d11752a9fc400590a7a4f4542f729c1f492e90
