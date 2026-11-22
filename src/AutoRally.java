public class AutoRally extends VehiculoCarrera {

    public AutoRally(String nombre, double combustible) {
        super(nombre, combustible, 250);
    }

    @Override
    public void acelerar(int segundos) {
        aplicarAceleracion(segundos, 12, 1.5);
    }

    @Override
    public String obtenerDesempeno() {
        return "Traccion: integral | Velocidad maxima: 250 km/h";
    }
}