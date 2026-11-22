public class Motocicleta extends VehiculoCarrera {

    public Motocicleta(String nombre, double combustible) {
        super(nombre, combustible, 300);
    }

    @Override
    public void acelerar(int segundos) {
        aplicarAceleracion(segundos, 16, 1.2);
    }

    @Override
    public String obtenerDesempeno() {
        return "Traccion: trasera | Velocidad maxima: 300 km/h";
    }
}