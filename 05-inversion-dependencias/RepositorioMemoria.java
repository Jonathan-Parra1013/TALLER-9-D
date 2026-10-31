// implementación de la interfaz Repositorio para almacenamiento en memoria :D
import java.util.HashMap;
import java.util.Map;

public class RepositorioMemoria implements Repositorio {
    private Map<String, Double> cobros = new HashMap<>();

    @Override
    public void insertar(String placa, double cobro) {
        cobros.put(placa, cobro);
        System.out.println("[Memoria] Cobro guardado temporalmente: " + placa + " -> " + cobro);
    }
}