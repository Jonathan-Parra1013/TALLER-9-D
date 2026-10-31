import java.util.List;

public class GestorParqueadero {
    //Depende de la interfaz y se inicia por constructor
    private Repositorio repositorio;

    public GestorParqueadero(Repositorio repositorio) {
        this.repositorio = repositorio;
    }

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