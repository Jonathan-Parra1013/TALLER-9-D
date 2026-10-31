// Se elimina calcularPuntos() de la clase base Vehiculo
public abstract class Vehiculo implements Registrable, Asegurable, Lavable {
    protected String placa;
    protected String propietario;
    protected double valorMensualidad;
    protected double tarifaMinuto;
    protected int minutos;
    protected int lavados;

    public Vehiculo(String placa, String propietario, 
                    double valorMensualidad, double tarifaMinuto, int minutos) {
        this.placa = placa;
        this.propietario = propietario;
        this.valorMensualidad = valorMensualidad;
        this.tarifaMinuto = tarifaMinuto;
        this.minutos = minutos;
    }

    public String getPlaca()            { return placa; }
    public String getPropietario()      { return propietario; }
    public double getValorMensualidad() { return valorMensualidad; }
    public double getTarifaMinuto()     { return tarifaMinuto; }
    public int getMinutos()             { return minutos; }


    public void registrarMinutos(int minutos) { this.minutos += minutos; }
    public double calcularSeguro()            { return valorMensualidad * 0.02; }
    public void solicitarLavados(int cantidad) { this.lavados += cantidad; }

    public abstract double calcularCobro();
}