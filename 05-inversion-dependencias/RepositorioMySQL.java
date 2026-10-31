// se implementa la interfaz Repositorio para cumplir con el principio de inversión de dependencias :)
public class RepositorioMySQL implements Repositorio {
    public RepositorioMySQL() {
        System.out.println("[MySQL] Conectando a jdbc:mysql://servidor/parqueadero ...");
    }

    @Override
    public void insertar(String placa, double cobro) {
        System.out.println("[MySQL] INSERT INTO cobros VALUES ('" + placa + "', " + cobro + ")");
    }
}