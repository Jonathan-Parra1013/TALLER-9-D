//Bicicleta ya no lanza excepción porque no implementa Fidelizable
public class Bicicleta extends Vehiculo {
    public Bicicleta(String placa, String propietario, double valorMensualidad) {
        super(placa, propietario, valorMensualidad, 0, 0);
    }

    @Override
    public double calcularCobro() {
        return valorMensualidad;
    }
}