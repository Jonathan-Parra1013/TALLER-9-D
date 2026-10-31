 // Solo los vehículos elegibles implementan Fidelizable
public class VehiculoMensual extends Vehiculo implements Fidelizable {
    public VehiculoMensual(String placa, String propietario, double valorMensualidad) {
        super(placa, propietario, valorMensualidad, 0, 0);
    }

    @Override
    public double calcularCobro() { return valorMensualidad; }

    @Override
    public int calcularPuntos() {
        return (int) (valorMensualidad / 10000);
    }
}