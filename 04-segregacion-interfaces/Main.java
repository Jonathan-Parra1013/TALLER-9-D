import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<Vehiculo> vehiculos = new ArrayList<>();
        vehiculos.add(new VehiculoMensual("KLM321", "Camila Rojas", 180000));
        vehiculos.add(new VehiculoPorMinutos("XYZ45F", "Andrés Mora", 80, 1500));
        vehiculos.add(new VehiculoPorDia("ABC123", "María López", 3, 50000));
        vehiculos.add(new Bicicleta("BIC-07", "Valentina Díaz", 40000));

        GestorParqueadero gestor = new GestorParqueadero();
        NotificadorSMS notificador = new NotificadorSMS();
        ExportadorCSV exportador = new ExportadorCSV();
        
        gestor.cerrarMes(vehiculos, notificador);
        System.out.println(exportador.exportar(vehiculos, gestor));
    }
}