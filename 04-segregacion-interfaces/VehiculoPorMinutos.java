// otra clase hija para cobro por minutos
public class VehiculoPorMinutos extends Vehiculo {
    public VehiculoPorMinutos(String placa, String propietario, int minutos, double tarifaMinuto) {
        super(placa, propietario, 0, tarifaMinuto, minutos);
    }

    @Override
    public double calcularCobro() {
        return minutos * tarifaMinuto;
    }
}