import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<Vehiculo> vehiculos = new ArrayList<>();
        vehiculos.add(new VehiculoMensual("KLM321", "Camila Rojas", 180000));
        vehiculos.add(new VehiculoPorMinutos("XYZ45F", "Andrés Mora", 80, 1500));
        vehiculos.add(new Bicicleta("BIC-07", "Valentina Díaz", 40000));
        vehiculos.add(new VehiculoPorDia("DIA-01", "Luis Perez", 3, 25000));

        // se prueban las dependencias con la interfaz Repositorio
        Repositorio repoMySQL = new RepositorioMySQL();
        Repositorio repoMemoria = new RepositorioMemoria();
        GestorParqueadero gestor = new GestorParqueadero(repoMemoria);
        
        NotificadorSMS notificador = new NotificadorSMS();
        ExportadorCSV exportador = new ExportadorCSV();
        
        gestor.cerrarMes(vehiculos, notificador);
        System.out.println(exportador.exportar(vehiculos, gestor));
    }
}