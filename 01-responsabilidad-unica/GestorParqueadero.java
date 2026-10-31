import java.util.List;

public class GestorParqueadero {
    private RepositorioMySQL repositorio = new RepositorioMySQL();
    //se quito exportarCSV y enviarRecibo :b

    public double calcularCobro(Vehiculo v) {
        switch (v.getTipo()) {
            case "MENSUAL": return v.getValorMensualidad();
            case "MINUTOS": return v.getMinutos() * v.getTarifaMinuto();
            default: throw new IllegalArgumentException("Tipo desconocido: " + v.getTipo());
        }
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