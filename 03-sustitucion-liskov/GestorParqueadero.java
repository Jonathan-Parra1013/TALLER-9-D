import java.util.List;

public class GestorParqueadero {
    private RepositorioMySQL repositorio = new RepositorioMySQL();

    // se quito el switch case y se delega el calculo de cobro a la clase Vehiculo
    public double calcularCobro(Vehiculo v) {
        return v.calcularCobro();
    }

    public void guardar(Vehiculo v, double cobro) {
        repositorio.insertar(v.getPlaca(), cobro);
    }
    
    public void cerrarMes(List<Vehiculo> vehiculos, NotificadorSMS notificador) {
        for (Vehiculo v : vehiculos) {
            double cobro = calcularCobro(v);
            guardar(v, cobro);
            notificador.enviarRecibo(v, cobro);
        }
    }
}