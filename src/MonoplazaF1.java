public class MonoplazaF1 extends VehiculoCarrera {

    public MonoplazaF1(String nombre, double combustible) {
        super(nombre, combustible, 350);
    }

    @Override
    public void acelerar(int segundos) {
        aplicarAceleracion(segundos, 20, 2);
    }

    @Override
    public String obtenerDesempeno() {
        return "Traccion: alta | Velocidad maxima: 350 km/h";
    }
}