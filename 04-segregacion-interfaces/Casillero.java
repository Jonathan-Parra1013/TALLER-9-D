// Paso 4: Casillero implementa únicamente lo que necesita, sin métodos vacíos
public class Casillero implements Registrable {
    private String codigo;
    private String usuario;
    private double tarifaMinuto;
    private int minutos;

    public Casillero(String codigo, String usuario, double tarifaMinuto) {
        this.codigo = codigo;
        this.usuario = usuario;
        this.tarifaMinuto = tarifaMinuto;
    }

    @Override
    public void registrarMinutos(int minutos) { this.minutos += minutos; }

    public double valorAlquiler() { return minutos * tarifaMinuto; }
}