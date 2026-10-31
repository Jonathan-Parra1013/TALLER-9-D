// clase hija para cobro por dia :b
public class VehiculoPorDia extends Vehiculo {
    private int dias;
    private double tarifaDia;

    public VehiculoPorDia(String placa, String propietario, int dias, double tarifaDia) {
        super(placa, propietario, 0, 0, 0);
        this.dias = dias;
        this.tarifaDia = tarifaDia;
    }

    @Override
    public double calcularCobro() {
        return dias * tarifaDia;
    }
}