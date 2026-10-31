public class Bicicleta extends VehiculoMensual {

    public Bicicleta(String codigo, String propietario, double valorMensualidad) {
        super(codigo, propietario, valorMensualidad);
    }

    @Override
    public int calcularPuntos() {
        throw new UnsupportedOperationException(
            "Las bicicletas no acumulan puntos de fidelidad");
    }
}
